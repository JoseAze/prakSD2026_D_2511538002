package pekan7_2511538002;

public class SelectionSort_2511538002 {

    public static void selectionSort_2511538002(int[] arr) {

        int n_8002 = arr.length;
        for (int i = 0; i < n_8002; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n_8002; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        int arr[] = {23, 78, 45, 8, 32, 56, 1};

        int n_8002 = arr.length;

        System.out.println("Array yang belum terurut:");

        for (int i = 0; i < n_8002; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        selectionSort_2511538002(arr);

        System.out.println("Array yang terurut:");

        for (int i = 0; i < n_8002; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}