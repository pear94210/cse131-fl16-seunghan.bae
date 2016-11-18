package exam2;

public class Prove {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5};
		reverse(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void reverse(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[array.length - 1];
			for (int j = array.length - 2; j >= i; j--) {
				array[j + 1] = array[j];
			}
			array[i] = temp;
		}
	}

}
