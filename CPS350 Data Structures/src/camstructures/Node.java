package camstructures;

public class Node {
	int value;
	Node next;
	
	public Node() {
		value = 0;
		next = null;
	}
	
	public Node(int value) {
		this.value = value;
		next = null;
	}
	
	public Node(Node a) {
		value = a.value;
		next = a.next;
	}
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
