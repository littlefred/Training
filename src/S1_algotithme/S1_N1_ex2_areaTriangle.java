/**
 * 
 */
package S1_algotithme;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Frederick : exercise calculation of the area of a triangle
 *
 */
public class S1_N1_ex2_areaTriangle {
	private static double base = 0; // attribute of the base of the triangle
	private static double height = 0; // attribute of the height of the triangle
	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to calculate the area of a triangle
	 * 
	 * @param base
	 * @param hauteur
	 * @return
	 */
	private static double calculationAreaTriangle(double base, double hauteur) {
		double result = (base * hauteur) / 2;
		return result;
	}

	/**
	 * method to receive the user information since double
	 * 
	 * @param message
	 * @return
	 */
	private static double userInput(String message) {
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
	 * exercise to calculate the area of the triangle
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can calculate the area of a triangle.");
		base = userInput("How much does the base of the triangle ?");
		height = userInput("How much does the height of the triangle ?");
		System.out.println("the area of your triangle is : " + calculationAreaTriangle(base, height));
	}

}
