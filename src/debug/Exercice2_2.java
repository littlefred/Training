package debug;

public class Exercice2_2 {

  /**
   * Ce programme m'affiche une jolie erreur. Que ce passe t-il ?
   * 
   * ==> erreur corrigée : cela bouclait à l'infini car il n'y avait pas a valeur minimum de n.
   */
  public static void main(String[] args) {
    System.out.println(fibonacciRec(5));
  }

  /**
   * Math function to find the nth Fibonacci number (recursive)
   * 
   * @param n nth Fibonacci index
   * @return the nth Fibonacci number
   */
  public static int fibonacciRec(int n) {
    int result = 0;
    
    if(n<=2) { //mise en place de la valeur minimum de n et pouvoir sortir de la récursivité.
    	return 1;
    }

    result = fibonacciRec(n - 1) + fibonacciRec(n - 2);

    return result;
  }
}
