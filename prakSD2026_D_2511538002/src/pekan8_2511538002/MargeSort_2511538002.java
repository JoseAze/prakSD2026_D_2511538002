package pekan8_2511538002;

public class MargeSort_2511538002 {
    void merge(int arr[], int l, int m, int r) {
        // Ukuran array sementara
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        // Salin data ke array sementara L[]
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        // Salin data ke array sementara R[]
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        // Gabungkan kedua array sementara
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Salin sisa elemen L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Salin sisa elemen R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // Fungsi Merge Sort
    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            // Urutkan bagian kiri
            sort(arr, l, m);
            // Urutkan bagian kanan
            sort(arr, m + 1, r);
            // Gabungkan hasilnya
            merge(arr, l, m, r);
        }
    }
    // Menampilkan array
    static void PrintArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Sebelum diurutkan:");
        PrintArray(arr);
        MargeSort_2511538002 ob = new MargeSort_2511538002();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("\nSesudah diurutkan menggunakan Merge Sort:");
        PrintArray(arr);
    }
}