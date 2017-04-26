import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TVNewsStoryTest {

	// 1
	@Test
	public final void constructorTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		try {
			TVNewsStory tvNewsStory = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
					"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		} catch (RuntimeException e) {
			fail("TVnewsStory constuctor does not exist or is not functional");
		}
	}

	// 2
	@Test
	public final void constructorAndGetSubjectTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		
		if ("Interesting Subject".equals(tvNewsStory.getSubject())) {
			return;
		} else {
			fail("Not equal");
		}
	}
	
	//3
	@Test
	public final void equalsSamePartOfDayTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		TVNewsStory tvNewsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		
		if (tvNewsStory1.equals(tvNewsStory2)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	//4
	@Test
	public final void equalsDifferentPartOfDayTest() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		TVNewsStory tvNewsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		TVNewsStory tvNewsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", "Interesting Subject", PartOfDay.AFTERNOON, newsMaker1, newsMaker1);
		
		if (tvNewsStory1.equals(tvNewsStory2)) {
			fail("Equal");;
		} else {
			return;
		}
	}
}
