package pekan7_2511538002;
public class Mahasiswa_2511538002 { 
	//atribut sesuai ketentuan soal
	private String nama_8002;
	private String nim_8002;
	private String prodi_8002;

	//constructor 
	public Mahasiswa_2511538002(String nama_8002, String nim_8002, String prodi_8002) { 
		this.nama_8002 = nama_8002;
		this.nim_8002 = nim_8002;
		this.prodi_8002 = prodi_8002;
	}
	
	//Getter dan SEtter
	public String getNama() { 
		return nama_8002;}
	public void setNama(String nama_8002) {
		this.nama_8002 = nama_8002;}
	public String getNim() {
		return nim_8002;}
	public void setNim(String nim_8002) { 
		this.nim_8002 = nim_8002;}
	public String getProdi() {
		return prodi_8002;}
	//mtehod toString untuk mempermudah cetak nama saat visualisasi
	@Override
	public String toString() {
		return this.nama_8002;	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
