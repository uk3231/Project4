import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import org.junit.Test;

public class NoozFileProcessorTest {

	@Test
	public void testReadNoozFileIOExceptionThrown() {
		try {
			NoozFileProcessor.readNoozFile("Bogus Filename", null, null, null);
		} catch (IOException e) {
			return;
		}
		fail("IOException not thrown");
	}

	@Test
	public void testDecodeDate() {

		LocalDate testDate = LocalDate.of(2000, 01, 02);
		LocalDate returnedDate = null;

		Class[] argClasses = { String.class };
		Object[] argObjects = { "20000102" };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeDate", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedDate = (LocalDate) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (testDate.equals(returnedDate)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testDecodeLength() {

		int returnedWordCount = 0;

		Class[] argClasses = { String.class };
		Object[] argObjects = { "1" };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeLength", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedWordCount = (int) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (1 == returnedWordCount) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameNoneOne() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "99", "NewsMakerName2" };
		Object[] argObjects = { parts, 4 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("None".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameNoneTwo() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "NewsMakerName1", "99" };
		Object[] argObjects = { parts, 5 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("None".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameSingleFirst() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "\"NewsMakerName1\"",
				"\"NewsMakerName2\"" };
		Object[] argObjects = { parts, 4 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("NewsMakerName1".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameSingleSecond() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "\"NewsMakerName1\"",
				"\"NewsMakerName2\"" };
		Object[] argObjects = { parts, 5 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("NewsMakerName2".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameDoubleFirst() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "\"NewsMaker", " Name1\"",
				"\"NewsMakerName2\"" };
		Object[] argObjects = { parts, 4 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("NewsMaker, Name1".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testdecodeNewsmakerNameDoubleSecond() {

		String returnedNewsMakerName = "";

		Class[] argClasses = { String[].class, int.class };
		String[] parts = { "DateString", "NewsPaperCode", "WordCountString", "TopicCode", "\"NewsMaker", " Name1\"",
				"\"NewsMaker", " Name2\"" };
		Object[] argObjects = { parts, 6 };
		Method method;
		try {
			method = NoozFileProcessor.class.getDeclaredMethod("decodeNewsmakerName", argClasses);
			System.err.println(method);
			method.setAccessible(true);
			returnedNewsMakerName = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if ("NewsMaker, Name2".equals(returnedNewsMakerName)) {
			return;
		} else {
			fail("Not equal");
		}
	}

}
