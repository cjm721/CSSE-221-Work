import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests FixedLengthQueue
 * 
 * @author Curt Clifton
 */
public class FixedLengthQueueTest {

	/**
	 * Tests {@link FixedLengthQueue#add(Object)}
	 * 
	 */
	@Test
	public void testAdd3() {
		FixedLengthQueue q3 = new FixedLengthQueue(3);
		String testString = "I heard it through the grapevine.";
		String[] splitString = testString.split(" ");

		q3.add(splitString[0]);
		assertEquals("I", q3.toString());

		q3.add(splitString[1]);
		assertEquals("I heard", q3.toString());

		q3.add(splitString[2]);
		assertEquals("I heard it", q3.toString());

		q3.add(splitString[3]);
		assertEquals("heard it through", q3.toString());

		q3.add(splitString[4]);
		assertEquals("it through the", q3.toString());

		q3.add(splitString[5]);
		assertEquals("through the grapevine.", q3.toString());
	}

	/**
	 * Tests {@link FixedLengthQueue#add(Object)}
	 * 
	 */
	@Test
	public void testAdd4() {
		FixedLengthQueue q4 = new FixedLengthQueue(4);
		String testString = "I saw her again last night.";
		// Trivia question: Name the four people who sang that 1960's hit song.
		String[] splitString = testString.split(" ");

		q4.add(splitString[0]);
		assertEquals("I", q4.toString());

		q4.add(splitString[1]);
		assertEquals("I saw", q4.toString());

		q4.add(splitString[2]);
		assertEquals("I saw her", q4.toString());

		q4.add(splitString[3]);
		assertEquals("I saw her again", q4.toString());

		q4.add(splitString[4]);
		assertEquals("saw her again last", q4.toString());

		q4.add(splitString[5]);
		assertEquals("her again last night.", q4.toString());
	}

	/**
	 * Tests {@link FixedLengthQueue#add(Object)}
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAdd0() {
		FixedLengthQueue q0 = new FixedLengthQueue(0);
	}
}
