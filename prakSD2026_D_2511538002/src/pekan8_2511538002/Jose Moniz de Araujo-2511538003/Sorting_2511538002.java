package pekan8_2511538002;
public class Sorting_2511538002 { 
	
		Lagu_2511538002[] datalagu_8002 = new Lagu_2511538002[20];
		int jumlahData_8002 = 0;
		public void inputData_8002() { 
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("Mio Cristo painge Diamanti", "penyanyi A", 270); 
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("La Rumba Del perdon", "penany B", 252);
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("La Perla", "penyanyi C", 196);
			
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("perfect", "Ed Sheeran", 263);
			
			datalagu_8002[jumlahData_8002++] =
					new Lagu_2511538002("photograh", "Ed Sheeran", 258);
					
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("Memories", "Maroon 5", 189); 
			
			datalagu_8002[jumlahData_8002++] = 
					new Lagu_2511538002("counting Stars", "OneRepublic", 257);
		} 
		//method untuk menampilkan seluruh data lagu
		
		public void tampilData_8002() {
			
			for (int i =0; i<jumlahData_8002; i++) {
				
				System.out.println( 
						(i+1)+ ". " 
				+ datalagu_8002[i].judul_8002 
				+ " - " 
				+ datalagu_8002[i].durasi_8002
				+ " detik");
				
			} 
		}  
		// method utama quick Sort
		public void quickSort_8002(int low, int high) { 
			if (low < high) {
				int pi = partition_8002(low, high);
				quickSort_8002(low, pi -1);
				quickSort_8002(pi + 1, high);
			}
		} 
		public int partition_8002(int low, int high) {
			int pivot = datalagu_8002[high].durasi_8002;
			int i = low -1;
			for (int j = low; j < high; j++) { 
				if (datalagu_8002[j].durasi_8002 < pivot) { 
					
					i++;
					
					// tukar data 
					Lagu_2511538002 temp = datalagu_8002[i +1];
					datalagu_8002[i + 1] = datalagu_8002[high];
					datalagu_8002[high] = temp;
						
				}
			} 
			//menempatkan pivot ke posisi yang benar
			Lagu_2511538002 temp = datalagu_8002[i + 1];
			datalagu_8002[i + 1] = datalagu_8002[high];
			datalagu_8002[high] = temp;
			
			// mengembalikan index pivot
			return i + 1;
		} 
		
		// progrma utama
		
		public static void main(String[] args) {
			
			// membuat objek palylist
			Sorting_2511538002 playlist_8002 =
					new Sorting_2511538002();
			
			// mengisi data lagu
			playlist_8002.inputData_8002();  
			 System.out.println("=== Sorting Playlist NIM: 2511538002 ===");
			    System.out.println("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): 2"); 
			    
			System.out.println("\n=== Data Sebelum Sorting ===");
			playlist_8002.tampilData_8002();
			 
			// menjalankan quick Sort
			playlist_8002.quickSort_8002(
					0, playlist_8002.jumlahData_8002 - 1);
			
			//menampilkan data setelah sorting
			System.out.println("\n === data setelah quick Sort (durasi Ascending) ===");
			playlist_8002.tampilData_8002();
		}

	}


	
