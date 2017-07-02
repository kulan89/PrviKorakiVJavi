
public class Ulomek {
	
	private long stevec;
	private long imenovalec;
	
	public Ulomek(long stevec, long imenovalec) {
		this.stevec = stevec;
		this.imenovalec = imenovalec;
	}
	
	public Ulomek(long stevec) {
		super();
		this.stevec = stevec;
		this.imenovalec = 1;
	}

	/**
	 * Metoda za krajšanje ulomkov
	 */
	public void okrajsaj() {
		long d = gcd(this.stevec, this.imenovalec);
		this.stevec = this.stevec/d;
		this.imenovalec = this.imenovalec/d;
		
		
	}

	/**
	 * Funkcija, ki poišče gcd dveh števil
	 * @param a
	 * @param b
	 * @return int gcd
	 */
	private static long gcd(long a, long b) {
		if (b==0) {
			return a;
		} else {
		return gcd(b, a%b);
	}
	}
	
	public String toString() {
		return stevec + "/" + imenovalec;
	}
	
	
	/**
	 * Seštejemo dva ulomka
	 * @param u
	 * @return Ulomek
	 */
	public Ulomek vsota(Ulomek u) {
		Ulomek v = new Ulomek(this.stevec*u.imenovalec + u.stevec*this.imenovalec, this.imenovalec*u.imenovalec);
		v.okrajsaj();
		return v;
	}
	
	
	public void pristej(Ulomek u) {
		long novi_stevec = this.stevec*u.imenovalec + u.stevec*this.imenovalec;
		long novi_imenovalec = this.imenovalec*u.imenovalec;
		this.stevec = novi_stevec;
		this.imenovalec = novi_imenovalec;
		this.okrajsaj();
		
		
	}
}
