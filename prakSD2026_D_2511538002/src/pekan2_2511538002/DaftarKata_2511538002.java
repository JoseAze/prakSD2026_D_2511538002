package pekan2_2511538002;
import java.util.ArrayList;
public class DaftarKata_2511538002 { 
	private final ArrayList<String> data;
	// konstruktor: inisialisai list kosong 
	public DaftarKata_2511538002() { 
		this.data = new ArrayList<>();
	} 
	 /** menabahkan elemen di akhir list. */
	public void tambah(String elemen) { 
		data.add(elemen);
	}
	/** menabahkan elemen pada indeks tertentu (menyisipkan). */
	public void tambahPada (int index, String elemen) {
	} 
	/** 
	 * mengubah elemen pada posisi 'index' menjadi 'nilaiBaru'.
	 * bertidak sebagai "setter" untuk elemen tertentu.
	 */
	public void ubahElemen(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	} 
	/** 
	 * menghPUA elemen pada posisi 'index' dan mengembalikan nilai yang dihapus.
	 */
	public String hapusElemen(int index) {
		return data.remove(index); 
	} 
	/** 
	 * Melakukan iterasi dan mencetak setiap elemen dalam format: [index] nilai
	 * (metode ini tidak mengambalikan nilai; hanya demostrasi iterasi).
	 */
	public void iterasiCetak() {
		for (int i = 0; i<data.size(); i++) { 
			System.out.println(data.get(i)+" ");
			
		}
	} 
	/** mengambil elemen berdasarkan indeks. */
	public String get(int index) { 
		return data.get(index);
	}
	//Representasi string agar mudah dicetak
	@Override 
	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
