import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author millerc5.
 *         Created Sep 11, 2013.
 */
public class BigRationalTest {

	/**
	 * Test method for {@link BigRational#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("1/2",new BigRational("1","2").toString());
		assertEquals("0/2",new BigRational("0","2").toString());
		assertEquals("1000/2000",new BigRational("1000","2000").toString());
	}

	/**
	 * Test method for {@link BigRational#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(true,new BigRational("1","1").equals(new BigRational("1","1")));
		assertEquals(false,new BigRational("2","1").equals(new BigRational("1","1")));
		assertEquals(true,new BigRational("-1 ","1").equals(new BigRational("-1","1")));
		assertEquals(true,new BigRational("-1 ","1").equals(new BigRational("-1","1")));
	}

	/**
	 * Test method for {@link BigRational#compareTo(BigRational)}.
	 */
	@Test
	public void testCompareTo() {
		assertEquals(0,new BigRational("1","1").compareTo(new BigRational("1","1")));
		assertEquals(1,new BigRational("10","1").compareTo(new BigRational("1","1")));
		assertEquals(-1,new BigRational("-1","1").compareTo(new BigRational("1","1")));
		assertEquals(0,new BigRational("1","1").compareTo(new BigRational("1","1")));
		assertEquals(0,new BigRational("0","0").compareTo(new BigRational("0","0")));
		assertEquals(1,new BigRational("100","0").compareTo(new BigRational("1","1")));
	}

	/**
	 * Test method for {@link BigRational#abs()}.
	 */
	@Test
	public void testAbs() {
		assertEquals(new BigRational("1","1"), new BigRational("-1","1").abs());
		assertEquals(new BigRational("1","1"), new BigRational("1","1").abs());
		assertEquals(new BigRational("1000","1000"), new BigRational("-1000","1000").abs());
	}

	/**
	 * Test method for {@link BigRational#negate()}.
	 */
	@Test
	public void testNegate() {
		assertEquals(new BigRational("-1","1"), new BigRational("1","1").negate());
		assertEquals(new BigRational("-1","1"), new BigRational("1","1").negate());
		assertEquals(new BigRational("-1000","1000"), new BigRational("1000","1000").negate());
	}

	/**
	 * Test method for {@link BigRational#add(BigRational)}.
	 */
	@Test
	public void testAdd() {
		assertEquals(new BigRational("1","1"), new BigRational("0","0").add(new BigRational("1","1")));
		assertEquals(new BigRational("0","0"), new BigRational("-1","-1").add(new BigRational("1","1")));
		assertEquals(new BigRational("0","0"), new BigRational("0","0").add(new BigRational("0","0")));
	}

	/**
	 * Test method for {@link BigRational#subtract(BigRational)}.
	 */
	@Test
	public void testSubtract() {
		assertEquals(new BigRational("-1","-1"), new BigRational("0","0").subtract(new BigRational("1","1")));
		assertEquals(new BigRational("-2","-2"), new BigRational("-1","-1").subtract(new BigRational("1","1")));
		assertEquals(new BigRational("0","0"), new BigRational("0","0").subtract(new BigRational("0","0")));
	}

	/**
	 * Test method for {@link BigRational#divide(BigRational)}.
	 */
	@Test
	public void testDivide() {
		assertEquals(new BigRational("10","1"), new BigRational("10","10").divide(new BigRational("1","1")));
		assertEquals(new BigRational("-1","-1"), new BigRational("-1","-1").divide(new BigRational("1","1")));
		assertEquals(new BigRational("0","1"), new BigRational("0","0").divide(new BigRational("0","0")));
	}

	/**
	 * Test method for {@link BigRational#multiply(BigRational)}.
	 */
	@Test
	public void testMultiply() {
		assertEquals(new BigRational("1","1"), new BigRational("10","10").multiply(new BigRational("1","1")));
		assertEquals(new BigRational("-1","-1"), new BigRational("-1","-1").multiply(new BigRational("1","1")));
		assertEquals(new BigRational("0","1"), new BigRational("0","0").multiply(new BigRational("0","0")));
	}

}
