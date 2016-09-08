package mario;

public class Mario {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			for (int i1 = (4 - i); i1 > 0; i1--) System.out.print(" ");
			for (int i2 = 0; i2 < (i + 1); i2++) System.out.print("#");
			System.out.print("\n");
		}
		
		System.out.println();
		
		for (int j = 0; j < 5; j++) {
			for (int j1 = 0; j1 < (j + 1); j1++) System.out.print("#");
			for (int j2 = (4 - j); j2 > 0; j2--) System.out.print(" ");
			System.out.print("\n");
		}
		
		System.out.println();

		for (int k = 0; k < 5; k++) {
			for (int k1 = 0; k1 < k; k1++) System.out.print(" ");
			for (int k2 = (5 - k); k2 > 0; k2--) System.out.print("#");
			System.out.print("\n");
		}
		
		System.out.println();
		
		for (int l = 0; l < 5; l++) {
			for (int l1 = (5 - l); l1 > 0; l1--) System.out.print("#");
			for (int l2 = 0; l2 < l; l2++) System.out.print(" ");
			System.out.print("\n");
		}

	}

}
