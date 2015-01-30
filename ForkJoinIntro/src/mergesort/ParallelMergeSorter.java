package mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * An implementation of merge sort using the Java Fork/Join Framework.
 * 
 * @author Curt Clifton and [TODO: your name(s) here]. Created Jan 10, 2011.
 */
public class ParallelMergeSorter extends RecursiveTask<int[]> {
	// TODO: experiment with varying this value
	/**
	 * Arrays smaller than this length are just sorted using sequential merge
	 * sort.
	 */
	private static final int SEQUENTIAL_THRESHOLD = 500;

	private int[] array;

	/**
	 * Constructs a ParallelMergeSorter for the given array.
	 * 
	 * @param array
	 */
	public ParallelMergeSorter(int[] array) {
		this.array = array;
	}

	@Override
	protected int[] compute() {
		// TODO: implement parallel merge sort here
		return this.array;
	}

	/**
	 * Merges two sorted arrays into the array managed by this merge sorted.
	 * 
	 * @param first
	 *            must be sorted
	 * @param second
	 *            must be sorted
	 */
	private void merge(int[] first, int[] second) {
		int indexFirst = 0; // index to consider next in first array
		int indexSecond = 0; // index to consider next in second array
		int indexToStore = 0; // next open position in this.array to which to
		// store

		// Keep moving the smallest value into the result until we exhaust
		// one of the input arrays.
		while (indexFirst < first.length && indexSecond < second.length) {
			if (first[indexFirst] < second[indexSecond]) {
				this.array[indexToStore] = first[indexFirst];
				indexFirst++;
			} else {
				this.array[indexToStore] = second[indexSecond];
				indexSecond++;
			}
			indexToStore++;
		}

		// One of the two inputs has been exhausted, so only one of the two
		// loops below does any work.
		while (indexFirst < first.length) {
			this.array[indexToStore] = first[indexFirst];
			indexFirst++;
			indexToStore++;
		}

		while (indexSecond < second.length) {
			this.array[indexToStore] = second[indexSecond];
			indexSecond++;
			indexToStore++;
		}

	}

}
