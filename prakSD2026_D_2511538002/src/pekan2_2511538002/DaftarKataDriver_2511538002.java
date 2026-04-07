package pekan2_2511538002;

public class DaftarKataDriver_2511538002 {

	public static void main(String[] args) {
		DaftarKata_2511538002 al = new DaftarKata_2511538002();
		
		//menabah elemn(ahir)
		al.tambah("Kami");
		al.tambah("Informatika");
		//Menyesipikan elemen pada indeks 1
		al.tambahPada(1, "Mahasiswa");
		//cetak isi awal 
		System.out.println("Awal    : " + al);
		//mengubah elemen (index 1)
		al.ubahElemen(1, " Departament");
		System.out.println("Setelah Ubah: " + al );
		//menghapus elemen (hapus index 0)
		String terhapus = al.hapusElemen(0);
		System.out.println("Terhapus   : " + terhapus);
		System.out.println("Setelah Hapus: " + al);
		// iteras pada ArrayList(cetak setiap elemen)
		System.out.println("Iterasi: ");
		al.iterasiCetak();
		System.out.println();
		

	}

}
