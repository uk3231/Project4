import static org.junit.Assert.*;

import org.junit.Test;

public class WedgeTest {

	@Test
	public final void testWedgeAndGetPercent() {
		Wedge wedge = new Wedge(0.01, "Text");

		if (wedge.getPercent() == 0.01) {
			return;
		} else {
			fail("Percent returned does not equal value used in constructor.");
		}
	}

	@Test
	public final void testWedgeAndGetText() {
		Wedge wedge = new Wedge(0.01, "Text");

		if ("Text".equals(wedge.getText())) {
			return;
		} else {
			fail("Text returned does not equal text used in constructor.");
		}
	}

	@Test
	public final void testWedgeSetAndGetPercent() {
		Wedge wedge = new Wedge(0.01, "Text");

		wedge.setPercent(0.02);

		if (wedge.getPercent() == 0.02) {
			return;
		} else {
			fail("Percent returned does not equal value used in mutator.");
		}
	}

	@Test
	public final void testWedgeSetAndGetText() {
		Wedge wedge = new Wedge(0.01, "Text");

		wedge.setText("Text 2");

		if ("Text 2".equals(wedge.getText())) {
			return;
		} else {
			fail("Text returned does not equal text used in mutator.");
		}
	}
}
