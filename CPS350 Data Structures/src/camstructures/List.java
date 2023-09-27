package camstructures;

/**
 * memory of an array
 * 	elements are allocated in continuous spaces of ram
 *  each element is 4 bytes
 *  array references the first 
 * 
 * memory of linked list
 * 	elements can be anywhere in ram
 * 	4 bytes for next reference and 4 for value of each node
 * 
 * quicksort and selection sort are not viable for linked list
 * 	however, mergeSort works well as there are not many swaps
 */

public class List {
	//dummy element/head references the first node
	
	Node head;
	Node tail;
	
	public List() {
		head = new Node(-1);
	}
	
	public List(Node first) {
		head = new Node(-1, first);
	}
	
	public List(List list) {
		Node iter = list.head;
		//write this method
	}
	
	boolean outOfBounds(int index) {
		Node start = head;
		return false;
	}
	
	void MergeSort() {
		Node mid = getMiddle();
		List left = this;
		List right = new List(mid.next);
		mid.next = null;
	}
	
	List merge(List a, List b) {
		List c = new List();
		Node iter1 = a.head;
		Node iter2 = b.head;
		Node iter3 = c.head;
		while (iter1.next != null && iter2.next != null && iter3.next != null) {
			if (iter1.value <= iter2.value) {
				Node temp = new Node(iter1.value,iter1.next);
				iter3.next = temp;
				iter1 = iter1.next;
			} else {
				
			}
			iter3 = iter3.next;
		}
		
		return null; //write rest of method
	}
	
	/**
	 * fast node updates at twice the speed of slow node
	 * 	therefore when fast is at the end, slow will be directly at the middle
	 * 
	 * @return the node that is directly in the middle 
	 */
	Node getMiddle() {
		Node slow = head; Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	//O(n) time complexity
	//swap in array is O(1)
	void SwapNodes(int index1, int index2) {
		Node prev1 = head; Node iter1 = head;
		for (int i = 0; i < index1; i++) {
			prev1 = prev1.next;
			iter1 = prev1.next;
		}
		Node prev2 = head; Node iter2 = head;
		for (int i = 0; i < index2; i++) {
			prev2 = prev2.next;
			iter2 = prev2.next;
		}
		
		Node temp = iter1.next;
		prev1.next = iter2;
		prev2.next = iter1;
		iter1.next = iter2.next;
		iter2.next = temp;
	}
	
	void delete(int index) {
		//write this method
		//for (int i = 0; i < index; )
	}
	
	void append(int value) {
		Node curr = new Node(value);
		tail.next = curr;
		tail = curr;
	}
	
	boolean insert(int value, int index) { //time complexity O(n) - array insert time complexity O(n)
		Node iter = head;
		for (int i = 0; i < index; i++) {
			if (iter.next == null)
				return false;
			iter = iter.next;
		}
		Node temp = new Node(value, iter.next);
		iter.next = temp;
		return true;
	}
	
	void print() {
		Node copy = new Node(head);
		copy = copy.next;
		while (copy.next != null) {
			System.out.println(copy.value);
			copy = copy.next;
		}
	}
	
	
}
