package instrument;
import cse131.ArgsProcessor;
import sedgewick.*;
/*************************************************************************
 *  Compilation:  javac PlayThatTune.java
 *  Execution:    java PlayThatTune < input.txt
 *  Dependencies: StdAudio.java StdAudio.java
 *
 *  This is a data-driven program that plays pure tones from
 *  the notes on the chromatic scale, specified on standard input
 *  by their distance from concert A.
 *
 *  % java PlayThatTune < elise.txt
 *
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/99luftballons.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt 
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *
 *************************************************************************/

public class PlayThatTune {

    public static void main(String[] args) {
    	
    	ArgsProcessor ap = new ArgsProcessor(args);
    	
    	int M = ap.nextInt("How many frequency factors?");
    	
    	int[] numerator = new int[M];
    	int[] denominator = new int[M];
    	double[] strength = new double[M];
    	
    	for (int i = 0; i < M; i++) {
    		numerator[i] = ap.nextInt("Numerator for frequency factor " + (i + 1));
    		denominator[i] = ap.nextInt("Denominator for frequency factor " + (i + 1));
    		strength[i] = ap.nextDouble("Relative strength for frequency factor " + (i + 1));
    	}
    	
    	ArgsProcessor.useStdInput("music");

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();

            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int N = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[N+1];
            for (int i = 0; i <= N; i++) {
            	a[i] = 0;
            	
                for (int j = 0; j < M; j++) {
                	a[i] = a[i] + strength[j] * (Math.sin(2 * Math.PI * i * (1.0 * numerator[j] / denominator[j]) * hz / StdAudio.SAMPLE_RATE));
                }
            }
            
            /*StdDraw.setXscale(0.0, 2.0);
            StdDraw.setYscale(-1.0, 1.0);
            
            for (int i = 0; i <= N; i++) {
            	StdDraw.filledCircle(ball[0][k], ball[1][k], 0.05);
            }*/

            // play it using standard audio
            StdAudio.play(a);
        }
    }
}
