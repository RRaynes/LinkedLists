package camstructures;

public class Tester {
	public static void main(String[] args) {
		List l1 = new List();
		l1.append(2);
		l1.append(6);
		
		List l2 = new List();
		l2.append(1);
		l2.append(3);
//		l1.SwapNodes(1, 4);
		
		List l3 = new List(l1.merge(l1.head, l2.head));
		l3.print();
		
		
		//l1.print();
		//System.out.println("tail " + l1.tail.value); 
		
		l1.print();
		l1.insertionSort();
		l1.print();
	}
}
