package pekan6_2511538002;



public class HapusDLL_2511538002 { 
	
	// fungsi manghapus node awal
	public static NodeDLL_2511538002 delHead(NodeDLL_2511538002 head) {
		if (head == null) {
			return null;}
			NodeDLL_2511538002 temp = head;
			head = head.next_8002;
			if (head != null) {
				head.prev_8002 = null; }
			return head;  }
			
			// fungsi menghapsu di akhir
			public static NodeDLL_2511538002 delLast(NodeDLL_2511538002 head, int pos) {
				// jikda dll kosong
				if (head == null) {
					return head; }
				NodeDLL_2511538002 curr = head; 
				//telesuri sampai ke node
				for (int i = 1; curr != null && i < pos; ++i) {
					curr = curr.next_8002; } 
				// jikda posisi tidak
				if (curr == null) {
					return head; }
					//update pointer
					if (curr.prev_8002 != null) { 
						curr.prev_8002.next_8002 = curr.next_8002; }
					if (curr.next_8002 != null) {
						curr.next_8002.prev_8002= curr.prev_8002; }
					// jika yang
					if (head == curr) {
						head = curr.next_8002; }
					return head; 
					}
				// fungsi mencetak
				public static void prinList(NodeDLL_2511538002 head) {
					NodeDLL_2511538002 curr = head;
					while (curr != null) {
						System.out.print(curr.data_8002 + " ");
						curr= curr.next_8002;
						
					} 
					System.out.println();
					
				}
		// fungsi menghapus di akhhir
		public static NodeDLL_2511538002 delLast(NodeDLL_2511538002 head) { 
			if (head == null) {
				return null;}
				if (head.next_8002 == null) {
					return null; }
					NodeDLL_2511538002 curr = head; 
					while (curr.next_8002 != null) {
						curr = curr.next_8002;
			
				} 
					// update [pointer previous node
					if (curr.prev_8002 != null) {
						curr.prev_8002.next_8002 = null; }
					return head;  
					
					
			} 
					// fungsi menghapus nnode posisi tertentu
					public static NodeDLL_2511538002 delPos(NodeDLL_2511538002 head, int pos) {
						// jika dll kosong
						if (head == null) {
							return head; }
						NodeDLL_2511538002 curr = head; 
						// teleudri
						for (int i = 1; curr != null && i< pos; ++i) {
							curr = curr.next_8002;}
							// jika ps
							if (curr == null) { 
								return head;}
								
								// update 
								if (curr.prev_8002 != null) {
									curr.prev_8002.next_8002= curr.next_8002; }
								// jika yang
								if (head == curr) {
									head = curr.next_8002; }
								return head;
								} 
							//fungsi
							 public static void printList(NodeDLL_2511538002 head) {
								 NodeDLL_2511538002 curr = head;
								 while (curr != null ) { 
									 System.out.print(curr.data_8002 + " ");
									 curr = curr.next_8002;
								 }
								 System.out.println(); }
			
					
	public static void main(String[] args) {
		// buat sebuah dll
		NodeDLL_2511538002 head = new NodeDLL_2511538002(1);
		head.next_8002 = new NodeDLL_2511538002(2);
		head.next_8002.prev_8002 = head;
		head.next_8002.next_8002  = new NodeDLL_2511538002(3);
		head.next_8002.next_8002.prev_8002 = head.next_8002;
		head.next_8002.next_8002.next_8002 = new NodeDLL_2511538002 (4);
		head.next_8002.next_8002.next_8002.prev_8002 = head.next_8002.next_8002 ;
		head.next_8002.next_8002.next_8002.next_8002 = new NodeDLL_2511538002(5);
		head.next_8002.next_8002.next_8002.next_8002.prev_8002 = head.next_8002.next_8002.next_8002;
		
		System.out.print("DLL Awal: ");
		printList(head);
		
		System.out.println("setelah head dihapus: ");
		head = delHead(head);
		printList(head);
		
		System.out.print(" setelah node terakhir di happus: ");
		head = delLast(head);
		printList(head);
		
		System.out.println("manghapus node ke 2: ");
		head = delPos(head, 2);
		printList(head);

	}

}
