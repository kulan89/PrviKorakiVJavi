
/**
 * Dve različni metodi za poudarjanje znakov v danem nizu
 * @param niz
 */
public class PoudarjanjeZnakov {

	
   /**
	* Iz podanega niza naredimo nov niz tako, da vse črke zapišemo z veliko in vmes damo presledke
	*/
	public static String velike_crke (String niz) {
		
		String novNiz = new String();
		
		for (int i = 0; i < niz.length(); i++) {
			
			novNiz += Character.toUpperCase(niz.charAt(i)) + " ";
			
		}
		return novNiz.trim();
	}
	
	
	
	/**
	 * Iz podanega niza naredimo novega tako, da se elemente med zvezdicami zapiše z velikimi črkami
	 * @param niz z zvezdicami
	 */
	public static String samo_oznacene (String niz) {
		
		
		String novNiz = new String();
		boolean bVelikeCrke = false;
		for (int i = 0; i < niz.length(); i++) {
			
			char crka = niz.charAt(i); 
			
			if (crka == '*' ) {
				bVelikeCrke = !bVelikeCrke; //pri zvezdicah obrnemo stanje
				continue; //gremo takoj v for in i povečamo za ena
			}
			
			novNiz += bVelikeCrke ? Character.toUpperCase(crka) : crka; //ce so velike črke True, pišemo z velikimi črkami, sicer z malimi	
		}
		
		return novNiz;
	}
	
	
	
	public static void main(String[] args) {
		String niz1 = "Zadnja *novica* danes je *Slovenija zmagala!";
		System.out.println(velike_crke(niz1));
		System.out.println(samo_oznacene(niz1));
		
	}

}
