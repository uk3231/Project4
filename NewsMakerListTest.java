import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

public class NewsMakerListTest {

	//1
	@Test
	public void testNewsMakerListAddDuplicateThrowsException() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		NewsMaker newsMaker2 = new NewsMaker("Interesting Person 1");

		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.add(newsMaker1);

		try {
			newsMakerList1.add(newsMaker2);
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("Fails to throw IllegalArgumentException on duplicate name.");
	}
	
	//2
	@Test
	public void testNewsMakerListSortSortsList() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.sort();
		
        Field field = NewsMakerList.class.getDeclaredField("sorted");
        field.setAccessible(true);
        Object value = field.get(newsMakerList1);
        System.err.println(value);
		
        if ((boolean)value) {
			return;
		} else {
			fail("Sorting list does not set sorted field to true.");
		}
	}
	
	//3
	@Test
	public void testNewsMakerListAddUnsortsList() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.sort();
		
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		newsMakerList1.add(newsMaker1);
		
        Field field = NewsMakerList.class.getDeclaredField("sorted");
        field.setAccessible(true);
        Object value = field.get(newsMakerList1);
        System.err.println(value);
		
        if (!(boolean)value) {
			return;
		} else {
			fail("Sorting list does not set sorted field to true.");
		}
	}

	//4
	@Test
	public void testNewsMakerListGetPartialMatch() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		NewsMaker newsMaker2 = new NewsMaker("Interesting Person 2");

		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.add(newsMaker1);
		newsMakerList1.add(newsMaker2);

		if (newsMaker2.equals(newsMakerList1.getPartialMatch("2"))) {
			return;
		} else {
			fail("Fails on partial match.");
		}
	}

	//5
	@Test
	public void testNewsMakerListSort() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		NewsMaker newsMaker2 = new NewsMaker("Interesting Person 2");
		NewsMaker newsMaker3 = new NewsMaker("Interesting Person 3");

		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.add(newsMaker3);
		newsMakerList1.add(newsMaker2);
		newsMakerList1.add(newsMaker1);

		newsMakerList1.sort();

		NewsMakerList newsMakerList2 = new NewsMakerList();
		newsMakerList2.add(newsMaker1);
		newsMakerList2.add(newsMaker2);
		newsMakerList2.add(newsMaker3);
		
        Field field = NewsMakerList.class.getDeclaredField("newsMakers");
        field.setAccessible(true);
        
        Object value1 = field.get(newsMakerList1);
        System.err.println(value1);
        
        Object value2 = field.get(newsMakerList2);
        System.err.println(value2);

		if (((List<NewsMaker>)value2).equals((List<NewsMaker>)value1)) {
			return;
		} else {
			fail("Fails to sort.");
		}
	}

	//6
	@Test
	public void testNewsMakerListGetExactMatchSorted() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		NewsMaker newsMaker2 = new NewsMaker("Interesting Person 2");
		NewsMaker newsMaker3 = new NewsMaker("Interesting Person 3");

		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.add(newsMaker3);
		newsMakerList1.add(newsMaker2);
		newsMakerList1.add(newsMaker1);

		newsMakerList1.sort();

		if (newsMaker1.equals(newsMakerList1.getExactMatch("Interesting Person 1"))) {
			return;
		} else {
			fail("Fails on exact match when list sorted.");
		}
	}

	//7
	@Test
	public void testNewsMakerListGetExactMatchUnsorted() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person 1");
		NewsMaker newsMaker2 = new NewsMaker("Interesting Person 2");
		NewsMaker newsMaker3 = new NewsMaker("Interesting Person 3");

		NewsMakerList newsMakerList1 = new NewsMakerList();
		newsMakerList1.add(newsMaker3);
		newsMakerList1.add(newsMaker2);
		newsMakerList1.add(newsMaker1);

		if (newsMaker1.equals(newsMakerList1.getExactMatch("Interesting Person 1"))) {
			return;
		} else {
			fail("Fails on exact match when list unsorted.");
		}
	}
}
