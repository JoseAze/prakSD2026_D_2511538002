package pekan9_2511538002;

public class Node_2511538002 { 
	int data_8002;
	Node_2511538002 left_8002;
	Node_2511538002 right_8002; 
	public Node_2511538002(int data_8002) {
		this.data_8002 = data_8002;
		left_8002 = null;
		right_8002 = null;
		
	}
	public void setLeft_8002(Node_2511538002 node_8002) {
		if (left_8002 == null)
			left_8002 = node_8002; 
		
	} 
	public void setRight_8002(Node_2511538002 node_8002) {
		if (right_8002 == null)
		right_8002 = node_8002;
	} 
	 public Node_2511538002 getLeft_8002() { 
		 return left_8002;
	 }
	 public Node_2511538002 getRight_8002() { 
		 return right_8002;
	 }
	 public int getData() { 
		 return data_8002;
	 }
	  public void setData_8002(int data_8002) {
		  this.data_8002 = data_8002; 
	  }
	  void PrintPreorder_8002(Node_2511538002 node_8002) {
		  if (node_8002 == null) 
	  return;
		  System.out.print(node_8002.data_8002 + " ");
		  printPreorder_8002(node_8002.left_8002);
		  printPreorder_8002(node_8002.right_8002); 
	  }
	  void printPreorder_8002(Node_2511538002 node_8002) {
		  if ( node_8002 == null) 
			  return; 
		  printPostorder(node_8002.left_8002);
		  printPostorder(node_8002.right_8002);
		  System.out.print(node_8002.data_8002 + " ");
	  }
	  void printInorder_80021(Node_2511538002 node_8002) {
		  if (node_8002 == null)
			  return;
		  printInorder_80021(node_8002.left_8002);
		  System.out.print(node_8002.data_8002 + " ");
		  printInorder_8002(node_8002.right_8002);
	  }
	  void printPostorder (Node_2511538002 node_8002) {
		  if (node_8002 == null)
			  return;
		  printPostorder(node_8002.left_8002);
		  printPostorder(node_8002.right_8002);
		  System.out.print(node_8002.data_8002 + " ");
	  } 
	  void printInorder_8002(Node_2511538002 node_8002) {
		  if ( node_8002 == null)
			  return;
		  printInorder_80021(node_8002.left_8002);
		  System.out.print(node_8002.data_8002 + " "); 
		  printInorder_80021(node_8002.right_8002);
	  } 
	  public String print() { 
		  return this.print("", true, "");
	  } 
	  public String print (String prefix, boolean isTail, String sb) {
		  if (right_8002  != null) { 
			  right_8002.print(prefix  + (isTail ? "|    " : "     "), false, sb);
		  }
		  System.out.println(prefix+(isTail ? "\\--- " : "/-- ")+data_8002); 
		  if (left_8002 != null) { 
			  left_8002.print(prefix +( isTail ? "  " : "|    "), true, sb);
		  }
		  return sb;
	  } 
			  
		 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
