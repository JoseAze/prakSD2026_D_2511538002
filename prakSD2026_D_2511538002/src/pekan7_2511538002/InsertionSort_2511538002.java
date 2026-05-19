package pekan7_2511538002;

public class InsertionSort_2511538002 { 
	public static void insertionSort_2511538002 (int[] arr) {
		int  n_8002 = arr.length;
		for (int i = 1; i < n_8002; i++) {
			int  key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
			}	
		}
	public static void main(String[] args) {
	int arr[] = {23, 78, 45, 8, 32, 56, 1};
	int n_8002 = arr.length;
	System.out.printf("array yang belum terurut:\n");
	for (int i=0; 1 <n_8002; i++)
		System.out.print(arr[i] + " ");
	System.out.println("");
	insertionSort_2511538002(arr);
	System.out.println("array yang terurut:\n");
	for (int i =0; i< n_8002; i++)
		System.out.print(arr[i] + " ");
	System.out.println("");
	}
}
