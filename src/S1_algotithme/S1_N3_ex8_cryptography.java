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
public class S1_N3_ex8_cryptography {
	private static String message; // attribute to save the coordinate Y of the final point
	private static int keyEncryption; // attribute to save the coordinate Y of the final point

	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since String
	 * 
	 * @param message
	 * @return
	 */
	private static String userInputString(String message) {
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
				// if (result >= 0) {
				answer = true;
				// } else {
				// System.err.println("Please could you indicate a positive number.");
				// }
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}

	/**
	 * method to encrypt a message since a key positive or negative
	 * 
	 * @param message
	 * @return
	 */
	private static String encrypt(String message) {
		int key = +keyEncryption;
		return coding(message, key);
	}

	/**
	 * method to decrypt a message since a key positive or negative
	 * 
	 * @param message
	 * @return
	 */
	private static String decrypt(String message) {
		int key = -keyEncryption;
		return coding(message, key);
	}

	/**
	 * method of coding the message
	 * 
	 * @param message
	 * @param key
	 * @return
	 */
	private static String coding(String message, int key) {
		String str = "";
		char[] character = message.toCharArray();
		for (int i = 0; i != character.length; i++) {
			int tempCharacter = (int) character[i];
			if (tempCharacter >= 65 && tempCharacter <= 90 && tempCharacter + key >= 65 && tempCharacter + key <= 90) {
				tempCharacter += key;
				str += (char) tempCharacter;
			} else if (tempCharacter >= 65 && tempCharacter <= 90 && tempCharacter + key < 65) {
				int tempChar = 65 - (tempCharacter + key);
				tempCharacter = 91 - tempChar;
				str += (char) tempCharacter;
			} else if (tempCharacter >= 65 && tempCharacter <= 90 && tempCharacter + key > 90) {
				int tempChar = (tempCharacter + key) - 90;
				tempCharacter = 64 + tempChar;
				str += (char) tempCharacter;
			} else if (tempCharacter >= 48 && tempCharacter <= 57 && tempCharacter + key >= 48
					&& tempCharacter + key <= 57) {
				tempCharacter += key;
				str += (char) tempCharacter;
			} else if (tempCharacter >= 48 && tempCharacter <= 57 && tempCharacter + key < 48) {
				int tempChar = 48 - (tempCharacter + key);
				tempCharacter = 58 - tempChar;
				str += (char) tempCharacter;
			} else if (tempCharacter >= 48 && tempCharacter <= 57 && tempCharacter + key > 57) {
				int tempChar = (tempCharacter + key) - 57;
				tempCharacter = 47 + tempChar;
				str += (char) tempCharacter;
			} else {
				str += (char) tempCharacter;
			}

		}
		return str;
	}

	/**
	 * main body to process the encoding / decoding of a message
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can encrypt or decrypt a coded Caesar encryption message.");
		int userChoice;
		do {
			System.out.println("What do you want to do ?");
			System.out.println("1 - Encrypt a message.");
			System.out.println("2 - Decrypt a message.");
			System.out.println("0 - Quit the application.");
			userChoice = userInputInt("your choice : ");
			if (userChoice == 1 || userChoice == 2) {
				keyEncryption = userInputInt("what is the encryption key : ");
				message = userInputString("what is your message : ");
				String tempMessage = message.toUpperCase();
				message = tempMessage;
			}
			switch (userChoice) {
			case 1:
				System.out.println("Your encrypt message is : " + encrypt(message));
				break;
			case 2:
				System.out.println("Your encrypt message is : " + decrypt(message));
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
