package pekan2_2511538002; 
import java.util.ArrayList;

public class ArrayList1_2511538002 {

	public static void main(String[] args) {
		// size of the ArrayList
		int n=5;
		// Declaring the ArrayList with initial size n
		ArrayList<Integer>arrli = new ArrayList<Integer>(n);
// appending new elements at the end of the list
		for (int i= 0; i<= n;  i++)
			arrli.add(i);
		// printing elements
		System.out.println(arrli);
		// remmove element at index 3
		arrli.remove(3);
		//Displaying the arrayList
		// after deletion 
		System.out.println(arrli);
		// printing elements one by one
		for (int i =0; i < arrli.size(); i++)
			System.out.print(arrli.get(i)+ " ");
		
	}

}
