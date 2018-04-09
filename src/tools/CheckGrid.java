/**
 * 
 */
package tools;

/**
 * @author Frederick
 * 
 *         class to check a grid if a line is done or not
 */
public abstract class CheckGrid {
	/**
	 * method to check if there is the bottom diagonal who is drawn by one sign
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkSimpleBottomDiagonal(String[][] array, char sign) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				String temp = String.valueOf(array[i][j]);
				if (i == j && !temp.equals(Character.toString(sign))) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there is the top diagonal who is drawn by one sign
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkSimpleTopDiagonal(String[][] array, char sign) {
		boolean check = true;
		for (int i = 0; i != array.length && check; i++) {
			for (int j = 0; j != array[i].length; j++) {
				String temp = String.valueOf(array[i][j]);
				if (i == array.length - 1 - j && j == array.length - 1 - i && !temp.equals(Character.toString(sign))) {
					check = false;
				}
			}
		}
		return check;
	}

	/**
	 * method to check if there is a line who is drawn by one sign
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkRaws(String[][] array, char sign) {
		boolean check = true;
		for (int i = 0; i != array.length; i++) {
			check = true;
			for (int j = 0; j != array[i].length && check; j++) {
				String temp = String.valueOf(array[i][j]);
				if (!temp.equals(Character.toString(sign))) {
					check = false;
				}
			}
			if (check) {
				return check;
			}
		}
		return check;
	}

	/**
	 * method to check if there is a column who is drawn by one sign
	 * 
	 * @param array
	 * @return
	 */
	private static boolean checkColumn(String[][] array, char sign) {
		boolean check = true;
		for (int j = 0; j != array[0].length; j++) {
			check = true;
			for (int i = 0; i != array.length && check; i++) {
				String temp = String.valueOf(array[i][j]);
				if (!temp.equals(Character.toString(sign))) {
					check = false;
				}
			}
			if (check) {
				return check;
			}
		}
		return check;
	}

	/**
	 * method to check a grid if there is a line who is drawn by one sign
	 * 
	 * @param array
	 * @return
	 */
	public static boolean checkGridLineOK(String[][] array, char sign) {
		return (checkSimpleBottomDiagonal(array, sign) ? true
				: (checkSimpleTopDiagonal(array, sign) ? true
						: (checkRaws(array, sign) ? true : (checkColumn(array, sign) ? true : false))));
	}

	/**
	 * method to check a grid to see if one go is still possible
	 * 
	 * @param array
	 * @return
	 */
	public static boolean checkGridIsComplete(String[][] array) {
		for (int i = 0; i != array.length; i++) {
			for (int j = 0; j != array[i].length; j++) {
				String temp = String.valueOf(array[i][j]);
				if (temp.equals("null")) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * method to check a grid box to see if it is free to play
	 * 
	 * @param array
	 * @return
	 */
	public static boolean checkGridBoxIsFree(String[][] array, int Y, int X) {
		String temp = String.valueOf(array[Y][X]);
		if (!temp.equals("null")) {
			return false;
		} else {
			return true;
		}
	}

}
