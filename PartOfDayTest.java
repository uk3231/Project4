import static org.junit.Assert.*;

import org.junit.Test;

public class PartOfDayTest {

	@Test
	public final void extraConstantFieldTest() {
		for (PartOfDay partOfDay : PartOfDay.values()) {
			switch (partOfDay) {
			case MORNING:
				break;
			case AFTERNOON:
				break;
			case EVENING:
				break;
			case LATE_NIGHT:
				break;
			default:
				fail("Extra constant");
			}
		}
	}

	@Test
	public final void testToStringMorning() {
		if ("Morning".equals(PartOfDay.MORNING.toString())) {
			return;
		} else {
			fail("Wrong String returned");
		}
	}

	@Test
	public final void testToStringAfternoon() {
		if ("Afternoon".equals(PartOfDay.AFTERNOON.toString())) {
			return;
		} else {
			fail("Wrong String returned");
		}
	}

	@Test
	public final void testToStringEvening() {
		if ("Evening".equals(PartOfDay.EVENING.toString())) {
			return;
		} else {
			fail("Wrong String returned");
		}
	}

	@Test
	public final void testToStringLateNight() {
		if ("Late Night".equals(PartOfDay.LATE_NIGHT.toString())) {
			return;
		} else {
			fail("Wrong String returned");
		}
	}

}
