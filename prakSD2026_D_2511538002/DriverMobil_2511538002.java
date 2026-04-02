package pekan1_2511538002;

import java.util.ArrayList;

public class DriverMobil_2511538002 {

    // List untuk menampung objek mobil
    private ArrayList<mobil_2511538002> daftarMobil = new ArrayList<>();

    // Method Tambah Mobil
    public void tambahMobil(mobil_2511538002 m) {
        daftarMobil.add(m);
        System.out.println("Berhasil menambahkan: " + m.getNama());
    }

    // Method Hapus Mobil
    public void hapusMobil(int index) {
        if (index >= 0 && index < daftarMobil.size()) {
        	mobil_2511538002 removed = daftarMobil.remove(index);
            System.out.println("Berhasil menghapus: " + removed.getNama());
        } else {
            System.out.println("Gagal menghapus: Indeks tidak ditemukan.");
        }
    }

    // Method Tampilkan Semua
    public void tampilkanSemuaMobil() {
        System.out.println("\n--- DAFTAR MOBIL ---");
        for (int i = 0; i < daftarMobil.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMobil.get(i).tampilkanInfo();
        }
    }

    public static void main(String[] args) {
        DriverMobil_2511538002 driver = new DriverMobil_2511538002();

        mobil_2511538002 mobil1 = new mobil_2511538002("Avanza", 2020, 1300, 150000000L, "Toyota");
        mobil_2511538002 mobil2 = new mobil_2511538002("Civic", 2022, 1500, 600000000L, "Honda");

        driver.tambahMobil(mobil1);
        driver.tambahMobil(mobil2);

        driver.tampilkanSemuaMobil();

        mobil1.setHarga(155000000L);
        System.out.println("\n(Update) Harga " + mobil1.getNama() + " diubah.");

        driver.hapusMobil(1);

        driver.tampilkanSemuaMobil();
    }
}
