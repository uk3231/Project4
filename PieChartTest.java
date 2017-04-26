import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PieChartTest {

	@Test
	public final void testPieChartTitle()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Wedge> wedges = new ArrayList<Wedge>();

		PieChart pieChart = new PieChart("Title", wedges);

		Field field = PieChart.class.getDeclaredField("title");
		field.setAccessible(true);
		Object value = field.get(pieChart);
		System.err.println(value);

		if ("Title".equals((String) value)) {
			return;
		} else {
			fail("Title not equal to value set during construction.");
		}
	}

	@Test
	public final void testPieChartWedges()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Wedge> wedges = new ArrayList<Wedge>();
		wedges.add(new Wedge(0.01, "Label 1"));
		wedges.add(new Wedge(0.02, "Label 2"));

		PieChart pieChart = new PieChart("Title", wedges);

		Field field = PieChart.class.getDeclaredField("wedges");
		field.setAccessible(true);
		Object value = field.get(pieChart);
		System.err.println(value);

		if (wedges.equals((List<Wedge>) value)) {
			return;
		} else {
			fail("Wedges not equal to value set during construction.");
		}
	}
}
