import java.util.Arrays;
import java.util.Scanner;

/**
 * Illustrates the use of an array and the Arrays class. Students will extend
 * this to use an ArrayList and the Collections class.
 * 
 * 
 * @author David Mutchler, created Sep 21, 2008; and modified by Delvin Defoe on
 *         Sep 12, 2012.
 */
public class Main {

	/**
	 * Read integers from standard input and print them in sorted order
	 * (smallest to largest). Do this twice, once using an array and once using
	 * an ArrayList.
	 * 
	 * @param args
	 *            Command-line arguments (unused in this program)
	 */
	public static void main(String[] args) {
		Main.GetSortAndPrintAnArray();
	}

	/*
	 * Read integers from standard input and print them in sorted order
	 * (smallest to largest).
	 */
	private static void GetSortAndPrintAnArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter positive integers, separated by whitespace.");
		System.out.println("Hit ENTER key to terminate input.");

		int expenctedCount = 10;

		int[] numbers = new int[expenctedCount];

		int k;
		String temp = scanner.nextLine();
		String[] tempArray = temp.split("\\s+");

		int countToUse = (tempArray.length > expenctedCount) ? expenctedCount
				: tempArray.length;

		for (k = 0; k < countToUse; k++) {
			try {
				numbers[k] = Integer.parseInt(tempArray[k]);
			} catch (NumberFormatException e) {
				// do nothing
			}
		}
		int numberOfInputs = k;

		Arrays.sort(numbers, 0, numberOfInputs);

		System.out.println("The size of the array is " + numberOfInputs);
		System.out.println("The capacity of the array is " + numbers.length);

		System.out.print("Sorted, they are: ");
		for (int i = 0; i < numberOfInputs; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}
