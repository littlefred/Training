/**
 * 
 */
package S1_algotithme;

/**
 * @author Frederick : exercise to do the quiz
 *
 */
public class S1_N1_ex4_quizz {
	private static int score; // attribute to save the player score
	private static int maxScore; // attribute to save the maximum sore possible

	/**
	 * play the quiz with use the quizzItem class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		S1_N1_ex4_quizzItem[] item = { new S1_N1_ex4_quizzItem("What is the capital of France ?", "Paris", 1),
				new S1_N1_ex4_quizzItem("What is the capital of Spain ?", "Madrid", 2),
				new S1_N1_ex4_quizzItem("What is the capital of United States ?", "Washington", 3) };

		for (int i = 0; i != item.length; i++) {
			maxScore += item[i].getNbPoint();
			score += item[i].testGoodAnswer();
		}

		System.out.println("your final score is " + score + " point(s) out of a total of " + maxScore + " point(s).");
	}

}
