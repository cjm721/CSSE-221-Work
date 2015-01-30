package sll;

/**
 * This class explores a list of algorithms that can be applied to linked lists.
 * 
 * @author defoe. Created Nov 11, 2013.
 * @param <T>
 *            The type of the elements in this Collection.
 */
public class LinkedListAlgorithms<T extends Comparable<T>> {

	/**
	 * 
	 * Doubles the size of the given linked list by adding again all the
	 * elements in the original list, in reverse order. This MUST be done using
	 * recursion in order for you to receive credit for it. You may choose to
	 * use one or more helper methods.
	 * 
	 * @param list
	 *            The linked list to double.
	 */
	public void doubleLinkedListReverse(LinkedList<T> list) {
		doubleLinkedListReverseHelper(list,list.size()-1);
	}
	
	private void doubleLinkedListReverseHelper(LinkedList<T> list, int index){
		if(index < 0 ) 
			return;
		list.add(list.get(index));
		doubleLinkedListReverseHelper(list,index-1);
	}


	/**
	 * 
	 * Merges the nodes of the two given lists into a single list, taking a node
	 * alternately from each list (starting with the first), and return the new
	 * list.
	 * 
	 * So shuffleMerge() with {1, 2, 3} and {7, 13, 1} should yield {1, 7, 2,
	 * 13, 3, 1}. If either list runs out, all the nodes should be taken from
	 * the other list.
	 * 
	 * Note that the original lists should not be modified.
	 * 
	 * @param first
	 *            The first list.
	 * @param second
	 *            The second list.
	 * @return The new list.
	 */
	public LinkedList<T> shuffleMerge(LinkedList<T> first, LinkedList<T> second) {
		LinkedList<T> toReturn = new LinkedList<T>();
		
		int i1 = 0;
		int i2 = 0;
		
		for(int i = 0; i < first.size() + second.size(); i++){
			if((i1<=i2 && i1 < first.size()) || i2 == second.size()){
				toReturn.add(first.get(i1));
				i1++;
			}else if(i2 < second.size()){
				toReturn.add(second.get(i2));
				i2++;
			}
		}

		return toReturn;
	}

}
