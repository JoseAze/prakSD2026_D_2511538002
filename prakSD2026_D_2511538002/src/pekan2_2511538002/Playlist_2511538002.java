package pekan2_2511538002; 
import java.util.ArrayList;
import java.util.Scanner;


public class Playlist_2511538002 {

	public static void main(String[] args) {
		
		ArrayList<Musik_2511538002>Playlist = new ArrayList<>();
		Scanner input = new Scanner(System.in); 
		
		int pilihan; 
		
		do { 
			System.out.println("\n=====Playlist Musik NIM: 2311538002======");
			System.out.println("1. Tambah Lagu");
			System.out.println("2. Lihat playlist");
			System.out.println("3. Hapus Lagu");
			System.out.println("4. Cek Jumlah lagu");
			System.out.println("5. Keluar");
			System.out.println("Pilihan: ");
			
			pilihan = input.nextInt();
			input.nextLine();
			
			switch (pilihan) {
			
			case 1: // Tambah Lagu
				
				System.out.println("Masukkan Judul: ");
				String Judul = input.nextLine();
				
				System.out.println("Masukan Penyanyi: ");
				String Penyanyi = input.nextLine();
				  
				System.out.println("Masukan durasi (Detik): ");
				int Durasi = input.nextInt();
				
				Musik_2511538002 laguBaru = new Musik_2511538002(Judul, Penyanyi, Durasi);
				Playlist.add(laguBaru);
				System.out.println("Data berhasil ditambahkan");
				break; 
				
				
			case 2: 
				
				//lihat playlist
				if (Playlist.isEmpty()) { 
					System.out.println("Playlist kosong!");
				} else {
					System.out.println("\n=== Daftar Lagu =="); 
					for (int i = 0; i < Playlist.size(); i++) { 
						Musik_2511538002 lagu = Playlist.get(i);
						System.out.println((i + 1) + ". "+ lagu.getJudul_8002() + " - "+ lagu.getPenyanyi_8002() + " (" + lagu.getDurasi_8002() + " detik)");
						
								
					}
				}
				break;
				
			case 3 : 
				 //hapus lagu
				if (Playlist.isEmpty()) {
					System.out.println("Playlist kosong!");
				}else {
					System.out.println("Masukkan nomor lagu yang ingin dihapus: ");
					int index = input.nextInt();
					if ( index > 0 && index <= Playlist.size()) {
						Playlist.remove(index -1);
						System.out.println("Lagu berhasil dihapus!");
					} else {
						System.out.println("Nomor tidak valid!");
					} 
				}
				break;
				
			case 4:
				// cek jumlah lagu 
				System.out.println("Jumlah Lagu dalam Playlist: " + Playlist.size());
				break;
				
			case 5: 
				System.out.println("Terima kasih! program selesasi."); 
				break;
				
				default:
					System.out.println("Pilihan tidak tersedia!");
					}
				} while (pilihan != 5);
				input.close();
				}
			}
		
 
