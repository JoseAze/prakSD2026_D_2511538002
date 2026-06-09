package pekan9_2511538002;


public class BtreeDriver_2511538002 {

	public static void main(String[] args) { 
		//membuat pohon 
		BTree_2511538002 tree = new BTree_2511538002();
		System.out.print("Jumlah simpul awal pohon: ");
		System.out.println(tree.countNodes()); 
		// menamabakan simpul data 1 
		Node_2511538002 root = new Node_2511538002 (1);
		// menajdikan simpul 1 sebagai root
		tree.setRoot(root);
		System.out.println("jumlah simpul jika hanya ada root");
		System.out.println(tree.countNodes());
		Node_2511538002 node2 = new Node_2511538002(2);
		Node_2511538002 node3 = new Node_2511538002(3);
		Node_2511538002 node4 = new Node_2511538002(4);
		Node_2511538002 node5 = new Node_2511538002(5);
		Node_2511538002 node6 = new Node_2511538002(6);
		Node_2511538002 node7 = new Node_2511538002(7);
		Node_2511538002 node8 = new Node_2511538002(8);
		Node_2511538002 node9 = new Node_2511538002(9); 
		root.setLeft_8002(node2);
		node2.setLeft_8002(node4); 
		node2.setRight_8002(node5);
		node4.setRight_8002(node8);
		root.setRight_8002(node3); 
		node3.setLeft_8002(node6);
		node3.setRight_8002(node7);
		node6.setLeft_8002(node9);
		// set root
		tree.setCurrent(tree.getRoot());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree.getCurrent().getData());
		System.out.println("Jumlah simpul; setelah simpul 7 ditambakan");
		System.out.println(tree.countNodes());
		System.out.println("InOrder: ");
		tree.printInorder_8002();
		System.out.println("\npostorder : ");
		tree.printpostOrder_8002();
		System.out.println("\n Dmenampilkan simpul  dalam bentuk pohon");
		tree.print();
		// TODO Auto-generated method stub

	}

}
