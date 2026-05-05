package pekan5_2511538002;

public class HapusSLL_2511538002 { 
	//fungsi untuk menghapus head
	public static NodeSLL_2511538002 deleteHead (NodeSLL_2511538002 head_8002) {
		// jika SLL kosong
		if (head_8002 == null)
			return null;
		// pindahkan head ke node berikutnya
		head_8002 = head_8002.next_8002; 
		//return head baru
		return head_8002; 
	} 

	//fungsi menghapus node terakhir SLL
	public static NodeSLL_2511538002 removeLastNode(NodeSLL_2511538002 head_8002) { 
		if (head_8002 == null) {
			return null;
		}
		if (head_8002.next_8002 == null) { 
			return null;
		} 

		NodeSLL_2511538002 secondLast = head_8002;
		while (secondLast.next_8002.next_8002 != null) { 
			secondLast = secondLast.next_8002;
		}

		secondLast.next_8002 = null;
		return head_8002; 
	} 

	// fungsi menghapus node di posisi tertentu 
	public static NodeSLL_2511538002 deleteNode (NodeSLL_2511538002 head_8002, int position_8002) {
		NodeSLL_2511538002 temp = head_8002;
		NodeSLL_2511538002 prev = head_8002;

		if (temp == null)
			return head_8002;

		// kasus 1: head dihapus
		if (position_8002 == 1) {
			head_8002 = temp.next_8002;
			return head_8002;
		}

		// kasus 2: hapus node tengah
		for (int i = 1; temp != null && i < position_8002; i++) {
			prev = temp;
			temp = temp.next_8002; 
		}

		if(temp != null) {
			prev.next_8002 = temp.next_8002;
		} else {
			System.out.println("data tidak ada");
		}

		return head_8002;
	}

	// fungsi mencetak SLL
	public static void printList(NodeSLL_2511538002 head_8002) { 
		NodeSLL_2511538002 curr = head_8002;
		while (curr != null) {
			System.out.print(curr.data_8002);
			if (curr.next_8002 != null) {
				System.out.print("-->");
			}
			curr = curr.next_8002;
		}
		System.out.println();
	}
			
	// kelas main
	public static void main(String[] args) { 
		NodeSLL_2511538002 head_8002 = new NodeSLL_2511538002(1);
		head_8002.next_8002 = new NodeSLL_2511538002(2);
		head_8002.next_8002.next_8002 = new NodeSLL_2511538002(3);
		head_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002(4);
		head_8002.next_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002(5);
		head_8002.next_8002.next_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002(6);

		System.out.println("List awal: ");
		printList(head_8002);

		head_8002 = removeLastNode(head_8002);
		System.out.println("List setelah simpul terakhir di hapus: ");
		printList(head_8002);

		// deleting node at position 2
		int position_8002 = 2;
		head_8002 = deleteNode(head_8002, position_8002);

		System.out.println("List setelah posisi 2 dihapus: ");
		printList(head_8002);
	}
}