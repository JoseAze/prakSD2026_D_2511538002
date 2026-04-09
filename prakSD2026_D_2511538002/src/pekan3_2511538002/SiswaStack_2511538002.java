package pekan3_2511538002; 
import java.util.ArrayList;
class Siswa {
		String nama;
		int nim;
		 
		public Siswa(String nama, int nim) {
			this.nama = nama;
			this.nim = nim;
		}
		@Override
		public String toString() {
			return "nim: " + nim + ", nama: "+ nama;
		}
		}
		
public class SiswaStack_2511538002 { 
	private ArrayList<Siswa> Stack;
	
	public SiswaStack_2511538002() {
		Stack = new ArrayList<>(); 
		
	}
	 
	public void push(Siswa mhs) { 
		Stack.add(mhs);
	} 
	public Siswa pop() {
		if (!isEmpty()) {
			return Stack.remove(Stack.size() -1);
		}
		return null;
		
		}
	public Siswa peek() { 
		if (! isEmpty()) {
			return Stack.get(Stack.size()-1);
			
		}
		return null; 
	} 
	public boolean isEmpty( ) {
		return Stack.isEmpty();
	}
		public void tampilkanSiswa() {
			for (int i = Stack.size() - 1; i >= 0; i--) {
				System.out.println(Stack.get(i));
			
			}
		}
			
	
	public static void main(String[] args) {
		SiswaStack_2511538002 StudentStack = new SiswaStack_2511538002();
		 
		Siswa mhs1 =new Siswa ("ali", 1); 
		Siswa mhs2 =new Siswa ("Boby", 2);
		Siswa mhs3 =new Siswa ("Charles", 3);
		StudentStack.push(mhs1); 
		StudentStack.push(mhs2);
		StudentStack.push(mhs3); 
		
		System.out.println("Siswa di dalam Stack: ");
		StudentStack.tampilkanSiswa();
		System.out.println("siswa teratas " + StudentStack.peek());
		System.out.println("Mengeluarka siswa teratas dari stack: " + StudentStack.pop());
		StudentStack.tampilkanSiswa();

	}

}
