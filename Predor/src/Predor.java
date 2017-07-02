import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Predor {

	/**
	 * Funkcija vrne True/False glede na to, ali je bila presežena dovoljena hitrost
	 * @param zacetek
	 * @param konec
	 * @return
	 */
	public static boolean prekrsek (int zacetek, int konec) {
		
		double min_cas = 36*622.0/800; //minimalen cas, ki naj ga voznik porabi, da prevozi predor dolg 622 m, če je omejitev hitrosti 80 kmh
		if (konec - zacetek < min_cas) {
			return true; //zgodil se je prekršek
		}
		
		return false;
	}
	
	/**
	 * Funkcija iz prebrane vrstice pobere podatke o prekrskarjih
	 * @param vrstica
	 * @return 
	 * @return podatki po posameznih voznikih v obliki seznama: registrska in hitrost
	 */
	public static String[] analizaPrekrskov (String vrstica) {
		
		String[] podatki = vrstica.split(" ");
		String[] prekrskar = new String[2];

		int zacetek = Integer.valueOf(podatki[0]);
		int konec = Integer.valueOf(podatki[1]);
		
		int cas_voznje = konec - zacetek; //izračunamo povprečno hitrost za naš čas in razdaljo
		double povpr_hitrost = (622.0 / cas_voznje)*3.6; // .0 zato, da ne delimo celoštevilsko
		
				
		if (prekrsek(zacetek, konec)) {
			double kmh = Math.round(povpr_hitrost*100)/100.0;
			prekrskar[0] = Double.toString(kmh);
			prekrskar[1] = podatki[2];
			
		}
		
		return  prekrskar;
		
	}
	
	
		public static void main(String[] args) throws IOException {
			BufferedReader podatki = new BufferedReader(new FileReader(args[0]));
			BufferedWriter zapisovalec = new BufferedWriter(new FileWriter(args[1])); 
			
			while (podatki.ready()) {
				String vrstica = podatki.readLine();
				String[] seznam = analizaPrekrskov(vrstica);
				
				if(seznam[0] != null) {
					zapisovalec.write(seznam[0] + " kmh;   ");
					zapisovalec.write(seznam[1]);
					zapisovalec.newLine();
				
					
				}
				
			}

			zapisovalec.close();
			podatki.close();
		

	}

}


/*public static  Par<Integer, String>  asd (String vrstica) {
	
	String[] podatki = vrstica.split(" ");
	String prekrskar = new String();
	String[] s = new String[10];
	Par<Integer, String> pariPrekrska = new Par<Integer, String>();

	
	int zacetek = Integer.valueOf(podatki[0]);
	int konec = Integer.valueOf(podatki[1]);
	int cas_voznje = konec - zacetek;
	
	if (prekrsek(zacetek, konec)) {
		
	}
	
	return  pariPrekrska;*/