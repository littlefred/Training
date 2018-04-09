/**
 * 
 */
package tools;

/**
 * @author Frederick
 * 
 *         class to generate a grid for game (example : TicTacToe)
 */
public class Grid {
	private String[][] grid; // attribute to save the grid
	private final int sizeCase; // attribute to save the size of a box
	private final int nbBoxY; // attribute to save the number of boxes for the height of the grid
	private final int nbBoxX; // attribute to save the number of boxes for the width of the grid
	private final int nbTotalBoxes; // attribute to save the total number of boxes in your grid

	/**
	 * constructor
	 * 
	 * @param nbCase
	 * @param grid
	 */
	public Grid(int nbCase) {
		this.nbBoxY = nbCase;
		this.nbBoxX = nbCase;
		this.grid = new String[nbCase][nbCase];
		this.nbTotalBoxes = nbCase * nbCase;
		this.sizeCase = (Integer.toString(nbTotalBoxes)).length();
	}
	
	/**
	 * constructor
	 * 
	 * @param nbCase
	 * @param grid
	 */
	public Grid(int nbBoxY, int nbBoxX) {
		this.nbBoxY = nbBoxY;
		this.nbBoxX = nbBoxX;
		this.grid = new String[nbBoxY][nbBoxX];
		this.nbTotalBoxes = nbBoxY * nbBoxX;
		this.sizeCase = (Integer.toString(nbTotalBoxes)).length();
	}

	/**
	 * @return the grid
	 */
	public String[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(String[][] grid) {
		this.grid = grid;
	}

	/**
	 * @return the nbTotalBoxes
	 */
	public int getNbTotalBoxes() {
		return nbTotalBoxes;
	}

	/**
	 * method to display the grid
	 * 
	 * @param grid
	 */
	public void displayGrid(String[][] grid) {
		// display the top of the grid
		String str = "-";
		for (int i = 0; i != (sizeCase + 1) * nbBoxX; i++) {
			str += "-";
		}
		System.out.println(str);
		// display the body of the grid
		int number = 1;
		for (int i = 0; i != grid.length; i++) {
			str = "|";
			for (int j = 0; j != grid[i].length; j++) {
				if (grid[i][j] != null) {
					str += grid[i][j] + "|";
					number++;
				} else {
					str += displayCase(number) + "|";
					number++;
				}
			}
			System.out.println(str);
		}
		// display the bottom of the grid
		str = "-";
		for (int i = 0; i != (sizeCase + 1) * nbBoxX; i++) {
			str += "-";
		}
		System.out.println(str);
	}

	/**
	 * method to generate the body of a box of the grid when this is empty
	 * 
	 * @return
	 */
	private String displayCase(int number) {
		String str = "";
		String numb = Integer.toString(number);
		int i = numb.length();
		if (sizeCase == i) {
			str = numb;
		} else {
			int j = sizeCase - i;
			if (j == 1) {
				str = " " + numb;
			} else if (j % 2 == 0) {
				String tempStr = "";
				for (int k = 0; k != j / 2; k++) {
					tempStr += " ";
				}
				str = tempStr + numb + tempStr;
			} else {
				String tempStr = "";
				for (int k = 0; k != j / 2; k++) {
					tempStr += " ";
				}
				str = " " + tempStr + numb + tempStr;
			}
		}
		return str;
	}

	/**
	 * 
	 * @param number
	 * @return the Y coordinated of the number case
	 */
	public int getCoordY(int number) {
		int result = -1;
		for (int i = 0; i != nbBoxY; i++) {
			if (number <= (i + 1) * nbBoxY) {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param number
	 * @return the X coordinated of the number case
	 */
	public int getCoordX(int number) {
		if (number % nbBoxX == 0) {
			return nbBoxX - 1;
		}
		return number % nbBoxX - 1;
	}

}
