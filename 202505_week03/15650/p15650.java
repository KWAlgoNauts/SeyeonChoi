import java.util.*;
import java.io.*;

public class p15650 {
    static int cnt = 1;
    static boolean[] visit;
    // 이차원 배열로 해서 visit 체크하는 게 나은것 같은데

    static void backTracking(int o, int n, int m) {
        for (int i = o; i <= n; i++) {
            System.out.print(i + " ");  // 1 2
            if (cnt == m) {
                System.out.println();
                if (o < n) o++;
                cnt = 1;
                return;
            }
            cnt++;
            backTracking(++o, n, m);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[m+1];

        backTracking(1, n, m);
    }
}
