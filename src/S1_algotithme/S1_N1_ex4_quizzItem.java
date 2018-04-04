/**
 * 
 */
package S1_algotithme;

import java.util.Scanner;

/**
 * @author Frederick
 *
 */
public class S1_N1_ex4_quizzItem {
	private final String question; // attribute to have the question of the quiz
	private final String answer; // attribute to have the answer of this question
	private final int nbPoint; // attribute to have the point(s) of this question

	private static Scanner scanner = new Scanner(System.in); // open the scanner

	private static final int NB_TEST = 3; // attribute to generate a number to test to have a good answer

	/**
	 * constructor of this class
	 * 
	 * @param question
	 * @param answer
	 * @param nbPoint
	 */
	public S1_N1_ex4_quizzItem(String question, String answer, int nbPoint) {
		this.question = question;
		this.answer = answer;
		this.nbPoint = nbPoint;
	}

	/**
	 * getter of nbPoint
	 * 
	 * @return
	 */
	public int getNbPoint() {
		return nbPoint;
	}
	
	/**
	 * method to test the user with a question of a quiz
	 * @return
	 */
	public int testGoodAnswer() {
		int result = 0;
		for(int i=1 ; i<=NB_TEST ; i++) {
			System.out.println(question);
			String proposition = scanner.nextLine();
			if(proposition.equalsIgnoreCase(answer)) {
				System.out.println("Good job ! You win "+nbPoint+" point(s).");
				i=4;
				result = nbPoint;
			}else if (i<NB_TEST){
				System.err.println("Sorry it's wrong, please try again.");
			}else {
				System.err.println("Sorry it's wrong again, the good answer is "+answer+".");
			}
		}
		return result;
	}

}
