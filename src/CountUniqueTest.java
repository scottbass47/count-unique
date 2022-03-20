import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountUniqueTest {

	@Test
	void countMaxLenZeroIsZero() {
		char[] alphabet = new char[] { 'a', 'b' };
		CountUnique cu = new CountUnique(alphabet, 0, 0);
		
		assertEquals(0, cu.count());
	}

	@Test
	void countMaxLenOneIsZero() {
		char[] alphabet = new char[] { 'a', 'b' };
		CountUnique cu = new CountUnique(alphabet, 0, 1);
		
		assertEquals(0, cu.count());
	}

	@Test
	void countMaxLenTwoDiffStartAndEndIsOne() {
		char[] alphabet = new char[] { 'a', 'b' };
		CountUnique cu = new CountUnique(alphabet, 1, 2);
		
		assertEquals(1, cu.count());
	}

	@Test
	void countMaxLenTwoSameStartAndEndIsZero() {
		char[] alphabet = new char[] { 'a', 'b' };
		CountUnique cu = new CountUnique(alphabet, 0, 2);
		
		assertEquals(0, cu.count());
	}

	@Test
	void countExampleOne() {
		char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e' };
		CountUnique cu = new CountUnique(alphabet, 1, 4);
		
		assertEquals(17, cu.count());
	}

	@Test
	void countExampleTwo() {
		char[] alphabet = new char[] { 'a', 'b', 'c' };
		CountUnique cu = new CountUnique(alphabet, 1, 6);
		
		assertEquals(21, cu.count());
	}

	@Test
	void countExampleThree() {
		char[] alphabet = "abcdefghij".toCharArray();
		CountUnique cu = new CountUnique(alphabet, 3, 9);
		
		assertEquals(4842756, cu.count());
	}

}
