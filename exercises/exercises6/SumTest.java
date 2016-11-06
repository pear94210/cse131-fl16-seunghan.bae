package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumTest {

	@Test
	public void test() {
		assertEquals(0, Sum.sum(0));
		assertEquals(1, Sum.sum(1));
		assertEquals(3, Sum.sum(2));
		assertEquals(6, Sum.sum(3));
		assertEquals(10, Sum.sum(4));
	}

}
