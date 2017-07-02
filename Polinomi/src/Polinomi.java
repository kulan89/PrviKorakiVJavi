import java.util.ArrayList;
import java.util.Arrays;

/**
 * Za podan polinom v obliki tabele koeficientov poiscimo n-ti odvod
 * @param args
 */
public class Polinomi {

	/**
	 * Vrnili bomo seznam koeficientov za podan prvi odvod polinoma
	 */
	public static int[] odvajaj (int[] polinom) {
		
		int[] odvod = new int[polinom.length - 1];
		
		for (int i = 1; i < polinom.length; i++) {
			
			odvod[i - 1] = polinom[i] * i;
		}
		
		return odvod;
		
	}
	/**
	 * Vrnili bomo seznam koeficientov za podan n-ti odvod polinoma
	 * @param polinom
	 * @param n
	 * @return n-ti odvod polinoma
	 */
	public static int[] odvajaj_n_krat (int[] polinom, int n) {
		
		
		while (n > 0) {
			polinom = odvajaj(polinom);
			n--;
		}
		
		return polinom;
	}
	
	public static int[] odvajaj_n_krat (int[] polinom) {

		return odvajaj_n_krat(polinom, 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 System.out.println(Arrays.toString(odvajaj_n_krat(new int[]{1, 1, 2, 2, 5, 3}, 5)));
	}

}
