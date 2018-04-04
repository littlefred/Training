/**
 * 
 */
package S1_algotithme;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Frederick
 *
 */
public class S1_N3_ex4_loadDistribution {
	private static int nbWorks; // attribute to save the number of workload
	private static int nbLots; // attribute to save the number of batches

	private static Scanner scanner = new Scanner(System.in); // open the scanner

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
	 * method to display the load distribution
	 * 
	 * @param works
	 * @param lots
	 */
	private static void displayWork(int works, int lots) {
		int baseLoad = works / lots;
		int rest = works % lots;
		int result = 0;
		int tempLots = lots - rest;
		for (int i = 0; i != lots; i++) {
			result = baseLoad;
			if (rest <= tempLots) {
				tempLots--;
			} else {
				rest--;
				result += 1;
			}
			System.out.print(result);
		}

	}

	/**
	 * main body to display the workload
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can allocate a workload based on a number of batches.");
		nbWorks = userInputInt("What number of workload do you want to dispatch ?");
		nbLots = userInputInt("What number of batches do you want to use ?");
		displayWork(nbWorks, nbLots);
	}

}
