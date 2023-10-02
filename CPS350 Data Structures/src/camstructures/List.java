package camstructures;

/**
 * memory of an array elements are allocated in continuous spaces of ram each
 * element is 4 bytes array references the first
 * 
 * memory of linked list elements can be anywhere in ram 4 bytes for next
 * reference and 4 for value of each node
 * 
 * quicksort and selection sort are not viable for linked list however,
 * mergeSort works well as there are not many swaps
 */

public class List {
	// dummy element/head references the first node

	Node head;
	Node tail;

	public List() {
		head = new Node(-1);
		tail = head;
	}

	public List(Node first) {
		head = new Node(-1, first);
		tail = head;
	}

	public List(List list) {
		Node iter = list.head;
		// write this method
	}

	// in place merging
	// have a new list 'c'
	// have first node point to smallest between the two
	// .next will point to the next smaller node
	// O(1) space complexity
	List merge(List a, List b) {
		List c = new List();
		Node iter = c.head;
		// have pointers a and b that point to first node in each list
		// move the heads

		// if head a is null point to rest of b and vice versa

		return c;
	}

	void insertionSort() {
		// start at head.next
		// depending on where this pointer

		// 4> 1> 5> 2>
	}

	void MergeSort1() {
		Node mid = getMiddle();
		List left = this;
		List right = new List(mid.next);
		mid.next = null;
	}

	List merge1(List a, List b) {
		List c = new List();
		Node iter1 = a.head;
		Node iter2 = b.head;
		Node iter3 = c.head;
		while (iter1.next != null && iter2.next != null && iter3.next != null) {
			if (iter1.value <= iter2.value) {
				Node temp = new Node(iter1.value, iter1.next);
				iter3.next = temp;
				iter1 = iter1.next;
			} else {

			}
			iter3 = iter3.next;
		}

		return null; // write rest of method
	}

	/**
	 * fast node updates at twice the speed of slow node therefore when fast is at
	 * the end, slow will be directly at the middle
	 * 
	 * @return the node that is directly in the middle
	 */
	Node getMiddle() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	// O(n) time complexity
	// swap in array is O(1)
	void SwapNodes(int index1, int index2) {
		Node prev1; Node prev2;
		prev1 = prev2 = head;
		Node curr1; Node curr2;
		curr1 = curr2 = head.next;
		//while (int i < 0; i < index1)
		
	}

	void delete(int index) {
		// write this method
		// for (int i = 0; i < index; )
	}

	void append(int value) {
		Node curr = new Node(value);
		tail.next = curr;
		tail = curr;
	}

	boolean insert(int value, int index) { // time complexity O(n) - array insert time complexity O(n)
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
		Node iter = new Node(head.next);
		while (iter != null) {
			System.out.print(iter.value + " > ");
			iter = iter.next;
		}
		System.out.println();
			
	}
}
