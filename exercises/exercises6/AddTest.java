package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void test() {
		assertEquals(0, Add.add(0, 0));
		assertEquals(1, Add.add(1, 0));
		assertEquals(3, Add.add(3, 0));
		assertEquals(3, Add.add(2, 1));
		assertEquals(5, Add.add(1, 4));
	}
	
	@Test
	public void negativeTest() {
		assertEquals(-2, Add.addAny(2, -4));
		assertEquals(-10, Add.addAny(-5, -5));
	}

}
