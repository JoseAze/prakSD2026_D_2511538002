package pekan6_2511538002;

public class PenelusuranDLL_2511538002 { 
	// fungsi penelususran maju
	static void forwardTraversal_8002(NodeDLL_2511538002 head) {
		//memulai penelususran dari head
			
	//memi]ulai penelusuran dari head
	NodeDLL_2511538002 curr = head;
	//lanjutkan sampai akhir 
	while (curr != null) {
		// print data
		 System.out.print(curr.data_8002 + " <-> ");
		 // pidnah ke node berikutnya
		 curr = curr.next_8002;
	} 
	// print spasi 
	System.out.println();
	
	}
	// fungsi penelususran mundur
	static void backwardTraversal_8002(NodeDLL_2511538002 tail) {  
		// mlai dari akhir 
		NodeDLL_2511538002 curr = tail;
		// lanjut sampai head
		while (curr != null) {
			// cetak data
	    System.out.print(curr.data_8002 + " <-> "); 
	    // pindah ke node sebelumnya
	    curr = curr.prev_8002;
	    
		}//cetak spasi 
		System.out.println();
		
	}

	public static void main(String[] args) {
		// cetak DLL 
		NodeDLL_2511538002 head = new NodeDLL_2511538002(1);
		NodeDLL_2511538002 second = new NodeDLL_2511538002(2);
		NodeDLL_2511538002 third = new NodeDLL_2511538002(3); 
		 head.next_8002 = second;
		 second.prev_8002 = head;
		 second.next_8002 = third;
		 third.prev_8002 = second;
		 
		 System.out.println("penelusuran maju:");
		 forwardTraversal_8002(head);
		 
		 System.out.println("penelusuran mundur:");
		 backwardTraversal_8002(third);

	}

}
