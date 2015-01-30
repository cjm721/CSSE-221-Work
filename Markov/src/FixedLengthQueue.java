
/**
 * This class (partially) implements a fixed length queue of objects.
 * 
 * @author Curt Clifton Created Nov 28, 2007.
 */
public class FixedLengthQueue {
	private Object[] elements;

	private int insertIndex;

	private int size;

	/**
	 * Constructs a fixed length queue of the given capacity.
	 * 
	 * @param capacity
	 */
	// @ requires capacity >= 1;
	public FixedLengthQueue(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be positive.");
		}
		this.elements = new Object[capacity];
		this.insertIndex = 0;
		this.size = 0;
	}

	/**
	 * Adds the given object to this queue.
	 * 
	 * @param newObject
	 */
	public void add(Object newObject) {
		this.elements[this.insertIndex] = newObject;
		this.insertIndex++;
		this.insertIndex %= this.elements.length;
		if (this.size < this.elements.length) {
			this.size++;
		}
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		if (this.size == 0) {
			return "";
		}
		for (int i = this.size; i > 0; i--) {
			int index = (this.insertIndex - i + this.elements.length)
								% this.elements.length;
			result.append(this.elements[index]);
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}
}
