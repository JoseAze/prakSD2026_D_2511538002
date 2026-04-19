package pekan3_2511538002;
import java.util.Scanner;
import java.util.Stack;



public class Browser_2511538002 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Website_2511538002> history = new Stack<>();
		int pilihan;
		
		do {
System.out.println("\n===Browser History NIM: 2511538002 ===");
System.out.println("1. Kunjungi website (Push)");
System.out.println("2. tombol Back (poop)");
System.out.println("3. lihat halaman Aktif(peek)");
System.out.println("4. Cek Status history");
System.out.println("5. Keluar");
System.out.println("pilihan: "); 
pilihan = input.nextInt();
input.nextLine();

switch (pilihan) { 


case 1:
	 // push
	System.out.println("Masukan Judul: ");
	String Judul_8002=input.nextLine();
	
	System.out.println("Masukam Url: ");
	String url_8002 = input.nextLine();
	 
	Website_2511538002 web = new Website_2511538002(Judul_8002, url_8002);
	history.push(web);
	
	System.out.println("Berhasil mengunjungi halaman!");
	break;
	
	
case 2:
	//pop
	if(!history.isEmpty()) {
		Website_2511538002 hapus = history.pop();
		 System.out.println("Kembali dari: " + hapus.getJudul());
	}else {
		System.out.println("History kosong! tidak bisa kembali.");
	} 
	break; 

case 3:
	// peek 
	if (!history.isEmpty()) {
		Website_2511538002 lihat = history.peek();
		System.out.println("Halaman aktif:");
		System.out.println("Judul_8002: " + lihat.getJudul());
		System.out.println("Url: "+ lihat.geturl());
	} else {
		System.out.println("Tidak ada halam aktif:");
	}
break;

	case 4: 
		//status
		if(history.isEmpty()) {
		System.out.println("history kosong.");
} else {
	System.out.println("Jumlah history: "+ history.size());
}
break;

case 5: 
	System.out.println("Keluar dari Program."); 
	break;
	default: 
		System.out.println("Pilihan tidak validi");
		}
	}while (pilihan !=5);
	input.close();	
	}
} 