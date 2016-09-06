package exercises2;

public class RandomAverages {

	public static void main(String[] args) {
		//
		// Write a loop that computes the average
		//     of 1, 2, ... 1000 doubles
		// In each iteration of that loop, print
		//     the average of the doubles generated
		//     thus far.
		//
		// Your code goes below here.
		int count = 1;
		double randNum = 0;
		
		while (count <= 1000) {
			randNum = randNum + Math.random();
			
			if (count % 100 == 0) System.out.println("Average of " + count + " random number(s) is " + (randNum / count));
			
			count = count + 1;
		}
		//
		//  Some questions:
		//    1) How does the average change as your loop progresses?
		//    2) Can you write code in your loop that prints out the average only
		//         every 100 iterations, instead of each iteration?
		//    
		//    1) It approaches to 0.5
		//    2) Shown above		
	}

}
