package pekan5_2511538002;

public class Pasien_2511538002 { 
	String Pasien_8002;
	String Penyakit_8002;
	int Antrian_8002;
	Pasien_2511538002 Next_8002; 
	
	//construktor 
	public Pasien_2511538002(String Pasien_8002, String Penyakit_8002,int Antrian_8002){
		this.Pasien_8002 = Pasien_8002;
		this.Penyakit_8002 = Penyakit_8002;
		this.Antrian_8002 = Antrian_8002;
		this.Next_8002 = null; 
	} 
	 // getter
	public String getPasien_8002() { 
		return Pasien_8002; 
	} 
	public String getPenyakit_8002() {
		return Penyakit_8002;
	}
	public int getAntrian_8002() {
		return Antrian_8002; 
	}
	public Pasien_2511538002 getNext_8002() { 
		return Next_8002;
	}  
	// setter
	public void setNext_8002(Pasien_2511538002 Next_8002) {
		this.Next_8002 = Next_8002;
	}
	}


 