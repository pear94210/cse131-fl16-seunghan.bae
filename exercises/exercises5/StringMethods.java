package exercises5;

public class StringMethods {
	
	//
	// Below are the methods defined for this exercise
	//   The names are not prescribed in the assignment, so choose
	//   names you like (that are meaningful)
	//
	
	//
	// First one is completed for you:
	//
	
	public static String selfConcat(String s) {
		return nConcat(s, 2);
	}
	
	public static String nConcat(String s, int n) {
		if (n == 0) return "";
		
		else {
			String[] target = new String[n];
			
			for (int i = 0; i < target.length; i++) {
				target[i] = s;
			}
			
			String concat = join(target, "");
			
			return concat;
		}
	}
	
	public static String join(String[] array, String joiner) {
		String ans = array[0];
		
		for (int i = 1; i < array.length; i++) {
			ans = ans + joiner + array[i];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		//
		// Testing the methods
		//
		System.out.println(selfConcat("echo"));
		System.out.println(nConcat("bye", 5));
		
		String s = "Nice to meet you";
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		
		System.out.println(join(words, " "));
	}

}
