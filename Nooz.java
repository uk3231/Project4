import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * Project 3, CS 2334, Section 010, March 8, 2017
 * <P>
 * Nooz is the driver class for Nooz, a simple newspaper story data system.
 * Because user interaction with the date is focused on news makers, the primary
 * data structure used by the driver is a <code>NewsMakerList</code>, which is
 * used within <code>main</code>.
 * </P>
 *
 * @author Dean Hougen
 * @version 3.0
 */
class Nooz {
	/** The list of news makers. */
	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * The map from source code numerals used in the Nooz data file to the names
	 * of the sources.
	 */
	private static Map<String, String> sourceMap;

	/**
	 * The map from topic code numerals used in the Nooz data file to the
	 * descriptions of the topics.
	 */
	private static Map<String, String> topicMap;

	/**
	 * The map from topic code numerals used in the Nooz data file to the
	 * descriptions of the topics.
	 */
	private static Map<String, String> subjectMap;

	/**
	 * The main method creates the objects necessary to do the work, then lets
	 * them do it.
	 * <P>
	 * Main delegates most of its work to two helper methods. One handles
	 * reading in the data. The other handles the main user interaction loop.
	 * </P>
	 * <P>
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * </P>
	 * 
	 * @param args
	 *            The program arguments are not used in this program.
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 * @throws ClassNotFoundException
	 *             If there is a data problem with the binary read.
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// There should be no program arguments supplied
		if (args.length != 0) {
			// If the calling process specifies the wrong number of program
			// arguments, give an error message and exit with non-zero exit code
			System.err.println("Usage error. Program arguments are not used by this program.");
			System.exit(1);
		}

		loadData();

		// Sort the news makers
		newsMakers.sort();

		loopForUserQueries();
	}

	/**
	 * This helper method loads the data from either a set of four text files or
	 * a single binary file
	 * 
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 * @throws ClassNotFoundException
	 *             If there is a data problem with the binary read.
	 */
	private static void loadData() throws IOException, ClassNotFoundException {
		String textInput = UserInterface.querySingleChoice("Read text or binary data (t or b)? ",
				new String[] { "t", "b" });
		if ("t".equals(textInput)) {
			String sourceCodeFileName = UserInterface.queryFileName("Enter the name of the news source data file: ",
					true);
			// Need to make copy. Cannot simply assign reference.
			sourceMap = new TreeMap<String, String>(CodeFileProcessor.readCodeFile(sourceCodeFileName));

			String topicCodeFileName = UserInterface.queryFileName("Enter the name of the news topic data file: ",
					true);
			// Need to make copy. Cannot simply assign reference.
			topicMap = new TreeMap<String, String>(CodeFileProcessor.readCodeFile(topicCodeFileName));

			String subjectCodeFileName = UserInterface.queryFileName("Enter the name of the news subject data file: ",
					true);
			// Need to make copy. Cannot simply assign reference.
			subjectMap = new TreeMap<String, String>(CodeFileProcessor.readCodeFile(subjectCodeFileName));

			// Prompt user for name of data file.
			String inputFileName = UserInterface.queryFileName("Enter the name of the news story text data file: ",
					true);

			// Read file putting NewsMakers in the NewsMakerList
			// TODO Handle possible I/O errors (Eventually)
			newsMakers = NoozFileProcessor.readNoozFile(inputFileName, sourceMap, topicMap, subjectMap);

			if (UserInterface.queryBoolean("Save data in binary format")) {
				String outputFileName = UserInterface
						.queryFileName("Enter the name of the file to write news story binary data: ", false);
				FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(newsMakers);
				objectOutputStream.close();
			}

		} else {
			String inputFileName = UserInterface.queryFileName("Enter the name of the news story binary data file: ",
					true);
			FileInputStream fileInputStream = new FileInputStream(inputFileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			newsMakers = (NewsMakerList) objectInputStream.readObject();
			objectInputStream.close();
		}
	}

	/**
	 * This helper method handles the main user interaction loop, from "Search
	 * newspapers ... " to "Continue (y/n)?"
	 * 
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 */
	private static void loopForUserQueries() throws IOException {
		boolean loop = true;
		// Enter GUI loop
		while (loop) {
			// Prompt user for type of media to search.
			String mediaType = UserInterface.queryMultipleChoices(
					"Search newspapers, TV news, and/or online news sources (n, t, and/or o)? ",
					new String[] { "n", "t", "o" });

			String matchType = UserInterface.querySingleChoice(
					"Search news makers by exact or partial matches (e or p)? ", new String[] { "e", "p" });

			// Get the name of the news maker from the user
			String newsMakerName = UserInterface.queryNewsMakerName(matchType);

			NewsMaker foundNewsMaker;
			// Get the news maker from the list of news makers
			if (matchType.equals("e")) {
				foundNewsMaker = newsMakers.getExactMatch(newsMakerName);
			}
			// Otherwise, must be partial
			else {
				foundNewsMaker = newsMakers.getPartialMatch(newsMakerName);
			}

			// If no news maker with that name found, tell user
			if (foundNewsMaker == null) {
				UserInterface.reportNewsmakerNotFound(new NewsMaker(newsMakerName));
			}

			// Otherwise, determine type of output desired
			else {
				String graphOrText = UserInterface.querySingleChoice("Display text or graph (t or g)? ",
						new String[] { "t", "g" });

				if (graphOrText.equals("t")) {

					// Determine the sort criteria to be used
					String[] sortCriteria = { "", "", "", "" };
					sortCriteria[0] = UserInterface.querySortCriterion(sortCriteria);
					sortCriteria[1] = UserInterface.querySortCriterion(sortCriteria);
					sortCriteria[2] = UserInterface.querySortCriterion(sortCriteria);
					sortCriteria[3] = "stld".replace(sortCriteria[0], "");
					sortCriteria[3] = sortCriteria[3].replace(sortCriteria[1], "");
					sortCriteria[3] = sortCriteria[3].replace(sortCriteria[2], "");

					String listOfStories = UserInterface.createListOfNewsStoriesForNewsmaker(foundNewsMaker, mediaType,
							sortCriteria);

					// And show the list of stories to the user
					UserInterface.presentNewspaperStories(listOfStories, foundNewsMaker.getName());

					if (UserInterface.queryBoolean("Save")) {
						String textOrBinary = UserInterface.querySingleChoice("Write text or binary data (t or b)? ",
								new String[] { "b", "t" });
						String outputFileName = UserInterface.queryFileName("Enter the name of the file to save to: ",
								false);

						if (textOrBinary.equals("t")) {
							NoozFileProcessor.writeNewsStoriesFile(outputFileName, listOfStories);
						} else {
							FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
							ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
							objectOutputStream.writeObject(foundNewsMaker);
							objectOutputStream.close();
						}
					}
				} else {
					String content = UserInterface.querySingleChoice("Graph source, topic, or big story (s, t, or b)? ",
							new String[] { "s", "t", "b" });
					String measure = UserInterface.querySingleChoice("Graph by length or count (l or c)? ",
							new String[] { "l", "c" });
					UserInterface.displayPieChartForNewsMaker(foundNewsMaker, mediaType, content, measure);
				}
			}

			loop = UserInterface.queryBoolean("Continue");
		}
		System.out.println("Thanks for using Nooz.");
		System.exit(0);
	}
}
