/**
 * 
 */
package consolidation;

/**
 * @author Frederick
 * 
 *         class to test differences transformations of an array
 *
 */
public class PositiveArray {
	private static int[] basicArray = { 1, -2, -5, 3, 8, 0, -10, 14 }; // initialisation of the basic array

	/**
	 * method to transform the negative number in 0
	 * 
	 * @param array
	 * @return
	 */
	private static int[] positiveArray(int[] array) {
		for (int i = 0; i != array.length; i++) {
			if (array[i] < 0)
				array[i] = 0;
		}
		return array;
	}

	/**
	 * method to copy totally and not superficial
	 * 
	 * @param array
	 * @return
	 */
	private static int[] copyEqualsArray(int[] array) {
		int[] newArray = new int[array.length];
		for (int i = 0; i != newArray.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	/**
	 * method to copy and transform negative number in the same time
	 * 
	 * @param array
	 * @return
	 */
	private static int[] transformArray(int[] array) {
		return positiveArray(copyEqualsArray(array));
	}

	/**
	 * method to keep only the positive number in a new array
	 * 
	 * @param array
	 * @return
	 */
	private static int[] onlyPositiveNumber(int[] array) {
		int length = 0;
		for (int i = 0; i != array.length; i++) {
			if (array[i] >= 0)
				length++;
		}
		int[] newArray = new int[length];
		int j = 0;
		for (int i = 0; i != array.length; i++) {
			if (array[i] >= 0) {
				newArray[j] = array[i];
				j++;
			}
		}
		return newArray;
	}

	/**
	 * method to display a array
	 * 
	 * @param array
	 * @return
	 */
	public static String display(int[] array) {
		String str = " | ";
		for (int i = 0; i != array.length; i++) {
			str += array[i] + " | ";
		}
		return str;
	}

	/**
	 * main body to treat the differences transformations of an array
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The basic array : " + display(basicArray));
		System.out.println("*********************************************************************************");
		int[] copy = copyEqualsArray(basicArray);
		System.out.println("Display the copy of the basic array : " + display(copy));
		System.out
				.println("First method : to converse negoative number of copy in 0 ==>" + display(positiveArray(copy)));
		System.out.println("*********************************************************************************");
		System.out.println("Display the basic array : " + display(basicArray));
		System.out.println("Second method : to copy AND converse negoative number of basic array in 0 ==>"
				+ display(transformArray(basicArray)));
		System.out.println("New display of the basic array to check is not change : " + display(basicArray));
		System.out.println("*********************************************************************************");
		System.out.println("Display the basic array : " + display(basicArray));
		System.out.println("Third method : to copy AND converse only positive number of basic array ==>"
				+ display(onlyPositiveNumber(basicArray)));
		System.out.println("New display of the basic array to check is not change : " + display(basicArray));
	}

}
