import java.io.*;
import java.util.*;

public class p2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int temp = 0;
        int ans = 0;
        boolean flag = false;  // 더할지 말지 결정

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
                if (temp == 0) temp += 2;
                else temp *= 2;
                flag = false;
            } else if (ch[i] == '[') {
                stack.push(ch[i]);
                if (temp == 0) temp += 3;
                else temp *= 3;
                flag = false;
            } else if (ch[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    if (!flag) {
                        ans += temp;
                        flag = true;
                    }
                    temp /= 2;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    if (!flag) {
                        ans += temp;
                        flag = true;
                    }
                    temp /= 3;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}