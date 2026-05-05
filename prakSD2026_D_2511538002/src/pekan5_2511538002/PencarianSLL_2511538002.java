package pekan5_2511538002;

public class PencarianSLL_2511538002 { 
	static boolean searchKey(NodeSLL_2511538002 head_8002, int key_8002) {
		NodeSLL_2511538002 curr = head_8002;
		while (curr != null) {
			if (curr.data_8002== key_8002)
				return true;
			curr = curr.next_8002; }
		return false; }
	public static void traversal (NodeSLL_2511538002 head_8002) {
		//mulai dari head
		NodeSLL_2511538002 curr = head_8002;
		//telesuri sampai pointer null
		while (curr != null) {
			System.out.print(" " + curr.data_8002);
			curr =curr.next_8002; }
		System.out.println(); }


	public static void main(String[] args) {
		NodeSLL_2511538002 head_8002 = new NodeSLL_2511538002(14);
		head_8002.next_8002 = new NodeSLL_2511538002(21);
		head_8002.next_8002.next_8002 = new NodeSLL_2511538002(13);
		head_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002 (30);
		head_8002.next_8002.next_8002.next_8002.next_8002 = new NodeSLL_2511538002 (10);
		System.out.print("penelusuran SLL : ");
		traversal(head_8002);
		// data yang akan dicari
		int key_8002 =30;
		System.out.print("cari data "+ key_8002+ " = ");
		if (searchKey(head_8002, key_8002)) 
			System.out.println("ketemu");
		else 
			System.out.println("tidak ada");

	}

}
