package pekan5_2511538002;

public class TambahSLL_2511538002 { 
	public static NodeSLL_2511538002 insertAtFront(NodeSLL_2511538002 head_8002, int value_8002) {
	NodeSLL_2511538002 new_node =new NodeSLL_2511538002(value_8002);
	new_node.next_8002 = head_8002;
	return new_node; 
	} 
	// fungsi menambakan node di akhir SLL
	public static NodeSLL_2511538002 insertAtEnd (NodeSLL_2511538002 head_8002, int value_8002) {
	// buat sebuah node dengan sebuah nnilai
		NodeSLL_2511538002 newNode = new NodeSLL_2511538002(value_8002);
		// jika list kosong maka node jadi head
		if (head_8002 == null) {
			return newNode; 
		} 
		// simpan head ke variabel sementara 
		NodeSLL_2511538002 last = head_8002;
		//telesuri ke node akhir
		while (last.next_8002 != null) {
			last =last.next_8002;	
		}
		// ubah pointer
		last.next_8002 = newNode;
		return head_8002; } 
	static NodeSLL_2511538002 GetNode (int data_8002) {
		return new NodeSLL_2511538002(data_8002); 
	} 
	static NodeSLL_2511538002 insertPos (NodeSLL_2511538002 headNode_8002, int position_8002, int value_8002) { 
		NodeSLL_2511538002 head_8002 = headNode_8002;
		if (position_8002 < 1) { 
			System.err.print("Invalid position");
		if (position_8002 == 1 ) {
			NodeSLL_2511538002 new_node = new NodeSLL_2511538002 (value_8002);
			new_node.next_8002 = head_8002;
			return new_node;
		} else {
			while (position_8002-- !=0) {
				if (position_8002 == 1) {
					NodeSLL_2511538002 newNode = GetNode(value_8002);
					newNode.next_8002 = headNode_8002.next_8002;
					headNode_8002.next_8002 = newNode;
					break;
				} 
				headNode_8002 = headNode_8002.next_8002;
				}
			if (position_8002 != 1)
				System.out.print("posisi di luar jangkauan"); }
		return head_8002;  }
		return head_8002;}
		public static void printList(NodeSLL_2511538002 head_8002) {
		NodeSLL_2511538002 curr = head_8002;
		while (curr.next_8002 != null) {
			System.out.print(curr.data_8002+"-->");
			curr = curr.next_8002;
			}
		if (curr.next_8002 == null) { 
		System.out.print(curr.data_8002); }
		System.out.println();	
		}
	public static void main(String[] args) {
		// buat linked list 2->3->5->6
		NodeSLL_2511538002 head_8002 = new NodeSLL_2511538002(2); 
		head_8002.next_8002 = new NodeSLL_2511538002(3);
		head_8002.next_8002.next_8002 = new NodeSLL_2511538002(5);
		head_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002(6);
		//cetak list asli
		System.out.print("Senarai berantai awal:");
		printList(head_8002);
		//tambahkan node baru di depan
		System.out.print("tambah 1 simpul di depan: ");
		int data_8002 = 1;
		head_8002 = insertAtFront(head_8002, data_8002);
		//cetak update list 
		printList(head_8002);
		//tambahkan node baru di belakang
		System.out.print("tambah 1 simpul di belakang: ");
		int data2 = 7;
		head_8002 = insertAtEnd(head_8002, data2);
		//cetak update list
		printList(head_8002);
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3 = 4;
		int pos=4;
		head_8002 = insertPos(head_8002,pos,data3);
		//cetak update list
		printList(head_8002);
	
		

	}

}
