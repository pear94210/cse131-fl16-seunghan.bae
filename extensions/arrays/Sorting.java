package arrays;
import cse131.ArgsProcessor;

public class Sorting {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("Size of the collection:");
		
		if (N <= 0) {
			System.out.println("Size of the collection should be a positive number");
			N = ap.nextInt("Size of the collection:");
		}
		
		int[] collection = new int[N];
		
		for (int i = 0; i < N; i++) collection[i] = ap.nextInt("Value of array " + i + ": ");
		
		int sortCount = 0;
		
		while (sortCount < collection.length) {
			
			for (int i = sortCount; i < collection.length; i++) {
				int tempMin = collection[i];
				int tempLocation = i;
				
				for (int j = i + 1; j < collection.length; j++) {
					if (collection[j] < tempMin) {
						tempMin = collection[j];
						tempLocation = j;
					}
				}
				
				int temp = collection[i];
				collection[i] = tempMin;
				collection[tempLocation] = temp;
				
			}
			
			sortCount++;
		}
		
		for (int i = 0; i < collection.length; i++) System.out.print(collection[i] + " ");
		
		System.out.println();
		System.out.println();
		
		double mean = 0.0;
		
		for (int i = 0; i < collection.length; i++) mean = mean + collection[i];
		mean = mean / collection.length;
		System.out.println("Mean: " + mean);
		
		System.out.println();
		
		double median = 0.0;
		if (collection.length % 2 == 0) median = (collection[collection.length / 2] + collection[collection.length / 2 - 1]) / 2.0;
		else median = collection[(collection.length - 1) / 2];
		System.out.println("Median: " + median);
		
		System.out.println();
		System.out.println("Min: " + collection[0]);
		System.out.println();
		System.out.println("Max: " + collection[collection.length - 1]);
		System.out.println();
		System.out.println("Range: " + (collection[collection.length - 1] - collection[0]));
		
	}

}
