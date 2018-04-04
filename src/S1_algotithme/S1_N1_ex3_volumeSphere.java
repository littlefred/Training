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
public class S1_N1_ex3_volumeSphere {
	private static double radius = 0; // attribute of the radius of the sphere
	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to calculate the volume of a sphere
	 * 
	 * @param base
	 * @param hauteur
	 * @return
	 */
	private static double calculationVolumeSphere(double radius) {
		double result = ((4 * Math.PI) / 3) * Math.pow(radius, 3);
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
	 * exercise to calculate the volume of the sphere
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can calculate the volume of a sphere.");
		radius = userInput("How much does the radius of the sphere ?");
		System.out.println("the volume of your sphere is : " + calculationVolumeSphere(radius));
	}

}
