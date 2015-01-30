package sll;

import java.util.NoSuchElementException;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 3e, ch. 15.
 * 
 * @author defoe. Created Nov 7, 2013.
 * @param <T>
 *            The type of elements in the list
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

	private ListNode<T> first;
	private ListNode<T> last;

	/**
	 * Constructs a new, empty linked list.
	 */
	public LinkedList() {
		this.first = null;
		this.last = null;
	}

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode<T> current = this.first;
		while (current != this.last) {
			result += (current.getElement() + ", ");
			current = current.getNext();
		}
		return result + current.getElement() + "]";
	}

	@Override
	public boolean add(T x) {
		// TODO 01 Implement the add(T x) method.
		if (this.first == null) {
			this.first = new ListNode<T>(x);
			this.last = this.first;
		} else {
			this.last.setNext(new ListNode<T>(x));
			this.last = this.last.getNext();
		}
		return true;
	}

	@Override
	public int size() {
		// TODO 02 Implement the size() method.
		return size(this.first);
	}

	private int size(ListNode<T> current) {
		if (current == null) {
			return 0;
		}
		return 1 + size(current.getNext());
	}

	@Override
	public void add(int i, T x) throws IndexOutOfBoundsException {
		// TODO 03 Implement the add(int i, T x) method.
		if (i < 0) {
			throw new IndexOutOfBoundsException("negative index");
		}
		if (i == 0) {
			this.first = new ListNode<T>(x, this.first);
			// Determine whether the list was empty. If that was the case,
			// update last.
			if (this.last == null) {
				this.last = this.first;
			}
			return;
		}
		ListNode<T> p = this.first;
		for (int pos = 1; pos < i; pos++) {
			p = p.getNext();
			if (p == null) {
				throw new IndexOutOfBoundsException("index too big");
			}
		}
		p.setNext(new ListNode<T>(x, p.getNext()));
		// Determine whether p was the last node. If this is the case, update
		// last.
		if (this.last == p) {
			this.last = p.getNext();
		}
	}

	@Override
	public boolean contains(T x) {
		// TODO 04 Implement the contains(T x) method.
		return contains(x, this.first);
	}

	private boolean contains(T x, ListNode<T> current) {
		if (current == null)
			return false;
		if (current.getElement().equals(x))
			return true;
		return contains(x, current.getNext());
	}

	@Override
	public boolean remove(T x) {
		// TODO 05 Implement the remove(T x) method.
		ListNode<T> current = this.first;
		if (current == null) {
			return false;
		}
		if (x.equals(current.getElement())) {
			this.first = current.getNext();
			return true;
		}
		return remove(x, current);
	}

	private boolean remove(T x, ListNode<T> current) {
		if (current.getNext() == null) {
			return false;
		}
		if (x.equals(current.getNext().getElement())) {
			current.setNext(current.getNext().getNext());
			return true;
		} else
			return remove(x, current.getNext());
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO 06 Implement the get(int index) method.
		if (index < 0) {
			throw new IndexOutOfBoundsException("negative index");
		}
		try {
			return get(index, this.first, 0);
		} catch (NullPointerException e) {
			throw new IndexOutOfBoundsException(
					"tried to get element beyond size of list.");
		}
	}

	private T get(int index, ListNode<T> current, int nodeCount) {
		if (index == nodeCount) {
			return current.getElement();
		}
		return get(index, current.getNext(), nodeCount + 1);
	}

	@Override
	public int indexOf(T x) {
		// TODO 07 Implement the indexOf(T x) method.
		return indexOf(x, this.first, 0);
	}

	private int indexOf(T x, ListNode<T> current, int nodeCount) {
		if (current == null) {
			return -1;
		}
		if (current.getElement().equals(x)) {
			return nodeCount;
		}
		return indexOf(x, current.getNext(), nodeCount + 1);
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		// TODO 08 Implement the set(int index, T element) method.
		if (index < 0) {
			throw new IndexOutOfBoundsException("negative index: " + index);
		}
		return set(index, element, this.first);
	}

	private T set(int index, T x, ListNode<T> current) {
		if (current == null) {
			throw new IndexOutOfBoundsException("Index is beyond end of list");
		}
		if (index == 0) {
			T result = current.getElement();
			current.setElement(x);
			return result;
		}
		return set(index - 1, x, current.getNext());
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * This is an iterator over this list.
	 * 
	 * @author defoe. Created Nov 7, 2013.
	 */
	private class LinkedListIterator implements Iterator<T> {

		private ListNode<T> current, previous;

		private LinkedListIterator() {
			this.current = null;
			this.previous = null;
		}

		@Override
		public boolean hasNext() {
			// TODO 09 Implement the hasNext() method.
			if (this.current == null) {
				return LinkedList.this.first != null;
			}
			return this.current.getNext() != null;
		}

		@Override
		public T next() throws NoSuchElementException {
			// TODO 10 Implement the next() method.
			if (!hasNext()) {
				throw new NoSuchElementException("There is no next element. "
						+ "You should only call an iterotor's next() "
						+ "method after a call to hasNext() returns true.");
			}
			if (this.current == null) {
				this.current = LinkedList.this.first;
			} else {
				this.previous = this.current;
				this.current = this.current.getNext();
			}
			return this.current.getElement();
		}

		@Override
		public void remove() {
			// TODO 11 Implement the remove() method.
			if (this.previous == this.current) {
				// Have already removed last visited element
				throw new IllegalStateException(
						"You can only call an iterator's remove() "
								+ "method after a call to next()");
			}
			if (this.current.equals(LinkedList.this.first)) {
				// Remove the first element of the list
				LinkedList.this.first = LinkedList.this.first.getNext();
			} else {
				this.previous.setNext(this.current.getNext());
			}
			this.current = this.previous;
		}
	}

}
