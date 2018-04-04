/**
 * 
 */
package food;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * @author Frederick
 *
 */
public class Food {
	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since String
	 * 
	 * @param message
	 * @return
	 */
	public static String userInputString(String message) {
		System.out.println(message);
		return scanner.nextLine();
	}

	/**
	 * method to receive the user information since integer
	 * 
	 * @param message
	 * @return
	 */
	private static int userInputInt(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextInt();
				if (result >= 0) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a positive number.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}
	
	/**
	 * method to receive the user information since double
	 * 
	 * @param message
	 * @return
	 */
	public static double userInputDouble(String message) {
		double result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextDouble();
				if (result >= 0) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a positive number.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can manadge your food list.");
		int userChoice;
		do {
			System.out.println("What do you want to do ?");
			System.out.println("1 - See your food list.");
			System.out.println("2 - Add a food in your list.");
			System.out.println("3 - Delete a food in your list.");
			System.out.println("0 - Quit your application.");
			userChoice = userInputInt("your choice : ");
			switch (userChoice) {
			case 1:
				List<FoodItem> list = FoodItem.read();
				for (FoodItem food : list) {
					System.out.println(food);
				}
				break;
			case 2:
				FoodItem.addFood();
				break;
			case 3:
				String deleteFood = userInputString("name of the food : ");
				FoodItem.deleteFood(deleteFood);
				break;
			case 0:
				System.out.println("Thank you and Goodbye !");
				break;
			default:
				System.err.println("Your choice is not possible, please try again.");
				break;
			}
		} while (userChoice != 0);
	}

}
