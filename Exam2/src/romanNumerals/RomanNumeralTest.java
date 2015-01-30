package romanNumerals;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests the methods of the {@link RomanNumeral} class.
 * 
 * @author defoe. Created Oct 17, 2013.
 */
public class RomanNumeralTest {
	
	private static RomanNumeral roman;
	
	
	private static int points = 0;
	
	/**
	 * Creates a {@link RomanNumeral} object before running each test.
	 *
	 */
	@BeforeClass
	public static void setUP(){
		RomanNumeralTest.roman = new RomanNumeral();	
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value one.
	 *
	 */
	@Test
	public void testValueOne(){
		assertEquals("I", RomanNumeralTest.roman.intToRomanNumeral(1));	
		RomanNumeralTest.points++;
	}

	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than four.
	 *
	 */
	@Test
	public void testValuesLessThanFour() {
		assertEquals("II", RomanNumeralTest.roman.intToRomanNumeral(2));
		assertEquals("III", RomanNumeralTest.roman.intToRomanNumeral(3));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value four.
	 *
	 */
	@Test
	public void testValueFour(){
		assertEquals("IV", RomanNumeralTest.roman.intToRomanNumeral(4));	
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value five.
	 *
	 */
	@Test
	public void testValueFive(){
		assertEquals("V", RomanNumeralTest.roman.intToRomanNumeral(5));	
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than nine.
	 *
	 */
	@Test
	public void testValuesLessThanNine() {
		assertEquals("VI", RomanNumeralTest.roman.intToRomanNumeral(6));
		assertEquals("VIII", RomanNumeralTest.roman.intToRomanNumeral(8));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value nine.
	 *
	 */
	@Test
	public void testValueNine(){
		assertEquals("IX", RomanNumeralTest.roman.intToRomanNumeral(9));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value ten.
	 *
	 */
	@Test
	public void testValueTen(){
		assertEquals("X", RomanNumeralTest.roman.intToRomanNumeral(10));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than twenty.
	 *
	 */
	@Test
	public void testValuesLessThanTwenty() {
		assertEquals("XI", RomanNumeralTest.roman.intToRomanNumeral(11));
		assertEquals("XIII", RomanNumeralTest.roman.intToRomanNumeral(13));
		assertEquals("XIV", RomanNumeralTest.roman.intToRomanNumeral(14));
		assertEquals("XV", RomanNumeralTest.roman.intToRomanNumeral(15));
		assertEquals("XVI", RomanNumeralTest.roman.intToRomanNumeral(16));
		RomanNumeralTest.points++;
	}	
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than forty.
	 *
	 */
	@Test
	public void testValuesLessThanForty() {
		assertEquals("XX", RomanNumeralTest.roman.intToRomanNumeral(20));	
		assertEquals("XXIII", RomanNumeralTest.roman.intToRomanNumeral(23));	
		assertEquals("XXX", RomanNumeralTest.roman.intToRomanNumeral(30));	
		assertEquals("XXXVII", RomanNumeralTest.roman.intToRomanNumeral(37));	
		RomanNumeralTest.points++;
	}	
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value forty.
	 *
	 */
	@Test
	public void testValueForty(){
		assertEquals("XL", RomanNumeralTest.roman.intToRomanNumeral(40));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than fifty.
	 *
	 */
	@Test
	public void testValuesLessThanFifty() {
		assertEquals("XLIV", RomanNumeralTest.roman.intToRomanNumeral(44));
		assertEquals("XLV", RomanNumeralTest.roman.intToRomanNumeral(45));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value fifty.
	 *
	 */
	@Test
	public void testValueFifty(){
		assertEquals("L", RomanNumeralTest.roman.intToRomanNumeral(50));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than ninety.
	 *
	 */
	@Test
	public void testValuesLessThanNinety() {
		assertEquals("LXX", RomanNumeralTest.roman.intToRomanNumeral(70));
		assertEquals("LXXXVI", RomanNumeralTest.roman.intToRomanNumeral(86));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value ninety.
	 *
	 */
	@Test
	public void testValueNinety(){
		assertEquals("XC", RomanNumeralTest.roman.intToRomanNumeral(90));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value one hundred.
	 *
	 */
	@Test
	public void testValueHundred(){
		assertEquals("C", RomanNumeralTest.roman.intToRomanNumeral(100));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than five hundred.
	 *
	 */
	@Test
	public void testValuesLessThanFiveHundred() {
		assertEquals("CD", RomanNumeralTest.roman.intToRomanNumeral(400));
		assertEquals("CCCLXXXIV", RomanNumeralTest.roman.intToRomanNumeral(384));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value five hundred.
	 *
	 */
	@Test
	public void testValueFiveHundred(){
		assertEquals("D", RomanNumeralTest.roman.intToRomanNumeral(500));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than one thousand.
	 *
	 */
	@Test
	public void testValueLessThanOneThousand(){
		assertEquals("CM", RomanNumeralTest.roman.intToRomanNumeral(900));
		assertEquals("DCLXXII", RomanNumeralTest.roman.intToRomanNumeral(672));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for the value one thousand.
	 *
	 */
	@Test
	public void testValueThousand(){
		assertEquals("M", RomanNumeralTest.roman.intToRomanNumeral(1000));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Tests the {@link RomanNumeral#intToRomanNumeral(int)} method for values less than four thousand.
	 *
	 */
	@Test
	public void testValueLessThanFourThousand(){
		assertEquals("MMXXV", RomanNumeralTest.roman.intToRomanNumeral(2025));
		assertEquals("MMMCMXCIX", RomanNumeralTest.roman.intToRomanNumeral(3999));
		RomanNumeralTest.points++;
	}
	
	/**
	 * Displays the total points for completing the implementation of the {@link RomanNumeral#intToRomanNumeral(int)} method.
	 *
	 */
	@AfterClass
	public static void printPoints(){
		System.out.println("Your total points is " + RomanNumeralTest.points + " out of a maximum 20 points.");
	}
	

}
