package pekan6_2511538002;

public class InsertDLL_2511538002 {
	//menambakan node di awal DLL 
	
	static NodeDLL_2511538002 insertBegin_8002(NodeDLL_2511538002 head, int data_8002)  {
		// buat node baru
		NodeDLL_2511538002 new_node = new NodeDLL_2511538002 (data_8002);
		// jadikan pointer nextnya head
		
		new_node.next_8002 = head;
		// jadikan pointer prev head je new_node
		if (head != null) { 
			head.prev_8002 = new_node;
		}
		return new_node; 
		}
	// fungsi menambakan node di akhir
	
	public static NodeDLL_2511538002 insertEnd_8002(NodeDLL_2511538002 head, int newData) { 
		// buat node baru 
		NodeDLL_2511538002 newNode = new NodeDLL_2511538002 (newData);
		// jika DLL  null jaidikan head
		if (head == null) {
			head = newNode;
			
		}
		else {
			 NodeDLL_2511538002 curr= head;
			 while (curr.next_8002 != null ) {
				  curr = curr.next_8002;
				  
				 
			 }
			  curr.next_8002 = newNode;
			  newNode.prev_8002 = curr; 
		}
		return head;
		
	} 
	// fungsi menabakan node di posisi tertentu
	public static NodeDLL_2511538002 insertAtposition_8002(NodeDLL_2511538002 head, int pos, int new_data) {
		// buat node baru 
		NodeDLL_2511538002 new_node = new NodeDLL_2511538002 ( new_data);
		if (pos == 1) {
			new_node.next_8002 = head;
			if (head != null) {
				head.prev_8002 = new_node; }
			head = new_node;
			return head; } 
		NodeDLL_2511538002 curr = head;
		for ( int i = 1; i < pos -1 && curr != null; i++) {
			curr = curr.next_8002; }
		 if (curr == null ) {
			 System.out.println("posisi tidak ada");
			 return head; }
		 new_node.prev_8002 = curr;
		 new_node.next_8002 = curr.next_8002;
		 curr.next_8002 = new_node;
		 if (new_node.next_8002 != null) {
			 new_node.next_8002.prev_8002 = new_node; } 
		 return head;
	}
	 public static void printList_8002(NodeDLL_2511538002 head) {
		 NodeDLL_2511538002 curr = head;
		 while (curr != null) {
			 System.out.print(curr.data_8002 + " <-> ");
			 curr = curr.next_8002;
		 } 
		 System.out.println(); 
		 
	 } 

	public static void main(String[] args) {
		// membuat DLL 2 <-> 3 <-> 5
		NodeDLL_2511538002 head = new NodeDLL_2511538002(2);
		head.next_8002 = new NodeDLL_2511538002(3);
		head.next_8002.prev_8002 = head;
		head.next_8002.next_8002 = new NodeDLL_2511538002(5);
		head.next_8002.next_8002.prev_8002 = head.next_8002;
		// ceatak dll awal
		System.out.print( "DLL awal: ");
		printList_8002(head);
		// tambah 1 di awal
		head = insertBegin_8002(head, 1);
		System.out.print( 
				"simpul 1 ditambah di awal: ");
		printList_8002(head);
		//tambah 6 di akhir
	System.out.print(
			"simpul 6 ditambah di akhir: ");
	int data_8002 = 6;
	head = insertEnd_8002(head, data_8002);
	printList_8002(head);
	// menabah node 4 di posisi 4
	System.out.print("tambah node 4 di posisi 4: ");
	int data2 = 4;
	int pos = 4;
	head = insertAtposition_8002(head, pos, data2);
	printList_8002(head);
	

	}

}
