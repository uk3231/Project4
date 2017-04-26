import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class DateComparatorTest {

	// 1
	@Test
	public void dateComaratorTestHasFunctionalMethodCalledDATE_COMPARATOR() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		try {
			DateComparator.DATE_COMPARATOR.compare(newsStory1, newsStory1);
		} catch (RuntimeException e) {
			fail("DATE_COMPARATOR does not exist or is not functional");
		}
	}

	// 2
	@Test
	public void dateComparatorTestFirstDateLessTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 3
	@Test
	public void dateComparatorTestFirstDateGreaterTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) > 0) {
			return;
		} else {
			fail("Not greater than.");
		}
	}

	// 4
	@Test
	public void dateComparatorTestDateAndPartOfDayEqualTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) == 0) {
			return;
		} else {
			fail("Not equal to.");
		}
	}

	// 5
	@Test
	public void dateComparatorTestFirstDateLessOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 6
	@Test
	public void dateComparatorTestFirstDateGreaterOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) > 0) {
			return;
		} else {
			fail("Not greater than.");
		}
	}

	// 7
	@Test
	public void dateComparatorTestDateAndPartOfDayEqualOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 30), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) == 0) {
			return;
		} else {
			fail("Not equal to.");
		}
	}

	// 8
	@Test
	public void dateComparatorTestFirstDateLessNewspaper() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 9
	@Test
	public void dateComparatorTestFirstDateGreaterNewspaper() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new NewspaperStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) > 0) {
			return;
		} else {
			fail("Not greater than.");
		}
	}

	// 10
	@Test
	public void dateComparatorTestDateEqualNewspaper() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new NewspaperStory(LocalDate.of(2000, 12, 30), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) == 0) {
			return;
		} else {
			fail("Not equal to.");
		}
	}
	
	// 11
	@Test
	public void dateComparatorTestFirstPartOfDayLessTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.EVENING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.LATE_NIGHT, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 12
	@Test
	public void dateComparatorTestFirstPartOfDayGreaterTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.LATE_NIGHT, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.EVENING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) > 0) {
			return;
		} else {
			fail("Not greater than.");
		}
	}

	// 13
	@Test
	public void dateComparatorTestFirstPartOfDayLessOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.AFTERNOON, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 14
	@Test
	public void dateComparatorTestFirstPartOfDayGreaterOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.AFTERNOON, newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1,
				"Interesting Topic", "Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) > 0) {
			return;
		} else {
			fail("Not greater than.");
		}
	}

	// 15
	@Test
	public void dateComparatorTestNewspaperFirstTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 16
	@Test
	public void dateComparatorTestNewspaperSecondTVNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new TVNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory2, newsStory1) > 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}
	
	// 17
	@Test
	public void dateComparatorTestNewspaperFirstOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory1, newsStory2) < 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}

	// 18
	@Test
	public void dateComparatorTestNewspaperSecondOnlineNews() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");

		NewsStory newsStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", newsMaker1, newsMaker1);
		NewsStory newsStory2 = new OnlineNewsStory(LocalDate.of(2000, 12, 31), "Times of London", 1, "Interesting Topic",
				"Interesting Subject", PartOfDay.MORNING, newsMaker1, newsMaker1);

		DateComparator testDateComparator = new DateComparator();
		if (testDateComparator.compare(newsStory2, newsStory1) > 0) {
			return;
		} else {
			fail("Not less than.");
		}
	}
}
