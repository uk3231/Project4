import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class NewspaperStoryTest {

	// 1
	@Test
	public final void constructorTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		try {
			NewspaperStory newspaperStory = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
					"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		} catch (RuntimeException e) {
			fail("NewspaperStory constuctor does not exist or is not functional.");
		}
	}

	// 2
	@Test
	public final void constructorAndGetSubjectTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewspaperStory newspaperStory = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);

		if ("Interesting Subject".equals(newspaperStory.getSubject())) {
			return;
		} else {
			fail("Gets subject not equal to subject parameter.");
		}
	}

	// 3
	@Test
	public final void equalsComparesSubjectEqualSubjects() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		
		if (newspaperStory1.equals(newspaperStory2)) {
			return;
		} else {
			fail("Reports not equal when subjects equal.");
		}
	}
	
	// 4
	@Test
	public final void equalsComparesSubjectDifferentSubjects() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", newsMaker1, newsMaker1);
		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject 2", newsMaker1, newsMaker1);
		
		if (!newspaperStory1.equals(newspaperStory2)) {
			return;
		} else {
			fail("Reports equal when subjects not equal.");
		}
	}
}
