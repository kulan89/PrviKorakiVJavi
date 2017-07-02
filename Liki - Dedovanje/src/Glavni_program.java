import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

public class Glavni_program {

	public static void main(String[] args) {
		Vector<Lik> mojiLiki = new Vector<Lik>();
		mojiLiki.add(new Krog(30, 40, 50));
		mojiLiki.add(new Kvadrat(20, 30, 10, Color.BLUE));
		mojiLiki.addElement(new Trikotnik(0, 50, 10, 60, 20, 30, Color.CYAN));
		
		JFrame okno = new GeoFrame(mojiLiki);
		okno.pack();
		okno.setVisible(true);

	}

}
