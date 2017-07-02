
import java.util.ArrayList;

public class Prastevila{
	/**
	 * Za podano stevilo n bomo izpisali razcep na prafaktorje z ustreznimi potencami
	 * @param n
	 * @return vrnemo niz, ki je razpisan razcep na prafaktorje danega stevila
	 */

	public static boolean jePrastevilo(int n) {
		/**
		 * Ugotovi, ali je podano stevilo prastevilo
		 */

		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) {
				//ce najdemo delitelja

				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> najdiPrastevila (int n) {
		/**
		 * Najdemo vsa prastevila do nekega danega stevila in jih spravimo v seznam
		 */

		ArrayList<Integer> seznam_prastevil = new ArrayList<Integer>();

		for (int i = 2; i <= n; i++) {

			if (jePrastevilo(i)) {

				seznam_prastevil.add(i);
			}


		}

		return seznam_prastevil;		
	}

	
	public static ArrayList<Integer> zapisiDelitelje (int n) {
		/**
		 * V seznam zapisemo vsa prastevila, ki delijo podano stevilo n
		 */
		
		ArrayList<Integer> seznam_deliteljev = new ArrayList<Integer>();		
		ArrayList<Integer> seznam_kandidatov = najdiPrastevila(n);		
		
		while (n > 1) {
			for (int i = 0; i < seznam_kandidatov.size(); i++ ) {			
				int kandidat = seznam_kandidatov.get(i);
				
				//ce je n deljiv s kandidatom, potem dodaj kandidata v seznam, zmanjsaj n in skoci iz for zanke nazaj v while
				if (n % kandidat == 0) {
					seznam_deliteljev.add(kandidat);
					n = n/kandidat;
					break; 
				}
			}
		}
		
		return seznam_deliteljev;
	}
	
	public static String razcepVNiz (ArrayList<Integer> seznam_deliteljev) {
		/**
		 * Vrnemo izpis na prafaktorje
		 */
		
		String niz = new String();
		for (int i = 0; i < seznam_deliteljev.size(); i++) {			
			int prvi = seznam_deliteljev.get(i);
			
			int nKrat = 1;
			for (int j = i+1; j < seznam_deliteljev.size(); j++) {			
				if(prvi != seznam_deliteljev.get(j) ) { // Ali je nasledno j-to število v seznamu enako i-temu številu v seznamu? 
					break; // nista enaka
				}				
				nKrat++; // sta enaka
			}
			
			niz += (i != 0 ? "*" : "") + Integer.toString(prvi); // dodaj znak za množenje če i ni prvo število in dodaj i-to število iz seznama
			if(nKrat > 1) { // imamo večkratnike i-tega števila?
				niz += "^" + Integer.toString(nKrat); // dodaj znak za potenco in potenco
				i += nKrat -1;                        // povečaj indeks i z nKrat-1
			}
		}
		
		return niz;
	}
	
	
	public static void main(String[] args) {
		int n = 56465389;
		//System.out.println(najdiPrastevila(n));
		//System.out.println(zapisiDelitelje(n));
		System.out.println(razcepVNiz(zapisiDelitelje(n)));
	}
}