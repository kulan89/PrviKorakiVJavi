import java.awt.Color;
import java.awt.Graphics;

public class Trikotnik extends Lik{
	protected int x2;
	protected int y2;
	protected int x3;
	protected int y3;

	public Trikotnik(int x, int y, int x2, int y2, int x3, int y3, Color barva) {
		super(x, y, barva);
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	
	public Trikotnik(int x, int y, int x2, int y2, int x3, int y3) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	@Override
	public double ploscina() {
		return 0.5*Math.abs(x*(y2 - y3) + x2*(y3 - y) + x3*(y - y2));
	}

	@Override
	public void narisiSe(Graphics g) {
		int[] X = {x, x2, x3};
		int[] Y = {y, y2, y3};
		g.fillPolygon(X, Y, 3);
		
	}

}
