import java.util.*;
import java.io.*;

public class p15650 {
    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void backTracking(int at, int depth) throws IOException{
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            if (depth > 0 && arr[depth - 1] >= arr[depth]) continue;
            backTracking(at++, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[8];

        backTracking(1, 0);

        bw.flush();
    }
}
