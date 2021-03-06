package com.vladimir.json.bench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Vladimir
 */
public class BenchData {
	static Map<String, ArrayList<String>> allTestCache = new HashMap<String, ArrayList<String>>();
	static public String testMode = null;

	/**
	 * 17 key, 17 is a prim number
	 */
	static String[] keys = new String[] { "firstname", "lastname", "date", "len", "shape", "gate", "foo", "bar",
			"city", "site", "url", "age", "action", "level", "password", "color", "case" };

	/**
	 * 13 values, 13 is a prim number
	 */
	static String[] valueMixt = new String[] { "\"jean\"", "120445", "12", "\"Paris\"", "\"pacifica\"",
			"\"44reg(a{[|)@\"", "true", "false", "null", "1.1245E-12", "{\"Sub\":5}", "[\"DFG\", \"ABC\"]",
			"[{\"Sub\":5}, {\"Bal\":100.5}]" };

	static String[] valueText = new String[] { "jean", "jinna", "paris", "city", "pacifica", "abc", "jeanjouuul" };
	static String[] valueTextProtected = new String[] { "\"jean\"", "\"jinna\"", "\"paris\"", "\"city\"",
			"\"pacifica\"" };
	static String[] valueBoolean = new String[] { "true", "true", "false", "true", "false", "false" };
	static String[] valueInt = new String[] { "1442", "15005", "44", "58", "4253478", "72352284", "55433456",
			"332211223" };
	static String[] valueFloat = new String[] { "1442.12", "15005.12", "44.12", "58.10", "478.2", "2284.5", "33456.12",
			"3332211.123" };
	static String[] valueUnicode = new String[] { "\"\\u44FF\\u44ff\"", "\"\\u44ff\"", "\"\\u44aa\\u44ff\"",
			"\"\\u44AA\"", "\"\\u4425\"", "\"\\u4426\"", "\"\\u4427\\u44FF\"" };

	public static String[] getChangeTestSet(String name) {
		if (name.equals("mix"))
			return valueMixt;
		else if (name.equals("int"))
			return valueInt;
		else if (name.equals("float"))
			return valueFloat;
		else if (name.equals("boolean"))
			return valueBoolean;
		else if (name.equals("bool"))
			return valueBoolean;
		else if (name.equals("text"))
			return valueTextProtected;
		else if (name.equals("string"))
			return valueText;
		else if (name.equals("unicode"))
			return valueUnicode;
		else {
			System.err.println("non supported Test Type:" + name);
			return new String[0];
		}
	}

	public static void cleanCache() {
		allTestCache = new HashMap<String, ArrayList<String>>();
	}

	public static void changeTest(String name) {
		testMode = name;
	}

	public static ArrayList<String> getTestMessages() {
		return BenchData.getTestMessages(testMode, true);
	}

	public static ArrayList<String> getTestMessages(String name, boolean putInCache) {
		if (allTestCache.containsKey(name))
			return allTestCache.get(name);

		ArrayList<String> testMsgs = new ArrayList<String>();
		String[] value = getChangeTestSet(name);
		int nbValue = keys.length * value.length;
		boolean stringTest = "string".equals(name);

		for (int i = 0; i < nbValue; i++) {
			StringBuilder sb = new StringBuilder();
                        
			sb.append('{');
                        
			if (!stringTest)
				sb.append('"');
			sb.append(keys[i % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(':');
			sb.append(value[i % value.length]);

			sb.append(',');
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 1) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + i) % value.length]);

			sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 2) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 2) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 3) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 3) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 4) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 4) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 5) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 5) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 6) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 6) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 7) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 7) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 8) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 8) % value.length]);
                        
                        sb.append(",");
			if (!stringTest)
				sb.append('"');
			sb.append(keys[(i + 9) % keys.length]);
			if (!stringTest)
				sb.append('"');
			sb.append(":");
			sb.append(value[(i + 9) % value.length]);
                        
			sb.append("}");
                        
			testMsgs.add(sb.toString());
		}
                
		if (putInCache)
			allTestCache.put(name, testMsgs);
                
		return testMsgs;
	}

}
