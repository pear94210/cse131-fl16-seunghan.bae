package studio4;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sedgewick.*;

public class Flag {

	
	public static void main(String[] args) throws FileNotFoundException {
		//
		//  Add code for your studio below here.
		//
		StdDraw.rectangle(0.5, 0.5, 0.5, 0.3125);
		
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.05);
		//StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(0.5, 0.5, 0.05, 0.3125);
		
		//StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0.225, 0.31875, 0.05, 0.015);
		StdDraw.filledRectangle(0.225, 0.31875, 0.015, 0.05);
		
		StdDraw.filledRectangle(0.225, 0.68125, 0.05, 0.015);
		StdDraw.filledRectangle(0.225, 0.68125, 0.015, 0.05);
		
		StdDraw.filledRectangle(0.775, 0.31875, 0.05, 0.015);
		StdDraw.filledRectangle(0.775, 0.31875, 0.015, 0.05);
		
		StdDraw.filledRectangle(0.775, 0.68125, 0.05, 0.015);
		StdDraw.filledRectangle(0.775, 0.68125, 0.015, 0.05);
		
		StdDraw.picture(0.5, 0.5, "images/georgia.png", 0.1, 0.1);
		
        StdDraw.setPenColor(Color.BLACK);
        //StdDraw.setFont()
		StdDraw.pause(500);
		StdDraw.text(0.167, 0.7, "Georgia");
		StdDraw.pause(500);
		StdDraw.text(0.333, 0.6, "Georgia");
		StdDraw.pause(500);
		StdDraw.text(0.5, 0.5, "Georgia");
		StdDraw.pause(500);
		StdDraw.text(0.667, 0.4, "Georgia");
		StdDraw.pause(500);
		StdDraw.text(0.833, 0.3, "Georgia");
		
		System.setIn(new FileInputStream("music/calling.txt"));

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
                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }

            // play it using standard audio
            StdAudio.play(a);
        }

	}

}
