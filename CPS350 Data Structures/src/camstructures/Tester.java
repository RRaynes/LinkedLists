package camstructures;

public class Tester {
	public static void main(String[] args) {
		List l1 = new List();
		
		l1.append(9);
		l1.append(6);
		l1.append(2);
		l1.append(4);
		l1.append(5);
//		l1.SwapNodes(1, 4);
		
		
		//l1.print();
		//System.out.println("tail " + l1.tail.value); 
		
		l1.print();
		l1.insertionSort();
		l1.print();
	}
}
