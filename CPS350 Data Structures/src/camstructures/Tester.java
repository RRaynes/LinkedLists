package camstructures;

public class Tester {
	public static void main(String[] args) {
		List l1 = new List();
		l1.append(2);
		l1.append(6);
		l1.append(1);
		l1.append(3);
		l1.append(4);
//		l1.SwapNodes(1, 4);
		
		List l2 = new List();
		l2.append(82);
		l2.append(91);
		l2.append(1);
		l2.append(-4);
		l2.append(-87);
		l2.append(347);
		l2.append(34);
		l2.append(12);
		l2.append(-2);
		l2.print(true);
		
		l2.insertionSort();
		l2.print(true);
//		Node n = l1.getMiddle(l1.head.next);
//		System.out.println(n.value);
		
		
		//l1.print();
		//System.out.println("tail " + l1.tail.value); 
		
	}
}
