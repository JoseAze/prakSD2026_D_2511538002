package pekan6_2511538002;

public class Lagu_2511538002 {  
	//atribut lagu
	private String judul_8002;
	private String penyanyi_8002;
	
	//pointer ke node berikutnya dan sebelum
	Lagu_2511538002 next_8002;
	Lagu_2511538002 prev_8002;
	
	//construktor untuk mengisi data lagu
	public Lagu_2511538002(String judul_8002,String penyanyi_8002) {
		this.judul_8002 = judul_8002;
		this.penyanyi_8002 = penyanyi_8002;
		
		//pointer awal bernilai null
		this.next_8002 = null;
		this.prev_8002 = null;
	}
	//getter judul dan penyanyi
	public String getJudul_8002() {
		return judul_8002;
	}
	public String getPenyanyi_8002() {
		return penyanyi_8002;
	}
	//sette judul dan penyannyi
	public void setJudul(String judul_8002) {
		this.judul_8002 =judul_8002;
	}
	public void setPenyanyi(String penyanyi_8002) {
		this.penyanyi_8002 = penyanyi_8002;
	}
	}


