
public class Glavni_program {

	public static void main(String[] args) {
		Ulomek p = new Ulomek(2, 3);
		p.pristej(new Ulomek(1,7));
		System.out.println(p);
		Ulomek q = new Ulomek(6, 7);
		System.out.println(p.vsota(q));

	}

}
