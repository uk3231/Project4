import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class CodeFileProcessorTest {

	// 1
	@Test
	public void hasFunctionalMethodCalledReadCodeFileTest() {
		try {
			Map<String, String> returnedMap = CodeFileProcessor.readCodeFile("test.csv");
		} catch (IOException e) {
			fail("IOException");
		} catch (RuntimeException e) {
			fail("DATE_COMPARATOR does not exist or is not functional");
		}
	}

	//2
	@Test
	public void readCodeFileBasicTest() {
		Map<String, String> definedMap = new TreeMap<String, String>();
		definedMap.put("Key A", "Value A");
		definedMap.put("Key B", "Value B");

		Map<String, String> returnedMap = null;

		try {
			returnedMap = new TreeMap<String, String>(CodeFileProcessor.readCodeFile("test.csv"));
		} catch (IOException e) {
			fail("IOException");
		}

		if (definedMap.equals(returnedMap)) {
			return;
		} else {
			fail("Not equal");
		}
	}
	
	//3
	@Test
	public void readCodeFileClearsMapTest() {
		Map<String, String> definedMap = new TreeMap<String, String>();
		definedMap.put("Key A", "Value A");
		definedMap.put("Key B", "Value B");

		Map<String, String> returnedMap = null;

		try {
			CodeFileProcessor.readCodeFile("test2.csv");
			returnedMap = new TreeMap<String, String>(CodeFileProcessor.readCodeFile("test.csv"));
		} catch (IOException e) {
			fail("IOException");
		}

		if (definedMap.equals(returnedMap)) {
			return;
		} else {
			fail("Not equal");
		}
	}
}