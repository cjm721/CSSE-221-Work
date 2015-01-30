package useless;

import java.util.concurrent.RecursiveTask;

/**
 * Recursive task to add one to itself, from Dan Grossman's "useless example".
 */
public class Incrementor extends RecursiveTask<Integer> {
	private int originalNumber;
	
	/**
	 * Constructs a new Incrementor that adds one to the given number.
	 *
	 * @param number
	 */
	public Incrementor(int number) {
		this.originalNumber = number;
	}
	
	@Override
	protected Integer compute() {
		// TODO: this is wrong, fix it:
		return this.originalNumber;
	}

}
