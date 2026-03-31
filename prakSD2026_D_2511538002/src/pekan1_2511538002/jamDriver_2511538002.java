package pekan1_2511538002;

public class jamDriver_2511538002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		jam_2511538002 a = new  jam_2511538002(23, 59, 50);
		jam_2511538002 b = new jam_2511538002(0, 0, 15);
		System.out.println("a  		 = "+a);
		System.out.println("b		 = "+b);
		System.out.println("a+b		=" + a.plus(b));
		System.out.println("next  20s  = "+ a.nextNSecond(20));
		System.out.println("durasi (a, b)  = "+jam_2511538002.durasiDetik(a,b));
		System.out.println("a. compareTo (b) =" + a. compareTo(b));
		
		

	}

}
