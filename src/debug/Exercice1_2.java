package debug;

public class Exercice1_2 {

	/**
	 * Ce programme doit me retourner le complément d'une chaîne d'ADN mais ça ne
	 * fonctionne pas.
	 * 
	 * ==> erreurs corrigées : il manquait les break dans chaque cas du swith et le cas par défaut
	 */
	public static void main(String[] args) {
		System.out.println(makeDNAComplement("AATGCCGGC"));
		System.out.println(makeDNAComplement("TTACGGCCG"));
		System.out.println(makeDNAComplement("AATTCCGTACGGA"));
	}

	/**
	 * Function that returns a DNA string complement.
	 * 
	 * @param dna
	 *            the DNA string to complement.
	 * @return complemented DNA string. Example : input ("AATGCCGGC") => output
	 *         ("TTACGGCCG").
	 */
	public static String makeDNAComplement(String dna) {
		String result = "";
		if (dna != null && !dna.isEmpty()) {
			char[] dnaCharArray = dna.toCharArray();

			for (char dnaChar : dnaCharArray) {
				switch (dnaChar) {
				case 'A':
					result = result.concat("T");
					break;
				case 'T':
					result = result.concat("A");
					break;
				case 'C':
					result = result.concat("G");
					break;
				case 'G':
					result = result.concat("C");
					break;
				default:
					break;
				}
			}
		}
		return result;
	}

}
