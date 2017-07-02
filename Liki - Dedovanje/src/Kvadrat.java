import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends Lik {
	private int a;
	
	public int getA() {
		return a;
	}

	public Kvadrat(int x, int y, int a, Color barva) {
		super(x, y, barva);
		this.a = a;
	}
	
	public Kvadrat(int x, int y, int a) {
		super(x, y);
		this.a = a;
	}

	@Override
	public double ploscina() {
		return this.a*this.a;
	}

	@Override
	public void narisiSe(Graphics g) {
		g.setColor(barva);
		g.fillRect(x, y, a, a);
	}
	
	public String toString() {
		return "Kvadrat [a=" + a + "]";
	}

}
