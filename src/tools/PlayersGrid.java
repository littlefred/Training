/**
 * 
 */
package tools;

/**
 * @author Frederick
 * 
 *         class to generate players and manage score
 *
 */
public class PlayersGrid {
	private final String name;
	private final char sign;
	private int score;

	/**
	 * constructor of class
	 * 
	 * @param name
	 * @param sign
	 * @param score
	 */
	public PlayersGrid(String name, char sign) {
		this.name = name;
		this.sign = sign;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the sign
	 */
	public char getSign() {
		return sign;
	}

	/**
	 * rewriting method toString
	 */
	public String toString() {
		return name + " your score is : " + score + " point(s).";
	}

}
