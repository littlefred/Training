/**
 * 
 */
package consolidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Frederick Exercise of collections consolidation with
 * 
 *         a method to display the same words between two lists in alphabetical
 *         order
 * 
 *         a method to display the number of occurrences, in alphabetical order
 *         and descending order of occurrences
 */
public class ConsolidationCollections {
	/**
	 * method to convert a file in List.
	 * 
	 * @param file
	 * @return
	 */
	private static List<String> readFile(String file) {
		List<String> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Sorry, the file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * method to display the same words between two files in alphabetical order
	 * 
	 * @param file1
	 * @param file2
	 */
	private static void sameWordsBetweenTwoFiles(String file1, String file2) {
		Set<String> list1 = new TreeSet<>(readFile(file1)); // convert a file in treeset to have an ordered list without
															// duplicate
		Set<String> list2 = new TreeSet<>(readFile(file2));
		Set<String> set = new TreeSet<>();
		for (String str : list1) {
			for (String str2 : list2) {
				if (str2.equals(str)) {
					set.add(str);
				}
			}
		}
		for (String str : set) {
			System.out.println(str);
		}
		System.out.println("total words : " + set.size());
	}

	/**
	 * method to display the occurrences of words of a file
	 * 
	 * in descending occurrences order
	 * 
	 * and alphabetical order
	 * 
	 * @param file
	 */
	private static void occurencesOrderedList(String file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			Map<String, Integer> map = new TreeMap<>();
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				i++;
				if (!map.containsKey(line)) {
					map.put(line, 1);
				} else {
					map.replace(line, map.get(line) + 1);
				}
				line = reader.readLine();
			}
			int j = 0;
			List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

			// Lambda comparator writing Java 8+
			list.sort((o1, o2) -> -1 * (o1.getValue().compareTo(o2.getValue())));
			// Classical comparator writing
			list.sort((new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					if (o1.getValue().compareTo(o2.getValue()) == 0) {
						return o1.getKey().compareTo(o2.getKey());
					}
					return -1 * o1.getValue().compareTo(o2.getValue());
				}
			}));

			for (Entry<String, Integer> tempMap : list) {
				System.out.println("word : " + tempMap.getKey() + " => " + tempMap.getValue() + " time(s).");
				j += tempMap.getValue();
			}
			System.out.println("total words in the list : " + map.size());
			System.out.println("total words in the original file : " + i);
			System.out.println("total words with occurrences : " + j);
		} catch (FileNotFoundException e) {
			System.err.println("Sorry, the file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * main body to display the exercise
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the collections consolidation exercise.");
		System.out.println("*******************************************************");
		System.out.println("First command : display the same words between 2 files.");
		sameWordsBetweenTwoFiles("ethics.txt", "wealth.txt");
		System.out.println(
				"***************************************************************************************************");
		System.out.println(
				"Second command : display an alphabetical order list with the descending order of occurrences words.");
		occurencesOrderedList("ethics.txt");
	}

}