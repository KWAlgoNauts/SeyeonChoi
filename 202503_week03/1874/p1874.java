import java.io.*;
import java.util.*;

public class p1874 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        char[] answer = new char[2*n];

        int max = 1;
        int i = 0;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            while (max <= num) {
                s.push(max++);
                answer[i++] = '+';
            }
            if (s.peek() == num) {
                s.pop();
                answer[i++] = '-';
            } else {
                System.out.println("NO");
                return;
            }
        }

        for (char ch : answer) {
            System.out.println(ch);
        }
    }
}