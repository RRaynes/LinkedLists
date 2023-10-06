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

	public List() {
		head = new Node(-1);
	}

	public List(Node first) {
		head = new Node(-1, first);
	}

	public List(List list) {
		this();
		Node iter = list.head.next;
		while (iter != null) {
			this.append(iter.value);
			iter = iter.next;
		}
	}

	void mergeSort() {
		Node sorted = mergeSort(head.next);
		head.next = sorted;
	}

	/**
	 * 
	 * @param l left half of LL w left head (nondummy) as param
	 * @param r '' but for right half
	 * @return Node of sorted section to return up the recursive stack
	 */
	Node mergeSort(Node start) {
		if (start.next == null)
			return start;
		Node middle = getMiddle(start); // gets middle node within the LL
		Node rightNode = middle.next; // saves reference of its next node
		middle.next = null; // deletes reference of middle to seperate to two lists
		// now we merge each section of the LL
		Node left = mergeSort(start); // head is the left side of the LL
		Node right = mergeSort(rightNode);
//		List h = new List(left);
//		List h1 = new List(right);
//		h.print();
//		h1.print();
		return merge(left, right);
	}

	// in place merging
	// recursively calls itself to add to the list
	// both lists the nodes are comprised of must be sorted
	Node merge(Node a, Node b) {
		Node res = null;
		// base cases
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.value <= b.value) { // if value of a less= then b, then we return
			res = a;
			res.next = merge(a.next, b);
		} else {
			res = b;
			res.next = merge(a, b.next);
		}
		List dummyL = new List(res);
		dummyL.print(true);
		return res;
	}

	/**
	 * fast node updates at twice the speed of slow node therefore when fast is at
	 * the end, slow will be directly at the middle
	 * 
	 * @return the node that is directly in the middle
	 */
	Node getMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	void insertionSort() {
		Node res = new Node(-1);

		head = head.next; // we start at head.next, this is the current value we are evaluating
		while (head != null) { // we continue to iterate the head value at the end of the while loop, this also
								// deletes references to save memory
			Node curr = res;
			while (curr.next != null && head.value > curr.next.value) {
				curr = curr.next;
			} // finds the place to insert a new node at in res list
			Node temp = curr.next; // saves value of next node in the case we arent inserting at the end
			curr.next = new Node(head.value);
			curr.next.next = temp;
			
			head = head.next; // deletion of previous references and updates head
		}
		head = res; // now the current linked list is empty, but res list is not. to prevent this we
							// change heads reference to res.head
	}

	void insertionSortWithDebug() {
		List res = new List();

		head = head.next;
		while (head != null) {
			Node curr = res.head;
			if (curr.next != null)
				// System.out.println("curr.next " + curr.next.value + head.value + " " +
				// (head.value > curr.next.value));
				while (curr.next != null && head.value > curr.next.value) {
					// System.out.println("\titerating curr");
					curr = curr.next;
				}
			// System.out.println("inserting at " + curr.value);
			// find we are inserting
			Node temp = curr.next;
			// System.out.println("debug + " + head.value);
			// System.out.println("inserting at curr value: " + curr.value + " head = " +
			// head.value);

			System.out.println("printing res ");
			// res.print();
			curr.next = new Node(head.value);
			res.print(false);
			if (temp != null) {
				curr.next.next = temp;
			}
			res.print(false);
			head = head.next;
		}
		// this = res
		head = res.head;
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

	// O(n) time complexity
	// swap in array is O(1)
	void SwapNodes(int index1, int index2) { // write this method
		Node prev1;
		Node prev2;
		prev1 = prev2 = head; // initialize prev nodes
		for (int i = 0; i < index1; i++) {
			prev1 = prev1.next;
		}
		Node curr1 = prev1.next; // curr 1 node is just one spot after curr1
		for (int i = 0; i < index2; i++) {
			prev2 = prev2.next;
		}
		Node curr2 = prev2.next;

		// System.out.println("prev1: " + prev1.value + " prev2: " + prev2.value + "
		// curr 1: " + curr1.value + " curr 2: " + curr2.value);

		prev1.next = curr2;
		prev2.next = curr1;
		Node temp = curr1.next;
		curr1.next = curr2.next;
		curr2.next = temp;
	}

	void delete(int index) {
		// write this method
		Node iter = head;
		for (int i = 0; i < index; i++) {
			iter = iter.next;
		}
		iter.next = iter.next.next;
	}

	void append(int value) {
		Node curr = new Node(value);
		Node temp = head.next;
		head.next = curr;
		curr.next = temp;
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

	void print(boolean dummyHead) { // if dummyhead true then print next node
		Node iter = new Node(head);
		if (dummyHead)
			iter = iter.next;
		while (iter != null) {
			System.out.print(iter.value + " > ");
			iter = iter.next;
		}
		System.out.println();

	}
}
