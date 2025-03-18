import java.io.*;
import java.util.*;

public class 1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[n+1];
        int[] num = new int[n+1];
        int cursor = 0;
        for (int i = 0; i < n; i++) {
            int temp = m;
            while (temp-- > 0) {
                cursor++;
                if (cursor > n) {
                    cursor = 1;
                    if (visit[cursor]) temp++;
                } else {
                    if (visit[cursor]) temp++;
                }
            }
            visit[cursor] = true;
            num[i] = cursor;
        }

        System.out.print('<');
        for (int i = 0; i < n; i++) {
            System.out.print(num[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.print('>');
    }
}