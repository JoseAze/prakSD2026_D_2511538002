package pekan2_2511538002;

public class Mahasiswa_2511538002 {
	String nim;
	String nama;
	String prodi;
	Mahasiswa_2511538002(String nim, String nama, String prodi) {
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi; 
	}
	@Override  
	public String toString() {
		return "Nim: " + nim + ", nama : " + nama + ", prodi :" + prodi;
		}

	}


