/**
 * 
 */
package S1_algotithme;

import java.util.Scanner;

/**
 * @author Frederick : exercise to display Hello with the name
 */
public class S1_N1_ex1_hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, what is your name ?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Hello " + name + " !");
		scanner.close();
	}

}
