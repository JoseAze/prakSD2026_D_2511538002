package pekan9_2511538002;

public class BTree_2511538002 { 
	private Node_2511538002 root;
	private Node_2511538002 currentNode;
	public BTree_2511538002() { 
		root = null; 
		
	}
	public boolean search(int data_8002) { 
		return search (root, data_8002); 
		
	} 
	private boolean search (Node_2511538002 node_8002, int data_8002) { 
		if (node_8002.getData() == data_8002)
		return true;
		if (node_8002.getLeft_8002() != null) 
			if (search(node_8002.getLeft_8002(), data_8002))
			return true;
		if (node_8002.getRight_8002() != null)
			if (search(node_8002.getRight_8002(), data_8002))
				return true; 
		return false;
	}
	public void printInorder_8002() {
		root.printInorder_8002(root);
	} 
	public void printpreOrder_8002() { 
		root.printPreorder_8002(root);
	}
	public void printpostOrder_8002() { 
		root.printPostorder(root);	
	}  
	public Node_2511538002 getRoot() {
		return root;
	} 
	public boolean isEmpty_8002() { 
		return root == null; 
	}
		public int countNodes() { 
			return countNodes(root);
		} 
		 private int countNodes(Node_2511538002 node_8002) { 
			 int count = 1;
			 if (node_8002 == null) { 
				 return 0;
			 } else {
				 count += countNodes(node_8002.getLeft_8002());
				 count += countNodes(node_8002.getRight_8002());
				 return count; 
			 }
		 }
		public void print() { 
			root.print();	 
		} 
	public Node_2511538002 getCurrent() { 
		return currentNode;
	} 
	public void setCurrent (Node_2511538002 node_8002) {
		this.currentNode = node_8002;
	} 
	public void setRoot(Node_2511538002 root) { 
		this.root = root;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
