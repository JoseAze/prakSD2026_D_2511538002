package pekan5_2511538002; 
import java.util.Scanner;

public class RumahSakit_2511538002 { 
	static Pasien_2511538002 head_8002 = null;
	static int counter_8002 = 0; 
	
	// insert(daftar pasien)
	public static void insertPasien_8002(String nama_8002, String penyakit_8002) { 
		counter_8002++; 
		Pasien_2511538002 baru = new Pasien_2511538002(nama_8002, penyakit_8002,  counter_8002);
		
		if (head_8002 == null) {
				head_8002 = baru;
			} else { 
				Pasien_2511538002 temp = head_8002;
				while (temp.Next_8002 !=null) {
					temp = temp.Next_8002;
				} 
				temp.Next_8002 = baru;
				}
			System.out.println("pasien berhasil didaftarakan! nomor Antrian: " + counter_8002);
		}
		
		//delete head (panggil pasien)
		public static void panggilPasien_8002() { 
			if (head_8002 == null) {
				System.out.println("Antrian kosong");
				return;
			} 
			System.out.println("memangil pasient");
			System.out.println("Nama: " + head_8002.Pasien_8002);
		    System.out.println("Keluhan: "+ head_8002.Penyakit_8002);
			System.err.println("No Antrian: " + head_8002.Antrian_8002);
			
			head_8002 = head_8002.Next_8002;
		} 
		
		//display
		public static void tampilkan_8002() {
			if (head_8002 == null) {
				System.out.println("Antrian kosong!");
				return;
			}
		
			Pasien_2511538002 temp = head_8002;
			while (temp !=null) {
				System.out.println("No: " + temp.Antrian_8002 + 
				"| Nama: " + temp.Pasien_8002 +
				"| Keluhan: " + temp.Penyakit_8002);
				temp = temp.Next_8002;
			}
		}
		
	
	//SEARCH 
		public static void cariPasien_8002(String Cari_8002) {
			Pasien_2511538002 temp = head_8002;
			boolean ditemukan = false; 
			
			 while (temp != null) {
				 if (temp.Pasien_8002.equalsIgnoreCase(Cari_8002)) { 
					System.out.println("Pasien ditemukan!");
					System.out.println("No: " + temp.Antrian_8002 + 
							" | Nama: " + temp.Pasien_8002 + 
							" | Keluhan: " + temp.Penyakit_8002);
					ditemukan = true;
					break;
				 }
				 temp = temp.Next_8002;
			 } 
			 
			if (!ditemukan) {
				System.out.println("pasien tidak ditemukan!");
			}
		} 
		//cek Status
		public static void cekStatus_8002() {
			if (head_8002 == null) {
				System.out.println("Antrian Kosong!");
				return; 
			}
			int jumlah = 0;
			Pasien_2511538002 temp = head_8002;
			
			while (temp != null) {
				jumlah++;
				temp = temp.Next_8002;
			}
			
			System.out.println("Jumlah pasien : " + jumlah);
			System.out.println("pasien terdepan: " + head_8002.Pasien_8002);
		}
		
		// main menu
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int pilihan;
	
	do {
		System.out.println("\n\n\n=== Antrian Rumah Sakit NIM: 2511538002 ===");
		System.out.println("1. Daftarkan Pasien(Insert)");
		System.out.println("2. Panggil pasien (Delete head)");
		System.out.println("3. Tampilkan Antrian (Display)");
		System.out.println("4. Cari Psien (Search)");
		System.out.println("5. cek Status Antrian");
		System.out.println("6. keluar");
		System.out.print("Pilihan: ");
		pilihan = input.nextInt();
		input.nextLine(); 
		
		switch (pilihan) {
		case 1:
			System.out.print("Masukan Nama Pasien: ");
			String nama = input.nextLine();
			System.out.print("Keluhan: ");
			String keluhan = input.nextLine();
			insertPasien_8002(nama, keluhan);
			break;
			
		case 2:
			panggilPasien_8002();
			break;
			
		case 3:
			tampilkan_8002();
			break;
			
		case 4:
			System.out.print("Masukan Nama: ");
			String cari = input.nextLine();
			cariPasien_8002(cari);
			break;
			 
		case 5:
			cekStatus_8002();
			break;
			
		case 6:
			System.out.println("Terima Kasih!");
			break;
			 
			default: 
				System.out.println("Pilihan Salah!");
		}
	}while (pilihan != 6);
	}
}


