package debug;

public class Exercice1_1 {

	/**
	 * J'ai un problème à l'exécution de ce programme Java.
	 * 
	 * ==> erreurs corrigées : dans les boucles for l'indice commence à 0 et non 1.
	 * ==> en conséquence l'indice i doit être < à 4 et non pas 5.
	 */
	public static void main(String[] args) {
		int[] numbers = new int[4];
		for (int i = 0; i < 4; i++) {
			System.out.println("About to try to insert " + i + " into the array at position " + i);
			numbers[i] = i;
			System.out.println("Successful");
		}

		System.out.print("This is what is in the array: ");
		for (int i = 0; i < 4; i++) {
			int element = numbers[i];
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
