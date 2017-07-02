import java.util.Arrays;

/**
 * Pišemo zaporedje, ki se začne z "1" -> "11" -> "21" -> "1211" -> "111221" itd.
 * @author alenka
 *
 */
public class ZaporedjeZEna {
	/**
	 * Zgeneriramo zaporedje iz podanega niza
	 * @param zaporedje
	 * @return naslednje zaporedje
	 */
	public static String naslednjeZaporedje (String zaporedje) {
		int stevec = 1;
		int prejsnja_stevilka = Character.getNumericValue(zaporedje.charAt(0));
		String novo_zaporedje = new String();
		
		for (int i = 1; i < zaporedje.length(); i++) {
			int stevilka = Character.getNumericValue(zaporedje.charAt(i));
			
			if (stevilka == prejsnja_stevilka) {
				stevec++;
			} else {
				novo_zaporedje += Integer.toString(stevec);
				novo_zaporedje += Integer.toString(prejsnja_stevilka);
				
				prejsnja_stevilka = stevilka;
				stevec = 1;				
			}
		}
		
		novo_zaporedje += Integer.toString(stevec);
		novo_zaporedje += Integer.toString(prejsnja_stevilka);
		return novo_zaporedje;
	}
	
	public static String[] generirajZaporedje(int n) {
		String[] zaporedja = new String[n];
		zaporedja[0] = "1";
		
		for (int i = 1; i < n; i++) {
			zaporedja[i] = naslednjeZaporedje(zaporedja[i-1]);
		}
		
		return zaporedja;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(generirajZaporedje(40)));

	}

}
