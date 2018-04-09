/**
 * 
 */
package consolidation;

/**
 * @author Frederick
 *
 */
public class IsDiagonal {
	private static String[][] emptyArray = { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
			{ "", "", "", "", "" }, { "", "", "", "", "" } }; // initialisation an array without
																// diagonal
	private static String[][] onlyDiagonalBottomArray = { { "X", "", "", "", "" }, { "", "X", "", "", "" },
			{ "", "", "X", "", "" }, { "", "", "", "X", "" }, { "", "", "", "", "X" } }; // initialisation an array with
																							// only one diagonal
	private static String[][] onlyDiagonalTopArray = { { "", "", "", "", "X" }, { "", "", "", "X", "" },
			{ "", "", "X", "", "" }, { "", "X", "", "", "" }, { "X", "", "", "", "" } }; // initialisation an array with
																							// only another one diagonal
	private static String[][] okDiagonalArray = { { "X", "", "", "", "X" }, { "", "X", "", "X", "" },
			{ "", "", "X", "", "" }, { "", "X", "", "X", "" }, { "X", "", "", "", "X" } }; // initialisation a correct
																							// array
	private static String[][] koDiagonalArray = { { "X", "", "", "", "X" }, { "", "X", "", "X", "" },
			{ "", "", "", "", "" }, { "", "X", "", "X", "" }, { "X", "", "", "", "X" } }; // initialisation an array
																							// without
																							// diagonal

	/**
	 * method to display a grid
	 * 
	 * @param array
	 */
	private static void display(String[][] array) {
		System.out.println("-----------");
		String str = "|";
		for (int i = 0; i != array.length; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if (!array[i][j].equals("")) {
					str += array[i][j] + "|";
				} else {
					str += " |";
				}
			}
			System.out.println(str);
			str = "|";
		}
		System.out.println("-----------");
	}

	/**
	 * method to check if there is ONLY the bottom diagonal
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkBottomDiagonalOnly(String[][] array) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if (i == j && array[i][j].equals("")) {
					check = false;
				}
				if (i != j && !array[i][j].equals("")) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there is the bottom diagonal without check the others
	 * cases
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkSimpleBottomDiagonal(String[][] array) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if (i == j && array[i][j].equals("")) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there is ONLY the top diagonal
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkTopDiagonalOnly(String[][] array) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if (i == array.length - 1 - j && j == array.length - 1 - i && array[i][j].equals("")) {
					check = false;
				}
				if (i != array.length - 1 - j && j != array.length - 1 - i && !array[i][j].equals("")) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there is the top diagonal without check the others cases
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkSimpleTopDiagonal(String[][] array) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if (i == array.length - 1 - j && j == array.length - 1 - i && array[i][j].equals("")) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there are two diagonal without check the others cases
	 * 
	 * this method use simple method of top diagonal and bottom diagonal
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkGlobalDiagonal(String[][] array) {
		return checkSimpleBottomDiagonal(array) ? checkSimpleTopDiagonal(array) : false;
	}

	/**
	 * method to check if there are ONLY two diagonal
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkGlobalDiagonalOnly(String[][] array) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				if ((i == j || (i == array.length - 1 - j && j == array.length - 1 - i)) && array[i][j].equals("")) {
					check = false;
				}
				if (i != j && (i != array.length - 1 - j && j != array.length - 1 - i) && !array[i][j].equals("")) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * main body to check diagonal in a grid
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to exercise to check diagonal");
		System.out.println("************************************************");
		System.out.println("FIRST EXAMPLE :");
		display(emptyArray);
		System.out.println("Check the bottom diagonal only : " + checkBottomDiagonalOnly(emptyArray));
		System.out.println("Check the top diagonal only : " + checkTopDiagonalOnly(emptyArray));
		System.out.println("Check the bottom diagonal is drawn : " + checkSimpleBottomDiagonal(emptyArray));
		System.out.println("Check the top diagonal is drawn : " + checkSimpleTopDiagonal(emptyArray));
		System.out.println("Check two diagonals are drawn : " + checkGlobalDiagonal(emptyArray));
		System.out.println("Check two diagonals only are drawn : " + checkGlobalDiagonalOnly(emptyArray));
		System.out.println("************************************************");
		System.out.println("SECOND EXAMPLE :");
		display(onlyDiagonalBottomArray);
		System.out.println("Check the bottom diagonal only : " + checkBottomDiagonalOnly(onlyDiagonalBottomArray));
		System.out.println("Check the top diagonal only : " + checkTopDiagonalOnly(onlyDiagonalBottomArray));
		System.out
				.println("Check the bottom diagonal is drawn : " + checkSimpleBottomDiagonal(onlyDiagonalBottomArray));
		System.out.println("Check the top diagonal is drawn : " + checkSimpleTopDiagonal(onlyDiagonalBottomArray));
		System.out.println("Check two diagonals are drawn : " + checkGlobalDiagonal(onlyDiagonalBottomArray));
		System.out.println("Check two diagonals only are drawn : " + checkGlobalDiagonalOnly(onlyDiagonalBottomArray));
		System.out.println("************************************************");
		System.out.println("THIRD EXAMPLE :");
		display(onlyDiagonalTopArray);
		System.out.println("Check the bottom diagonal only : " + checkBottomDiagonalOnly(onlyDiagonalTopArray));
		System.out.println("Check the top diagonal only : " + checkTopDiagonalOnly(onlyDiagonalTopArray));
		System.out.println("Check the bottom diagonal is drawn : " + checkSimpleBottomDiagonal(onlyDiagonalTopArray));
		System.out.println("Check the top diagonal is drawn : " + checkSimpleTopDiagonal(onlyDiagonalTopArray));
		System.out.println("Check two diagonals are drawn : " + checkGlobalDiagonal(onlyDiagonalTopArray));
		System.out.println("Check two diagonals only are drawn : " + checkGlobalDiagonalOnly(onlyDiagonalTopArray));
		System.out.println("************************************************");
		System.out.println("FOURTH EXAMPLE :");
		display(okDiagonalArray);
		System.out.println("Check the bottom diagonal only : " + checkBottomDiagonalOnly(okDiagonalArray));
		System.out.println("Check the top diagonal only : " + checkTopDiagonalOnly(okDiagonalArray));
		System.out.println("Check the bottom diagonal is drawn : " + checkSimpleBottomDiagonal(okDiagonalArray));
		System.out.println("Check the top diagonal is drawn : " + checkSimpleTopDiagonal(okDiagonalArray));
		System.out.println("Check two diagonals are drawn : " + checkGlobalDiagonal(okDiagonalArray));
		System.out.println("Check two diagonals only are drawn : " + checkGlobalDiagonalOnly(okDiagonalArray));
		System.out.println("************************************************");
		System.out.println("FIFTH EXAMPLE :");
		display(koDiagonalArray);
		System.out.println("Check the bottom diagonal only : " + checkBottomDiagonalOnly(koDiagonalArray));
		System.out.println("Check the top diagonal only : " + checkTopDiagonalOnly(koDiagonalArray));
		System.out.println("Check the bottom diagonal is drawn : " + checkSimpleBottomDiagonal(koDiagonalArray));
		System.out.println("Check the top diagonal is drawn : " + checkSimpleTopDiagonal(koDiagonalArray));
		System.out.println("Check two diagonals are drawn : " + checkGlobalDiagonal(koDiagonalArray));
		System.out.println("Check two diagonals only are drawn : " + checkGlobalDiagonalOnly(koDiagonalArray));
	}

}
