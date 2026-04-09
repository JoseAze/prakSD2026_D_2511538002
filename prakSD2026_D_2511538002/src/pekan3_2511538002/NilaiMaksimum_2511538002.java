package pekan3_2511538002;

import java.util.Stack;

public class NilaiMaksimum_2511538002 { 

    public static int max_8002(Stack<Integer> s_8002) { 
        
        if (s_8002.isEmpty()) {
            throw new RuntimeException("Stack kosong!");
        }

        Stack<Integer> backup = new Stack<Integer>();
        int maxValue = s_8002.pop();
        backup.push(maxValue);

        while (!s_8002.isEmpty()) { 
            int next = s_8002.pop();
            backup.push(next);
            maxValue = Math.max(maxValue, next);
        }

        // kembalikan isi stack seperti semula
        while (!backup.isEmpty()) {
            s_8002.push(backup.pop());
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Stack<Integer> s_8002 = new Stack<Integer>();

        s_8002.push(70);
        s_8002.push(12);
        s_8002.push(20);

        System.out.println("Isi stack: " + s_8002);
        System.out.println("Stack Teratas: " + s_8002.peek());
        System.out.println("Nilai maksimum: " + max_8002(s_8002));
    }
}
