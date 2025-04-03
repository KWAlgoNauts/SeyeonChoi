import java.util.*;
import java.io.*;

public class p10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < ch.length; i++) {
            if (!stack.isEmpty() && stack.peek() != ch[i]) {  // 다르다면
                stack.pop();
                if (!flag) {
                    ans += stack.size();  // 레이저라면 stack 크기만큼 추가
                    flag = true;
                } else ans++;
            } else {  // 같다면
                stack.push(ch[i]);
                flag = false;
            }
        }
        System.out.println(ans);
    }
}