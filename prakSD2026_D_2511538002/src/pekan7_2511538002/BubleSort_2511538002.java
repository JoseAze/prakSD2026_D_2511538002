package pekan7_2511538002;

public class BubleSort_2511538002 { 
	public static void bubbleSort(int[] arr) { 
		int n = arr.length;
		for (int i = 0; i < n; i++) { 
			for (int j= 0; j < n - i-1; j++) { 
				if (arr[j] > arr[j + 1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+ 1] = temp;
					// system.out.println("data:"+arr[j]+" "+ arr{j+1];
					
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {23,78, 45, 8, 32, 56, 1 };
		int n = arr.length;
		System.out.print( "array yang belim terurut:\n");
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
		bubbleSort(arr);
		System.out.print("array yang teururt  menggunakan bubleSort:");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i]+ " ");
		System.out.println("");
		}

	}


