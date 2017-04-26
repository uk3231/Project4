import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class NewsStoryListTest {

	@Test
	public void testNewsStoryAddAndGetEmptyNewspaperStory() {
		NewsStoryList newsStoryList1 = new NewsStoryList();
		NewsMaker newsMaker = new NewsMaker();
		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 1, 15), "", 0, "", "", newsMaker,
				newsMaker);
		newsStoryList1.add(newspaperStory1);
		if (newspaperStory1.equals(newsStoryList1.get(0))) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testNewsMakerAddNewsStoryAndGetNewsStoriesNotEmptyNotDuplicateNewspaperStory() {
		NewsMaker newsMaker1 = new NewsMaker();
		LocalDate date1 = LocalDate.of(2000, 1, 15);

		NewspaperStory newspaperStory1 = new NewspaperStory(date1, "", 0, "", "", newsMaker1, newsMaker1);
		NewspaperStory newspaperStory2 = new NewspaperStory(date1, "", 1, "", "", newsMaker1, newsMaker1);
		newsMaker1.addNewsStory(newspaperStory1);
		newsMaker1.addNewsStory(newspaperStory2);

		NewsStoryList newsStoryList1 = newsMaker1.getNewsStories();
		int size = newsStoryList1.size();
		for (int i = 0; i < size; i++) {
			if (newspaperStory1.equals(newsStoryList1.get(i))) {
				return;
			}
		}
		fail("Not found");
	}

	@Test
	public void testNewsStoryListAddAndGetNotEmptyNotDuplicateNewspaperStory() {
		NewsMaker newsMaker1 = new NewsMaker();

		NewsStoryList newsStoryList1 = new NewsStoryList();
		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2001, 4, 20), "", 0, "", "", newsMaker1,
				newsMaker1);
		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2001, 4, 21), "", 1, "", "", newsMaker1,
				newsMaker1);
		newsStoryList1.add(newspaperStory1);
		newsStoryList1.add(newspaperStory2);

		int size = newsStoryList1.size();
		for (int i = 0; i < size; i++) {
			if (newspaperStory2.equals(newsStoryList1.get(i))) {
				return;
			}
		}
		fail("Not found");
	}
}
