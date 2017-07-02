import java.awt.Color;
import java.awt.Graphics;

public class Krog extends Lik{
	protected int r;

	public Krog(int x, int y, int r, Color barva) {
		super(x, y, barva);
		this.r = r;
	}
	
	public Krog(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}
	@Override
	public double ploscina() {
		return Math.PI * this.r * this.r;
	}

	@Override
	public void narisiSe(Graphics g) {
		g.fillOval(x - r, y - r, 2*r, 2*r);
		
	}
	
	public String toString() {
		return "Krog [r=" + r + "]";
	}

}
