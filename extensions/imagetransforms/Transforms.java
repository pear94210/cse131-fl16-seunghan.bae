package imagetransforms;

import java.awt.Color;

import sedgewick.Picture;


public class Transforms {
	
	/**
	 * This one is solved for you.
	 * @param source
	 * @param target
	 */
	public static void flipHoriz(Picture source, Picture target) { 
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				int otherX = source.width() - 1 - x;  // otherX is the mirror of x
				Color c = source.get(otherX, y);      // get the Color at the mirror point of the source
				target.set(x, y, c);                  // and set it at x,y in the target
			}
		}
	}
	
	public static void flipVert(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				int otherY = source.height() - 1 - y;
				Color c = source.get(x, otherY);
				target.set(x, y, c);
			}
		}
	}
	
	
	public static void flipHorizLeftHalf(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				if (x > (source.width() / 2)) {
					int otherX = source.width() - 1 - x;
					Color c = source.get(otherX, y);
					target.set(x, y, c);
				}
				else target.set(x, y, source.get(x, y));
			}
		}
	}
	
	public static void flipVertBotHalf(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				if (y > (source.height() / 2)) {
					int otherY = source.height() - 1 - y;
					Color c = source.get(x, otherY);
					target.set(x, y, c);
				}
				else target.set(x, y, source.get(x, y));
			}
		}
	}
	
	public static void gradient(Picture target) {
		for (int x = 0; x < target.width(); x++) {
			for (int y = 0; y < target.height(); y++) {
				int amountRed = (int) (255.0 * x / target.width());
				int amountGreen = (int) (255.0 * y/ target.height());
				target.set(x, y, new Color(amountRed, amountGreen, 128));
			}
		}		
	}
	
	public static void edgeDetect(Picture source, Picture target) {
		// FIXME
	}
	
	public static void digitalFilter(Picture source, Picture target) {
		// FIXME	
	}



}
