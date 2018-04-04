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
public class S1_N2_ex1_angleCalculation {
	private static double angle; // attribute to save the original angle

	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since double
	 * 
	 * @param message
	 * @return
	 */
	private static double userInputDouble(String message) {
		double result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextDouble();
				answer = true;
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
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
				answer = true;
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}

	/**
	 * method for calculating a radian angle from a degree angle
	 * 
	 * @param angle
	 * @return
	 */
	private static double calculationRadianAngle(double angle) {
		double result = angle * (Math.PI / 180);
		return result;
	}

	/**
	 * method for calculating a degree angle from a radian angle
	 * 
	 * @param angle
	 * @return
	 */
	private static double calculationDegreeAngle(double angle) {
		double result = angle * (180 / Math.PI);
		return result;
	}

	/**
	 * main body to calculate an angle
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here we can converse an angle to degree or radian.");

		int userChoice;
		do {
			System.out.println("What do you want to do ?");
			System.out.println("1 - Calculate a radian angle from a degree angle.");
			System.out.println("2 - Calculate a degree angle from a radian angle");
			System.out.println("0 - Quit the application.");
			userChoice = userInputInt("your choice : ");
			switch (userChoice) {
			case 1:
				angle = userInputDouble("how much your angle in degree ?");
				System.out.println("Your angle is " + calculationRadianAngle(angle) + " radian(s)");
				break;
			case 2:
				angle = userInputDouble("how much your angle in radian ?");
				System.out.println("Your angle is " + calculationDegreeAngle(angle) + " degree(s)");
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
