import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import org.junit.Test;

public class UserInterfaceTest {

	// 1
	@Test
	public void testConvertToOutputFormatNewspaper() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewspaperStory newspaperStory = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		String storyString = "December 31, 2000; Times of London; 20 words; Interesting Topic; Interesting Subject";
		String mediaType = "n";
		String returnedString = "";

		Class[] argClasses = { NewsStory.class, String.class };
		Object[] argObjects = { newspaperStory, mediaType };
		Method method;
		try {
			method = UserInterface.class.getDeclaredMethod("convertToOutputFormat", argClasses);
			method.setAccessible(true);
			returnedString = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (storyString.equals(returnedString)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 2
	@Test
	public void testConvertToOutputFormatTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		String storyString = "December 31, 2000; Times of London; 20 seconds; Interesting Topic; Interesting Subject; Morning";
		String mediaType = "t";
		String returnedString = "";

		Class[] argClasses = { NewsStory.class, String.class };
		Object[] argObjects = { tvNewsStory, mediaType };
		Method method;
		try {
			method = UserInterface.class.getDeclaredMethod("convertToOutputFormat", argClasses);
			method.setAccessible(true);
			returnedString = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (storyString.equals(returnedString)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 3
	@Test
	public void testConvertToOutputFormatOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		OnlineNewsStory onlineNewsStory = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		String storyString = "December 31, 2000; Times of London; 20 words; Interesting Topic; Interesting Subject; Morning";
		String mediaType = "o";
		String returnedString = "";

		Class[] argClasses = { NewsStory.class, String.class };
		Object[] argObjects = { onlineNewsStory, mediaType };
		Method method;
		try {
			method = UserInterface.class.getDeclaredMethod("convertToOutputFormat", argClasses);
			method.setAccessible(true);
			returnedString = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (storyString.equals(returnedString)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 4
	@Test
	public void testCreateListOfNewsStoriesForNewsmakerNewspaperTopicSourceLengthDateOrder() {

		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 6000,
				"Interesting Topic 2", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperStory1);

		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2001, 1, 1), "Times of London", 20,
				"Interesting Topic 2", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperStory2);

		NewspaperStory newspaperStory3 = new NewspaperStory(LocalDate.of(2001, 1, 1), "LA Times", 6000,
				"Interesting Topic 2", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperStory3);

		NewspaperStory newspaperStory4 = new NewspaperStory(LocalDate.of(2001, 1, 1), "Times of London", 6000,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperStory4);

		String storyListString = "January 1, 2001; Times of London; 6000 words; Interesting Topic; Interesting Subject"
				+ "\nJanuary 1, 2001; LA Times; 6000 words; Interesting Topic 2; Interesting Subject"
				+ "\nJanuary 1, 2001; Times of London; 20 words; Interesting Topic 2; Interesting Subject"
				+ "\nDecember 31, 2000; Times of London; 6000 words; Interesting Topic 2; Interesting Subject"
				+ "\nNumber of Stories: 4; Number of Sources: 2; Number of Words: 18020; Number of Topics: 2; Number of Subjects: 1";

		String mediaType = "n";
		String[] sortCriteria = { "t", "s", "l", "d" };
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType,
				sortCriteria);

		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 5
	@Test
	public void testCreateListOfNewsStoriesForNewsmakerTVNewsSourceLengthDateTopicOrder() {

		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 6000,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(tvNewsStory1);

		TVNewsStory tvNewsStory2 = new TVNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 20,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(tvNewsStory2);

		TVNewsStory tvNewsStory3 = new TVNewsStory(LocalDate.of(2001, 1, 1), "LA Times", 6000, "Interesting Topic 2",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(tvNewsStory3);

		TVNewsStory tvNewsStory4 = new TVNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 6000,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(tvNewsStory4);

		String storyListString = "January 1, 2001; LA Times; 6000 seconds; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nJanuary 1, 2001; Times of London; 20 seconds; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nDecember 31, 2000; Times of London; 6000 seconds; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nJanuary 1, 2001; Times of London; 6000 seconds; Interesting Topic; Interesting Subject; Morning"
				+ "\nNumber of Stories: 4; Number of Sources: 2; Seconds: 18020; Number of Topics: 2; Number of Subjects: 1";

		String mediaType = "t";
		String[] sortCriteria = { "s", "l", "d", "t" };
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType,
				sortCriteria);

		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 6
	@Test
	public void testCreateListOfNewsStoriesForNewsmakerOnlineNewsLengthDateTopicSourceOrder() {

		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		OnlineNewsStory onlineNewsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 6000,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(onlineNewsStory1);

		OnlineNewsStory onlineNewsStory2 = new OnlineNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 20,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(onlineNewsStory2);

		OnlineNewsStory onlineNewsStory3 = new OnlineNewsStory(LocalDate.of(2001, 1, 1), "LA Times", 6000,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(onlineNewsStory3);

		OnlineNewsStory onlineNewsStory4 = new OnlineNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 6000,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(onlineNewsStory4);

		String storyListString = "January 1, 2001; Times of London; 20 words; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nDecember 31, 2000; Times of London; 6000 words; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nJanuary 1, 2001; Times of London; 6000 words; Interesting Topic; Interesting Subject; Morning"
				+ "\nJanuary 1, 2001; LA Times; 6000 words; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nNumber of Stories: 4; Number of Sources: 2; Number of Words: 18020; Number of Topics: 2; Number of Subjects: 1";

		String mediaType = "o";
		String[] sortCriteria = { "l", "d", "t", "s" };
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType,
				sortCriteria);

		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	// 7
	@Test
	public void testCreateListOfNewsStoriesForNewsmakerMixedDateTopicSourceLengthOrder() {

		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory2 = new TVNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 20,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(tvNewsStory2);

		NewspaperStory newspaperNewsStory3 = new NewspaperStory(LocalDate.of(2001, 1, 1), "LA Times", 6000,
				"Interesting Topic 2", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperNewsStory3);

		NewspaperStory newspaperNewsStory4 = new NewspaperStory(LocalDate.of(2001, 1, 1), "Times of London", 6000,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperNewsStory4);

		OnlineNewsStory onlineNewsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 6000,
				"Interesting Topic 2", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(onlineNewsStory1);

		String storyListString = "December 31, 2000; Times of London; 6000 word equivalents; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nJanuary 1, 2001; Times of London; 6000 word equivalents; Interesting Topic; Interesting Subject"
				+ "\nJanuary 1, 2001; LA Times; 6000 word equivalents; Interesting Topic 2; Interesting Subject"
				+ "\nJanuary 1, 2001; Times of London; 50 word equivalents; Interesting Topic 2; Interesting Subject; Morning"
				+ "\nNumber of Stories: 4; Number of Sources: 2; Number of Word Equivalents: 18050; Number of Topics: 2; Number of Subjects: 1";

		String mediaType = "otn";
		String[] sortCriteria = { "d", "t", "s", "l" };
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType,
				sortCriteria);

		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}
}
