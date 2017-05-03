import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Uday Kohli, Dr. Hougen, Jon Kunjummen
 * 
 * Uday wrote some methods and modified some of Dr. Hougen's code
 * Jon helped with debugging
 *
 */
public class TextView implements ActionListener{
	
	private JFrame jfText;
	
	private NewsMakerModel newsMakerModel;
	
	private List<NewsMedia> newsMedia;
	
	private List<SortCriterion> sortCriteria;
	
	private String listOfStories;
	
	private String summaryLine;
	
	private JTextArea jtaNewsStoryList; 
	
	private JScrollPane jspNewsStoryList;
	
	private JTextArea jtaSummaryLine;
	
	
	public TextView(NewsMakerModel newsMakerModel, 
			List<NewsMedia> newsMedia, 
			List<SortCriterion> sortCriteria){
		
		// makes the jframe
		jfText = new JFrame(constructTitle());
		
		// makes jtext area for the list of stories 
		jtaNewsStoryList = new JTextArea(listOfStories);
		
		// makes the scroll pane and adds the list of stories
		jspNewsStoryList = new JScrollPane();
		jspNewsStoryList.add(jtaNewsStoryList);
		
		// makes text area for summaryLine
		jtaSummaryLine = new JTextArea(summaryLine);
		
		// makes a jpanel to add the text areas
		// not sure if that was necessary, but I did it anyway
		JPanel jpl = new JPanel(new GridLayout(0, 1, 5, 5));
		jpl.add(jspNewsStoryList);
		jpl.add(jtaSummaryLine);
		
		jfText.add(jpl);
		jfText.pack(); // not sure if this is needed. 
		jfText.setVisible(true);
		
	}
	
	private void constructNewsStoriesAndSummary(){
		/* The list of stories as a String */
		listOfStories = "";

		/*
		 * Sets to keep track of the distinct news source names and topics found
		 * (for the summary line).
		 */
		Set<String> distinctNewsSourceNames = new TreeSet<String>();
		Set<String> distinctTopics = new TreeSet<String>();
		Set<String> distinctSubjects = new TreeSet<String>();

		/* The running total of the length of the stories. */
		int totalLength = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		NewsStoryListModel newsStoryListModel = newsMakerModel.getNewsStoryListModel();

		// Make our own copy of the data so that we can sort it.
		List<NewsStory> newsStories = new ArrayList<NewsStory>(newsStoryListModel.size());

		// If all media types specified, add them all.
		if (newsMedia.contains(NewsMedia.NEWSPAPER) && 
				newsMedia.contains(NewsMedia.TV) && 
				newsMedia.contains(NewsMedia.ONLINE)) {
			for (int i = 0; i < newsStoryListModel.size(); i++) {
				newsStories.add(newsStoryListModel.get(i));
			}
		}
		// Otherwise, we need to check for particular media types.
		else {
			// If the user asked for newspaper stories, add those.
			if (newsMedia.contains(NewsMedia.NEWSPAPER)) {
				for (int i = 0; i < newsStoryListModel.size(); i++) {
					NewsStory newsStory = newsStoryListModel.get(i);
					if (newsStory instanceof NewspaperStory) {
						newsStories.add(newsStory);
					}
				}
			}
			// If the user asked for TV news stories, add those.
			if (newsMedia.contains(NewsMedia.TV)) {
				for (int i = 0; i < newsStoryListModel.size(); i++) {
					NewsStory newsStory = newsStoryListModel.get(i);
					if (newsStory instanceof TVNewsStory) {
						newsStories.add(newsStory);
					}
				}
			}
			// If the user asked for online news stories, add those.
			if (newsMedia.contains(NewsMedia.ONLINE)) {
				for (int i = 0; i < newsStoryListModel.size(); i++) {
					NewsStory newsStory = newsStoryListModel.get(i);
					if (newsStory instanceof OnlineNewsStory) {
						newsStories.add(newsStory);
					}
				}
			}
		}

		// Sort the list based on the user's sort criteria
		// Start with tertiary sort criterion and work to primary
		if (sortCriteria.length != 5) {
			throw new IllegalArgumentException(
					"createListOfNewsStoriesForNewsmaker called with illegal sort criteria list size: "
							+ sortCriteria.length);
		}
		for (int i = sortCriteria.length - 1; i >= 0; i--) {
			if (sortCriteria.get(i).equals(SortCriteria.TOPIC)) {
				Collections.sort(newsStories);
			} else if (sortCriteria.get(i).equals(SortCriteria.LENGTH)) {
				Collections.sort(newsStories, LengthComparator.LENGTH_COMPARATOR);
			} else if (sortCriteria.get(i).equals(SortCriteria.DATE_TIME)) {
				Collections.sort(newsStories, DateComparator.DATE_COMPARATOR);
			} else if (sortCriteria.get(i).equals(SortCriteria.SOURCE)) {
				Collections.sort(newsStories, SourceComparator.SOURCE_COMPARATOR);
			} else if (sortCriteria.get(i).equals(SortCriteria.SUBJECT)) {
				Collections.sort(newsStories, SubjectComparator.SUBJECT_COMPARATOR);
			}else {
				throw new IllegalArgumentException(
						"createListOfNewsStoriesForNewsmaker called with illegal sort criterion: " + sortCriteria.get(i));
			}
		}

		// Cycle through the stories one at a time
		for (NewsStory newsStory : newsStories) {

			// Add any new source name encountered to the set of names
			// Since sets exclude duplicates, we don't need to check
			distinctNewsSourceNames.add(newsStory.getSource());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctTopics.add(newsStory.getTopic());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctSubjects.add(newsStory.getSubject());

			// Add to the running total for length
			// If the type is TV news, and only TV news, use seconds (from length)
			if (newsMedia.contains(NewsMedia.TV) && (newsMedia.size() == 1)) {
				totalLength += newsStory.getLength();
			}
			// If the type is newspaper, use words
			// If the type is online, use words
			// If the type is mixed, use words as common unit
			else {
				totalLength += newsStory.getLengthInWords();
			}

			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += UserInterface.convertToOutputFormat(newsStory, newsMedia) + "\n";
		}

		// Construct the summary line
		// If the type doesn't include TV, use words
		if (!newsMedia.contains(NewsMedia.TV)) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is TV news, use seconds (from length)
		else if (newsMedia.contains(NewsMedia.TV) && (newsMedia.size() == 1)) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is mixed, use words as common unit
		else {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size() + "; Number of Subjects: "
					+ distinctSubjects.size();
		}
	}
	
	private String constructTitle(){
		String title = newsMakerModel.getName() + " - ";
		
		// if all three news media are used, then add "Stories" to the title 
		if(newsMedia.size() == 3){
			title += "Stories sorted by ";
		} else if(newsMedia.size() == 2){
			title += newsMedia.get(0) + "/" + newsMedia.get(1) +
					" sorted by ";
		} else if(newsMedia.size() == 1){
			title += newsMedia.get(0) + " sorted by ";
		} // there shouldn't be any other options
		
		// add the sort criteria in order
		for (int i = 0; i < 5; i++){
			title += sortCriteria.get(i) + ", ";
		}
		// remove the last space and comma
		title = title.substring(0, title.length() - 2);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		constructNewsStoriesAndSummary();
		constructTitle();
		
		jfText.repaint();
	}
}
