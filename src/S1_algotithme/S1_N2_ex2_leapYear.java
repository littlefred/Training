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
public class S1_N2_ex2_leapYear {
	private static Scanner scanner = new Scanner(System.in); // open the scanner

	private static int year1; // attribute to save the first year
	private static int year2; // attribute to save the second year

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
	 * method to verify if one year is a leap year
	 * 
	 * @param year
	 * @return
	 */
	private static boolean verifyLeapYear(int year) {
		boolean result = false;
		int test1 = year % 400;
		int test2 = year % 4;
		int test3 = year % 100;
		if (test1 == 0 || (test2 == 0 && test3 != 0)) {
			result = true;
		}
		return result;
	}

	/**
	 * method to check which years are leap years in a set of years
	 * 
	 * @param year1
	 * @param year2
	 */
	private static void verifySetLeapYear(int year1, int year2) {
		if (year1 > year2) {
			int tempYear = year1;
			year1 = year2;
			year2 = tempYear;
		}
		int nb = 0;
		String str = "";
		for (int yearOfReference = year1; yearOfReference <= year2; yearOfReference++) {
			boolean result = verifyLeapYear(yearOfReference);
			if (result && str.equals("")) {
				str = " (";
			}
			if (result) {
				nb++;
				str += "." + yearOfReference;
			}
		}
		if (!str.equals("")) {
			str += ".)";
		}
		System.out.println("In your set of years, you have " + nb + " leap years" + str + ".");
	}

	/**
	 * main body to check the leap years
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here we can verify the leap year.");
		int userChoice;
		do {
			System.out.println("What do you want to do ?");
			System.out.println("1 - Verify one leap year.");
			System.out.println("2 - Verify a set of years.");
			System.out.println("0 - Quit the application.");
			userChoice = userInputInt("your choice : ");
			switch (userChoice) {
			case 1:
				year1 = userInputInt("what is the year that you want to verify ?");
				boolean result = verifyLeapYear(year1);
				if (result) {
					System.out.println("The year " + year1 + " is a leap year.");
				} else {
					System.out.println("The year " + year1 + " is not a leap year.");
				}
				break;
			case 2:
				year1 = userInputInt("what is the first year of your set ?");
				year2 = userInputInt("what is the final year of your set ?");
				verifySetLeapYear(year1, year2);
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
