import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

class NoozFileProcessor {

	private static NewsMakerListModel newsMakers = new NewsMakerListModel();
	
	private static NewsStoryListModel newsStories;
	
	private static NewsDataBaseModel newsDataBase;

	public static NewsDataBaseModel readNoozFile(String fileName, Map<String, String> sourceMap,
			Map<String, String> topicMap, Map<String, String> subjectMap) throws IOException {
		// TODO Handle possible I/O errors (Eventually)
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String nextLine = br.readLine(); // First line is header info. Ignore.
		nextLine = br.readLine();
		while (nextLine != null) {
			processLine(nextLine, sourceMap, topicMap, subjectMap);
			nextLine = br.readLine();
		}
		br.close();

		return newsDataBase;
	}

	public static void writeNewsTextFile(String FileName, String listOfStories) throws IOException {
		FileWriter outfile = new FileWriter(outputFileName);
		BufferedWriter bw = new BufferedWriter(outfile);
		bw.write(listOfStories);
		bw.newLine();
		bw.close();
	}

	private static void processLine(String line, Map<String, String> sourceMap, Map<String, String> topicMap,
			Map<String, String> subjectMap) {
		/* The parts the line created by splitting the line at each comma. */
		String[] parts = line.split(",");

		/* The local date from part zero of the line. */
		LocalDate date = decodeDate(parts[0]);

		/* The source from part one of the line. */
		String sourceCode = parts[1];
		String source = sourceMap.get(sourceCode);
		if (source == null) {
			System.err.println("No matching source map entry for " + sourceCode + ". Skipping line.");
			return;
		}

		/* The word count from part two of the line. */
		int wordCount = decodeLength(parts[2]);

		/* The subject from part three of the line. */
		String subject = subjectMap.get(parts[3]);
		if (subject == null) {
			System.err.println("No matching subject map entry for " + parts[3] + ". Skipping line.");
			return;
		}

		/* The topic from part four of the line. */
		String topic = topicMap.get(parts[4]);
		if (topic == null) {
			System.err.println("No matching topic map entry for " + parts[4] + ". Skipping line.");
			return;
		}

		/*
		 * The first news maker name, which might come from just part four or
		 * from parts four and five, depending on whether it contains a comma.
		 */
		String newsMakerName1 = decodeNewsmakerName(parts, 5);

		/*
		 * The second news maker name, which might start with part five or part
		 * six, depending on the first news maker name.
		 */
		String newsMakerName2;
		if (newsMakerName1.contains(",")) {
			newsMakerName2 = decodeNewsmakerName(parts, 7);
		} else {
			newsMakerName2 = decodeNewsmakerName(parts, 6);
		}

		/*
		 * The first news maker is constructed based on the first news maker
		 * name read.
		 */
		NewsMaker newsMaker1 = new NewsMaker(newsMakerName1);
		// If the news maker is on the list, use the copy already on the list
		if (newsMakers.contains(newsMaker1)) {
			newsMaker1 = newsMakers.get(newsMaker1);
		}
		// Otherwise, add the new news maker to the list
		else {
			newsMakers.add(newsMaker1);
		}

		/*
		 * The second news maker is constructed based on the second news maker
		 * name read.
		 */
		NewsMaker newsMaker2 = new NewsMaker(newsMakerName2);
		// If the news maker is on the list, use the copy already on the list
		if (newsMakers.contains(newsMaker2)) {
			newsMaker2 = newsMakers.get(newsMaker2);
		}
		// Otherwise, add the new news maker to the list
		else {
			newsMakers.add(newsMaker2);
		}

		/*
		 * The news story, which is constructed from the relevant data.
		 */
		int sourceNum = 0;
		try {
			sourceNum = Integer.parseInt(sourceCode);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Non-integer as source code: " + sourceCode);
		}

		NewsStory newsStory = null;

		// Below 200 is newspaper.
		if (sourceNum < 200) {
			newsStory = new NewspaperStory(date, source, wordCount, topic, subject, newsMaker1, newsMaker2);
		}
		// Between 200 and 400 is online news.
		else if (sourceNum < 400) {
			// The part of day from the last field (only for TV news stories)
			PartOfDay partOfDay = decodePartOfDay(parts[parts.length - 1]);
			newsStory = new OnlineNewsStory(date, source, wordCount, topic, subject, partOfDay, newsMaker1, newsMaker2);
		}
		// Between 400 and 600 is TV news
		else if (sourceNum < 600) {
			// The part of day from the last field (only for TV news stories)
			PartOfDay partOfDay = decodePartOfDay(parts[parts.length - 1]);
			newsStory = new TVNewsStory(date, source, wordCount, topic, subject, partOfDay, newsMaker1, newsMaker2);
		}
		// TODO: Check for invalid source num.

		// The news story is added to each news maker
		newsMaker1.addNewsStory(newsStory);
		newsMaker2.addNewsStory(newsStory);
	}

	/**
	 * This method decodes the date, which is encoded in the file as YYYYMMDD.
	 * <P>
	 * This method catches <code>NumberFormatExceptions</code> and deals with
	 * them locally by printing messages to the error stream. In later
	 * assignments, we'll cover better alternatives for handling exceptions.
	 * </P>
	 * 
	 * @param dateString
	 *            The encoded date.
	 * @return The decoded date or <code>null</code> if the date cannot be
	 *         decoded.
	 */
	private static LocalDate decodeDate(String dateString) {

		/* The year portion of the date string. */
		String yearString = dateString.substring(0, 4);

		/* The month portion of the date string. */
		String monthString = dateString.substring(4, 6);

		/* The day portion of the date string. */
		String dayOfMonthString = dateString.substring(6, 8);

		/* The year as an integer (hopefully). */
		int year = 0;
		try {
			year = Integer.parseInt(yearString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + year + ") is not an integer.");
			return null;
		}

		/* The month as an integer (hopefully). */
		int month = 0;
		try {
			month = Integer.parseInt(monthString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + month + ") is not an integer.");
			return null;
		}

		/* The month as an integer (hopefully). */
		int dayOfMonth = 0;
		try {
			dayOfMonth = Integer.parseInt(dayOfMonthString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + dayOfMonth + ") is not an integer.");
			return null;
		}

		/*
		 * The date constructed from the year, month, and dayOfMonth integers.
		 */
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		return date;
	}

	/**
	 * This method decodes the length, which is encoded in the file as numeral
	 * string.
	 * <P>
	 * This method catches <code>NumberFormatExceptions</code> and deals with
	 * them locally by printing messages to the error stream. In later
	 * assignments, we'll cover better alternatives for handling exceptions.
	 * </P>
	 * 
	 * @param lengthString
	 *            The length as a String.
	 * @return The length as an int.
	 */
	private static int decodeLength(String lengthString) {
		int length = 0;

		try {
			length = Integer.parseInt(lengthString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Non-integer as length: " + lengthString);
		}

		return length;
	}

	/**
	 * This method decodes a news maker name from one or more the parts of the
	 * input line.
	 * <P>
	 * Note that there are three distinctly different cases that need to be
	 * dealt with by this method.
	 * </P>
	 * <ul>
	 * <li>First, the special code "99" in the file corresponds to the case when
	 * the story is not primarily focused on two named news makers. In these
	 * cases, the code "99" may be used for one or both of the news maker
	 * fields. We decode this as a news maker with the name "None" and allow the
	 * user to explicitly or implicitly search for this news maker.</li>
	 * <li>Second, there may be a news maker with a quoted name containing no
	 * commas. ("Obama Administration" is one example.) In this case, the line
	 * parsed on commas will include this news maker name in a single line
	 * part.</li>
	 * <li>Third, there may be a news maker with a quoted name containing one
	 * comma. ("Romney, Mitt" is one example.) In this case, the line parsed on
	 * commas will include this news maker name in two line parts. These parts
	 * must be put together to create the news maker name.</li>
	 * </ul>
	 * 
	 * @param parts
	 *            The array of all of the parts of the line, which was separated
	 *            based on commas.
	 * @param startingIndex
	 *            The starting index for the news maker name to decode. This can
	 *            vary for the second news maker based on whether the first news
	 *            maker name contained a comma.
	 * @return The decoded news maker name.
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		String nameString = "";

		// Check for special code 99
		if ("99".equals(parts[startingIndex])) {
			nameString = "None";
		}
		// If the starting part of the name ends with a quotation mark, then the
		// name takes up only one part
		else if (parts[startingIndex].endsWith("\"")) {
			nameString = parts[startingIndex].replaceAll("\"", "");
		}
		// The other option is that the name takes up two parts, which must be
		// put together.
		else {
			nameString = (parts[startingIndex] + "," + parts[startingIndex + 1]).replaceAll("\"", "");
		}

		return nameString;
	}

	/**
	 * This method decodes the part of the day, which is represented by a
	 * numeral in the data file.
	 * 
	 * The numeric codes are as follows:
	 * <dl>
	 * <dt>1:</dt>
	 * <dd>Morning</dd>
	 * <dt>2:</dt>
	 * <dd>Afternoon</dd>
	 * <dt>4:</dt>
	 * <dd>Evening</dd>
	 * <dt>6:</dt>
	 * <dd>Late Night</dd>
	 * </dl>
	 * 
	 * @param partOfDayCode
	 *            The numeral specifying the part of the day.
	 * @return The part of the day as one of the enumerated values of PartOfDay
	 *         (or null for an invalid code).
	 */
	private static PartOfDay decodePartOfDay(String partOfDayCode) {
		switch (partOfDayCode) {
		case "1":
			return PartOfDay.MORNING;
		case "2":
			return PartOfDay.AFTERNOON;
		case "4":
			return PartOfDay.EVENING;
		case "6":
			return PartOfDay.LATE_NIGHT;
		default:
			throw new IllegalArgumentException("Invalid part of day code: " + partOfDayCode);
		}
	}
}
