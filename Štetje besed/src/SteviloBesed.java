import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SteviloBesed {
	
	
	/**
	 * Funkcija bo iz nizov odstranila znake, katerih nočemo
	 * @param vhodniNiz
	 * @return niz
	 */
	public static String obreziNiz (String vhodniNiz) {
		
		String locila = "?!.,:;- ";
		String obrezan_niz = new String();
		
		for (int i = 0; i < vhodniNiz.length(); i++) {
			String crka = Character.toString(vhodniNiz.charAt(i));
			
			if (!locila.contains(crka)) {
				obrezan_niz += crka;
			}
		}
		
		return obrezan_niz;
	}
	/**
	 * Funkcija bo vračala seznam besed iz vrstice
	 * @param vrstica
	 * @return seznam besed
	 */
	public static String[] razcleniVrstico (String vrstica) {
		
		ArrayList<String> seznam_besed = new ArrayList<String>();
		vrstica = vrstica.trim();
		String[] neobdelane_besede = vrstica.split(" "); //razčlenimo vrstico na besede
		
		for (int i = 0; i < neobdelane_besede.length; i++) {
			String beseda = neobdelane_besede[i].trim();
			beseda = obreziNiz(beseda);
			if (!beseda.isEmpty() && !beseda.contains(" ")) {
				seznam_besed.add(beseda);
			}
		}
		
		return seznam_besed.toArray(new String[0]);
	}

	public static int zapisiVDat (BufferedWriter zapisovalec, String[] seznam_besed) throws IOException {
		
		for (int i = 0; i < seznam_besed.length; i++) {
			zapisovalec.write(seznam_besed[i]);
			zapisovalec.newLine();
		}
		
		return seznam_besed.length;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		if (args.length < 2) {
			System.out.println("Podaj pot do vhodne in izhodne datoteke!");
			
			return;
		}
		
		BufferedReader bralec = new BufferedReader(new FileReader(args[0]));
		BufferedWriter zapisovalec = new BufferedWriter(new FileWriter(args[1])); 
		int stevec = 0;
				
		while (bralec.ready()) {
			String vrstica = bralec.readLine();
			String[] seznam_besed = razcleniVrstico(vrstica);
			
			stevec += zapisiVDat(zapisovalec, seznam_besed);	
			
		}

		zapisovalec.close();
		bralec.close();
		
		System.out.println("Število zapisanih besed v izhodno datoteko: " + stevec);
	}

}
