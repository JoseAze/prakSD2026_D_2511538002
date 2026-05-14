package pekan6_2511538002;
import java.util.Scanner;

public class Musik_2511538002 { 
	
	//pointer awal dan akhir double Linked List
	Lagu_2511538002 head_8002;
	Lagu_2511538002 tail_8002;
	
	//construktor 
	public Musik_2511538002() {
		head_8002 =null;
		tail_8002 = null;
	}
	
	//method menambah lagu di akhir playlist
	public void tambahLagu_8002(String judul_8002, String penyanyi_8002) {
		
		// membuat node lagu baru
		Lagu_2511538002 laguBaru_8002 = new Lagu_2511538002(judul_8002, penyanyi_8002);
		
		// jika playlist masih kosong 
		if (head_8002 == null) { 
			head_8002 = laguBaru_8002;
			tail_8002 = laguBaru_8002;
		} else {
			
			//menghubungkan node baru ke akhir list
			tail_8002.next_8002 = laguBaru_8002;
			laguBaru_8002.prev_8002 = tail_8002;
			
			//memindahkan tail ke node baru
			tail_8002 = laguBaru_8002;
		}
		System.out.println("Lagu berhasil ditambahkan!");
	} 
	
	//method menghapus lagu pertama
	public void hapusLaguAwal_8002() {
		
		//cdk jika playlist kosong
		if(head_8002 == null) {
			System.out.println("Playlist kosong!");
			return;
		}
		
		// jika hanya ada satu lagu
		if(head_8002 == tail_8002) {
			head_8002 = null;
			tail_8002 = null;
		} else {
			
			//pindahkan head ke node berikutnya
		head_8002 = head_8002.next_8002;
		
		// prev pada head baru dibuat null
		head_8002.prev_8002 = null;
		} 
		System.out.println("lagu pertama berhasil dihapus");
	} 
	//method menampilkan playlist dari awal ke akhir
	public void tampilMaju_8002() {
		
		//cek playlist kosong
		if(head_8002 == null) {
			System.out.println("playlist kosong!");
			return;
		} 
		System.out.println("\n===Playlist Maju ===");
		
		//variabel bantu untuk traversal
		Lagu_2511538002 bantu_8002 = head_8002;
		
		//menampilkan data lagu 
		while (bantu_8002 != null){
		System.out.println("judul     : "+
		bantu_8002.getJudul_8002());
		System.out.println("Penanyi   : "+
		bantu_8002.getPenyanyi_8002());
		System.out.println("--------------------");
		
		bantu_8002 = bantu_8002.next_8002;
		}
	}
	
	//method menampilkan playlist dari akhir ke awal
	public void tampilMundur_8002() {
		
		//cek playlist kosong 
		if(tail_8002 == null) {  
			System.out.println("PlayList kosong!");
			return;
		}
			System.out.println("\n====playlist Mudur====");
			//traversal dari tail
			Lagu_2511538002 bantu_8002 = tail_8002;
			while(bantu_8002 != null) {
				System.out.println("judul      :"+
			bantu_8002.getJudul_8002());
				System.out.println("Penyanyi   :"+
			bantu_8002.getPenyanyi_8002());
				System.out.println("----------------------");
				
				bantu_8002 = bantu_8002.prev_8002;
			}
		} 
	
	//method mencari lagu berdasarkan judul
	public void cariLagu_8002(String judulCari_8002) {
		
		//cek playlist kosong
		if(head_8002 == null) {
			System.out.println("Playlist kosong!");
			return;
		}
		Lagu_2511538002 bantu_8002 = head_8002;
		boolean ketemu_8002 = false;
		
		//proses pencarian lagu
		while(bantu_8002 != null) {
			
			//pencarian tidak case-sensitiv
			if(bantu_8002.getJudul_8002()
					.equalsIgnoreCase( judulCari_8002)) {
				
				System.out.println("\nLagu ditemukan!");
				System.out.println("Judul   : "+
				bantu_8002.getJudul_8002());
				System.out.println("Penyanyi : "+
				bantu_8002.getPenyanyi_8002());
				
				ketemu_8002 = true;
				break;
			}
			bantu_8002 = bantu_8002.next_8002;
		}
		//jika lagu tidak ditemukan
		if(!ketemu_8002) {
			System.out.println("Lagu tidak ditemukan!");
		}
	} 
	//program utama
	public static void main(String[] args) {
		Scanner input_8002 = new Scanner(System.in);
		
		//membuat objek playlist
		Musik_2511538002 playlist_8002 =
				new Musik_2511538002();
		
		int pilihan_8002;
		do { 
			//tampilan menu
			System.out.println("\n===playlist Musi NIM: 2511538002");
			System.out.println("1. Tambah Lagu");
			System.out.println("2. Hapus Lagu pertama");
			System.out.println("3. Lihat playlist (Maju)");
			System.out.println("4. Lihat Playlist (Mundur)");
			System.out.println("5. cari Lagu");
			System.out.println("6. Keluar");
			System.out.print("Pilihan : ");
			pilihan_8002=input_8002.nextInt();
			input_8002.nextLine();
			
			switch (pilihan_8002) { 
			
			case 1: 
				// input data lagu
				System.out.print("Judul Lagu : ");
				String judul_8002 = input_8002.nextLine();
				
				System.out.print("penyanyi : ");
				String penyanyi_8002 = input_8002.nextLine();
				
				//tambah lagu
				playlist_8002.tambahLagu_8002(
						judul_8002, penyanyi_8002);
				break;
			case 2: 
				// hapus lagu pertama 
				playlist_8002.hapusLaguAwal_8002();
				break;
				
			case 3: 
				//tampil playlist Maju
				playlist_8002.tampilMaju_8002();
				break; 
				
			case 4:
				// tampil playlist mundur
				playlist_8002.tampilMundur_8002();
				break;
				
			case 5:
				
				//cari lagu
				System.out.println("Masukan judul lagu : ");
				String cari_8002 = input_8002.nextLine();
				
				playlist_8002.cariLagu_8002(cari_8002);
				break;
			case 6:
				System.out.println("program selesai.");
				break;
				
				default: 
					System.out.println("pilihan tidak valid");
					
			}
				
	
		} while (pilihan_8002 !=6); 
		input_8002.close();

	}

}
