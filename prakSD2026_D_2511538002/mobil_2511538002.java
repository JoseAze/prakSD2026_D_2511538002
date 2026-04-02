package pekan1_2511538002;

public class mobil_2511538002 { 
	// Atribut
    private String nama;
    private int tahun;
    private int cc;
    private long harga;
    private String merk;

    // Konstruktor
    public mobil_2511538002(String nama, int tahun, int cc, long harga, String merk) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merk = merk;
    }

    // --- SELEKTOR (Getter) ---
    public String getNama() { return nama; }
    public int getTahun() { return tahun; }
    public int getCc() { return cc; }
    public long getHarga() { return harga; }
    public String getMerk() { return merk; }

    // --- MUTATOR (Setter) ---
    public void setNama(String nama) { this.nama = nama; }
    public void setTahun(int tahun) { this.tahun = tahun; }
    public void setCc(int cc) { this.cc = cc; }
    public void setHarga(long harga) { this.harga = harga; }
    public void setMerk(String merk) { this.merk = merk; }

    // Method untuk menampilkan data mobil
    public void tampilkanInfo() {
        System.out.println("Mobil: " + nama + " [" + merk + "], Tahun: " + tahun + 
                           ", CC: " + cc + ", Harga: Rp" + harga);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
