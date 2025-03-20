import java.io.*;
import java.util.*;

public class p10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int sum = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                s.pop();
            } else {
                s.push(num);
            }
        }

        for (int value : s) {
            sum += value;
        }

        System.out.println(sum);
    }
}