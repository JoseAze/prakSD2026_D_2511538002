package pekan8_2511538002;

public class ShellSort_2511538002 { 
	public static void ShellSort_2511538002(int[] A) {
		int n = A.length;
		int gap = n/2;
		while (gap > 0) {
			for(int i = gap; i<n; i++) { 
				int temp = A[i];
				int j =i;
				while (j >= gap && A[j - gap] > temp) {
					A[j] = A[j- gap];
					j = j -gap;
				}
				A[j] = temp;
				}
			gap = gap/2;
			}
		}
	

	public static void main(String[] args) { 
		int [] data = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
	
		System.out.print("Sebelum: ");
		PrintArray(data);
		 
		ShellSort_2511538002(data);
		
		System.out.print("sesudah (Shell Sort):");
		PrintArray(data); 
		
		}
public static void PrintArray(int[] arr) {
			for (int i : arr) System.out.print(i + " ");
		}
	}


