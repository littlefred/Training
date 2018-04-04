/**
 * 
 */
package food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Frederick
 *
 */
public class FoodItem {
	private String name;
	private String category;
	private double energy;
	private double proteins;
	private double carbohydrates;
	private double lipids;

	public static final String[][] FOOD_CATEGORIES = { { "String", "name" }, { "String", "category" },
			{ "double", "energy value (kcal)" }, { "double", "proteins (g/100g)" },
			{ "double", "carbohydrates (g/100g)" }, { "double", "lipids (g/100g)" } };

	public static final String SEPARATOR = ";";

	private static final String FOOD_FILENAME = "food.csv";

	/**
	 * constructor
	 * 
	 * @param name
	 * @param category
	 * @param energy
	 * @param proteins
	 * @param carbohydrates
	 * @param lipids
	 */
	public FoodItem(String name, String category, double energy, double proteins, double carbohydrates, double lipids) {
		this.name = name;
		this.category = category;
		this.energy = energy;
		this.proteins = proteins;
		this.carbohydrates = carbohydrates;
		this.lipids = lipids;
	}

	/**
	 * method to read the file of foods
	 */
	public static List<FoodItem> read() {
		List<FoodItem> list = new ArrayList<>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(FOOD_FILENAME));
			String currentLine = "";
			do {
				currentLine = read.readLine();
				if (currentLine != null) {
					String[] foodLineSplit = currentLine.split(SEPARATOR);
					FoodItem item = new FoodItem(foodLineSplit[0], foodLineSplit[1], Double.valueOf(foodLineSplit[2]),
							Double.valueOf(foodLineSplit[3]), Double.valueOf(foodLineSplit[4]),
							Double.valueOf(foodLineSplit[5]));
					list.add(item);
				}
			} while (currentLine != null);
			read.close();
		} catch (FileNotFoundException e) {
			System.err.println(
					"The file doesn't exist or is inaccessible.\nPlease Insert a correct file, or start adding a food.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Sorry, there is a problem to read the file.");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * method to add a food in the file
	 * 
	 * @param food
	 */
	public static void addFood() {
		String str = "";
		for (int i = 0; i != FOOD_CATEGORIES.length; i++) {
			if (FOOD_CATEGORIES[i][0].equals("String")) {
				str += Food.userInputString(FOOD_CATEGORIES[i][1] + " :");
				str+=";";
			}
			if (FOOD_CATEGORIES[i][0].equals("double")) {
				str += Food.userInputDouble(FOOD_CATEGORIES[i][1] + " :");
				str+=";";
			}
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FOOD_FILENAME, true));
			writer.write(str);
			writer.newLine();
			writer.close();
			System.out.println("Add your food is completed.");
		} catch (IOException e) {
			System.err.println("Sorry, there is a problem to insert your food.");
			e.printStackTrace();
		}
	}

	/**
	 * Method to delete a food using a temporary file that replace this original at
	 * the end of writing
	 * 
	 * @param food
	 */
	public static void deleteFood(String food) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FOOD_FILENAME));

			// Creating a temporary file to write new food DB file without removed food
			// item.
			Path tempFilePath = Files.createTempFile(Paths.get("."), "foodBaseTemp", ".csv");
			BufferedWriter writer = Files.newBufferedWriter(tempFilePath, StandardOpenOption.WRITE);
			// We ask JVM to remove temp file when the program terminates.
			tempFilePath.toFile().deleteOnExit();

			String foodLine = "";
			String[] foodLineSplit = new String[FOOD_CATEGORIES.length];
			do {
				foodLine = reader.readLine();
				if (foodLine != null) {
					foodLineSplit = foodLine.split(SEPARATOR);
					if (!foodLineSplit[0].equals(food)) {
						writer.write(foodLine);
						writer.newLine();
					}
				}
			} while (foodLine != null);
			reader.close();
			writer.close();
			Files.move(tempFilePath, Paths.get("./" + FOOD_FILENAME), StandardCopyOption.ATOMIC_MOVE);
			System.out.println("Your food is correctly deleted.");
		} catch (FileNotFoundException e) {
			System.err.println(
					"The file doesn't exist or is inaccessible.\nPlease Insert a correct file, or start adding a food.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Sorry, there is a problem to delete your food.");
			e.printStackTrace();
		}
	}

	/**
	 * method to modify the display of foodItem object
	 */
	public String toString() {
		String str = "name : " + name + " | category : " + category + " | energy (kcal) : " + energy + " | proteins : "
				+ proteins + " | carbohydrates : " + carbohydrates + " | lipids : " + lipids;
		return str;
	}

}
