package pekan2_2511538002;
import java.util.Scanner;
import java.util.ArrayList;
public class MahasiswaDriver_2511538002 {  
	//1. Method untuk menampilkan menu 
	public static void tampilkanMenu_2511538002() {
		System.out.println("\nMenu");
		System.out.println("1. Tambah Mahasiswa");
		System.out.println("2. Tampilkan semua Mahasiswa");
		System.out.println("3. Hapus Mahasiswa berdasarkan Nim");
		System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
		System.out.println("5. Keluar");
		
	}
	 
	//2. method untuk tambah mahasiswa
		public static void tambahMahasiswa_25511538002(ArrayList<Mahasiswa_2511538002> list, Scanner sc) { 
		System.out.println(" Masukan NIM: ");
		String nim = sc.nextLine();
		System.out.println("masukan Nama:");
		String nama = sc.nextLine();
		System.out.println("Masukan Prodi: ");
		String prodi = sc.nextLine();
		list.add(new Mahasiswa_2511538002(nim, nama, prodi));
		System.out.println("Mahasiswa berhasil ditambahkan."); 
	} 
	 // Method untuk tampilkan smua data
	public static void tampilkanSemuaMahasiswa_2511538002(ArrayList<Mahasiswa_2511538002> list) {
		if (list.isEmpty()) {
			System.out.println( "Daftar Mahasiswa kosong.");
		}else {
			System.out.println("Data mahasiswa");
			for ( Mahasiswa_2511538002 mhs : list ) {
				System.out.println(mhs);
			}
		}
	}
	// 4. method untuk hapus mahasiswa nim
	public static void hapusMahasiswa_2511538002(ArrayList<Mahasiswa_2511538002> list, Scanner sc) {
		System.out.print( " Masukan NIM yang akan dihapus: ");
		String nimHapus_2511538002 = sc.nextLine();
		boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus_2511538002));
		if (removed) {
			System.out.println("Data dengan NIM " + nimHapus_2511538002 + "Berhasil dihapus.");
		} else {
			System.out.println("NIM tidak ditemukan."); 
		}
	}
	 // 5.method untuk cari mahasiswa berdasarkan nim 
	public static void cariMahasiswa_2511538002(ArrayList<Mahasiswa_2511538002> list, Scanner sc) {
		System.out.println("Masukkan Nim yang dicari: ");
		String nimCari = sc.nextLine();
		boolean ditemukan =false;
		for (Mahasiswa_2511538002 mhs : list) { 
			if (mhs.nim.equals(nimCari)) {
				ditemukan = true;
				break;
			}
			
		} 
		if (!ditemukan) { 
			System.out.println("nim tidak ada.");
		}
			
	} 
	public static void main(String[] args) { 
	ArrayList<Mahasiswa_2511538002> mahasiswaList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int choice;
	
	do {
	 tampilkanMenu_2511538002();
	 System.out.println("pilihan menu : ");
	 choice = scanner.nextInt();
	 scanner.nextLine(); // consume neLine
	 switch (choice) {
	 case 1: 
		 tambahMahasiswa_25511538002(mahasiswaList, scanner); 
		 break;
	 case 2 :  
		 tampilkanSemuaMahasiswa_2511538002(mahasiswaList);
		 break;
	 case 3 : 
		 hapusMahasiswa_2511538002(mahasiswaList, scanner);
		 break;
	 case 4 :
		 cariMahasiswa_2511538002(mahasiswaList, scanner);
		 break;
	 case 5:
		 System.out.println("keluar dari program.");
		 break;
		 default :
			 System.out.println("Pilihan tidak valid.");
	 }
	 } while (choice !=5);
	scanner.close();
	}	 
}
	 

	

	
