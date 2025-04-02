import java.io.*;
import java.util.*;

public class p3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-- > 0) {
            String s = br.readLine();
            if (s.length() % 2 == 1) {  // 문자열 길이 홀수면 그냥 걸러냄
                continue;
            }

            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            stack.push(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (!stack.isEmpty() && stack.peek() == chars[i]) stack.pop();
                else stack.push(chars[i]);
            }
            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}