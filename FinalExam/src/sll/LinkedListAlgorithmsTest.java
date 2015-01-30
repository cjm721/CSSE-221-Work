package sll;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a collection of test cases for the {@link LinkedListAlgorithms} class
 * 
 * @author defoe. Created Nov 12, 2013.
 */
public class LinkedListAlgorithmsTest {

	private LinkedListAlgorithms<Integer> alg;
	private LinkedList<Integer> list1;
	private LinkedList<Integer> list2;
	private static int DLLRpoints = 0;
	private static int SMRpoints = 0;

	/**
	 * Creates a {@link LinkedListAlgorithms} object and a few
	 * {@link LinkedList} objects.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.alg = new LinkedListAlgorithms<Integer>();
		this.list1 = new LinkedList<Integer>();
		this.list2 = new LinkedList<Integer>();
	}
	
	/**
	 * Tests the {@link LinkedListAlgorithms#doubleLinkedListReverse(LinkedList)} method.
	 *
	 */
	@Test
	public void testDoubleLinkedListReverse(){
		this.alg.doubleLinkedListReverse(this.list1);
		assertEquals("[]", this.list1.toString());
		DLLRpoints += 3;
		
		this.list1.add(3);
		this.alg.doubleLinkedListReverse(this.list1);
		assertEquals("[3, 3]", this.list1.toString());
		DLLRpoints += 4;
		
		this.list1.remove(3);
		this.list1.add(10);
		this.alg.doubleLinkedListReverse(this.list1);
		assertEquals("[3, 10, 10, 3]", this.list1.toString());
		DLLRpoints += 4;

		this.list1.add(7);
		this.alg.doubleLinkedListReverse(this.list1);
		assertEquals("[3, 10, 10, 3, 7, 7, 3, 10, 10, 3]", this.list1.toString());
		DLLRpoints += 4;
	}
	
	/**
	 * Tests the {@link LinkedListAlgorithms#shuffleMerge(LinkedList, LinkedList)} method.
	 *
	 */
	@Test
	public void testShuffleMerge(){
		LinkedList<Integer> result = this.alg.shuffleMerge(this.list1, this.list2);
		
		assertEquals("[]", result.toString());
		SMRpoints += 3;
		
		this.list1.add(3);
		result = this.alg.shuffleMerge(this.list1, this.list2);
		assertEquals("[3]", result.toString());
		SMRpoints += 2;
		assertEquals("[3]", this.list1.toString());
		SMRpoints++;
		assertEquals("[]", this.list2.toString());
		SMRpoints++;
		
		this.list2.add(10);
		this.list2.add(15);
		result = this.alg.shuffleMerge(this.list1, this.list2);
		assertEquals("[3, 10, 15]", result.toString());
		SMRpoints += 2;
		assertEquals("[3]", this.list1.toString());
		SMRpoints++;
		assertEquals("[10, 15]", this.list2.toString());
		SMRpoints++;

		this.list1.add(12);
		this.list1.add(17);
		this.list1.add(20);
		this.list1.add(1);
		result = this.alg.shuffleMerge(this.list1, this.list2);
		assertEquals("[3, 10, 12, 15, 17, 20, 1]", result.toString());
		SMRpoints += 2;
		assertEquals("[3, 12, 17, 20, 1]", this.list1.toString());
		SMRpoints++;
		assertEquals("[10, 15]", this.list2.toString());
		SMRpoints++;

	}
	
	/**
	 * Displays the total points for completing the implementation of the {@link RomanNumeral#intToRomanNumeral(int)} method.
	 *
	 */
	@AfterClass
	public static void printPoints(){
		System.out.println("Your total points for doubleLinkedListReverse is " + DLLRpoints);
		System.out.println("Your total points for shuffleMerge is " + SMRpoints );
	}
	
}
