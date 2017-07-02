import java.util.ArrayList;
import java.util.Collections;
/**
 * Za podano stevilo n bomo zgenerirali Collatzovo zaporedje; 
 * - če je n sod, delimo z 2
 * - če je n lih, množimo s 3 in prištejemo 1.
 * Razred vsebuje metode za izračun dolžine zaporedja, za izračun največjega člena ter za izpis vseh členov.
 * @param n
 */
public class CollatzovoZaporedje {
	

	
	public static int naslednjiElement (int n) {
		if (n % 2 == 0) {
			n = n/2;
		} else {
			n = 3*n + 1;
		}
		
		return n;
	}
	
	
	/**
	 * Vrnemo dolžino C. zaporedja za podano stevilo n
	 */
	public static int dolzina (int n) {
		
		
		int l = 1; //dolžina zaporedja
		
		while (n != 1) {
			n = naslednjiElement(n);
			l++;
		}
		
		return l;
	}
	
	/**
	 * Vrnemo seznam vseh členov C. zaporedja za podano število n
	 */
	public static ArrayList<Integer> vsi_cleni (int n) {
		
		
		ArrayList<Integer> zaporedje = new ArrayList<Integer>(); //seznam členov zaporedja
		zaporedje.add(n);
		
		while (n != 1) {
			n = naslednjiElement(n);
			zaporedje.add(n);
		}
		
		return zaporedje;
	}
	
	/**
	 * Vrnemo največji člen C. zaporedja za podano število n
	 */
	public static int max_clen (int n) {
		return Collections.max(vsi_cleni(n)); //poiščemo max člen
	}
	
	
	
	
	public static void main(String[] args) {
		int n = 60;
		System.out.println(dolzina(n));
		System.out.println(vsi_cleni(n));
		System.out.println(max_clen(n));

	}

}
