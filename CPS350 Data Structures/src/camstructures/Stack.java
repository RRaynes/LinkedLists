package camstructures;

public class Stack {
	int[] content;
	int top = -1;
	
	public Stack() {
		content = new int[10];
	}
	
	void push(int value) {
		top++;
		content[top] = value;
	}
	
	int pop() {
		return 1; 
	}
}
