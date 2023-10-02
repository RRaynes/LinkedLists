package camstructures;

public class Tester {
	public static void main(String[] args) {
		List l1 = new List();
		
		l1.append(3);
		l1.append(6);
		l1.append(7);
		
		l1.print();
		
		l1.SwapNodes(0, 2);
		
		l1.print();
	}
}
