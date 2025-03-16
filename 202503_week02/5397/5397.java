import java.util.*;
import java.io.*;

public class 5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();
            char[] str = new char[s.length()+1];
            LinkedList<Character> ans = new LinkedList<>();
            int cursor = 0;

            for (int i = 0; i < s.length(); i++) {
                str[i] = s.charAt(i);
                if (str[i] == '<') {
                    if (cursor > 0) cursor--;
                }
                else if (str[i] == '-') {
                    if (cursor > 0) {
                        cursor--;
                        ans.remove(cursor);
                    }
                } else if (str[i] == '>') {
                    if (cursor < ans.size()) cursor++;
                } else {
                    ans.add(cursor, str[i]);
                    cursor++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : ans) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}