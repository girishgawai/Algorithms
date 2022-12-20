package linkedlist.qps;

public class Remove_Cycle_FloyedAlgo_CycleGenerate {

	private class Node {
		int val;
		Node next;

	}

	private Node head;// 1st node address yaad krega every LinkedList
	private Node tail;// last node address yaad krega every LinkedList
	private int size;// total number of Node in LinkedList


	public static void main(String[] args) throws Exception {
		Remove_Cycle_FloyedAlgo_CycleGenerate rc = new Remove_Cycle_FloyedAlgo_CycleGenerate();
		rc.addlast(1);
		rc.addlast(2);
		rc.addlast(3);
		rc.addlast(4);
		rc.addlast(5);
		rc.addlast(6);
		rc.addlast(7);
		rc.addlast(8);
		rc.Display();

		rc.CreateCycle(2);			// creating cycle at index 2
		//				rc.Display();				//  cycle is genmerate.. agr print kia toh infinite loop me chlte rhega code

		System.out.println(rc.hasCycle());			// cycle btayega hai ya nhi.. -->hai toh ki common point slow aur fast kha mile ? 
		// jisse pta chla cycle hai krke

		//		rc.removeCycle();			// O(N^2)					// O(N^2) approach
		//		rc.Display();

		//		rc.removeCycle_11();		// O(N)	--> But count v nikalna pda isme
//				rc.Display();

		rc.floydCycleRemovalAlgo();			// O(N)			// Best-Solution		--> Optimized Approach
		rc.Display();
	}


//	O(N)											// Most Optimized Approach algorithm
	public void floydCycleRemovalAlgo() {
		// TODO Auto-generated method stub
		Node meet = hasCycle();
		if(meet==null)
			return;
		
		Node start = head;
		while(meet.next!=start.next)				// isse cycle wala point/node milega
		{
			start=start.next;
			meet=meet.next;
		}
		
		meet.next = null;			// remove krdiya cycle ko
	}


//	O(N)
	public void removeCycle_11() {
		// TODO Auto-generated method stub
		Node meet = hasCycle();
		if(meet==null)
			return;

		int count=1;			// mto calculate cycle length
		Node temp = meet;
		while(temp.next!=meet)			// ccyle ki length mil jayegi isse
		{
			temp = temp.next;
			count++;
		}

		Node fast = head;
		for (int i = 1; i <=count ; i++) {
			fast=fast.next;
		}

		Node slow = head;
		while(slow.next!=fast.next)				// issee jha pe cycle form hori woh milega
		{
			slow=slow.next;
			fast=fast.next;
		}

		fast.next=null;						//// cycle form hori milne pe usko null krdege --> cycle move ho jayegi
	}



	//	O(N^2)
	public void removeCycle() {
		// TODO Auto-generated method stub
		Node meet = hasCycle();
		if(meet==null)
			return;

		Node start = head;
		while(start!=null)
		{
			Node temp = meet;				// meeting point ka adrs
			while(temp.next!=meet)											// cycle me ghumege start milta kya check krege
			{
				if(temp.next==start)
				{
					temp.next = null;				// agr cycle point mil gya toh usko remove kre
					return;								// aur cycle point null/ remove krne ke baad fun ko terminate krdo	
				}
				else {
					temp = temp.next;
				}
			}
			start = start.next;
		}

	}

	public Node hasCycle() {
		// TODO Auto-generated method stub
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null)
		{
			slow =slow.next;
			fast=fast.next.next;

			if(fast==slow)
				return slow;
		}
		return null;
	}


	public void CreateCycle (int idx) throws Exception
	{
		Node gc = GetNode(idx);									// getting idx node on which index cycle is to been create/jon

		tail.next = gc;						// tail ke last node se next ka adrs idx wale node ka daal diya to make cycle
	}




	/**************************************************************************************************************/




	//o(1)
	public void addfirst(int item) {
		Node nn = new Node();
		nn.val = item;
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			nn.next = head;
			head = nn;
			this.size++;
		}
	}

	// o(1)
	public void addlast(int item) {
		if (size == 0) {
			addfirst(item);
		} else {
			Node nn = new Node();
			nn.val = item;
			tail.next = nn;
			tail = nn;
			size++;
		}

	}

	public Node GetNode(int k) throws Exception {

		if (k < 0 || k >= size) {
			throw new Exception("Index Valid dedo bklol");
		}
		Node temp = head;
		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void Display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " --> ");
			temp = temp.next;
		}
		System.out.println(".");
	}

}
