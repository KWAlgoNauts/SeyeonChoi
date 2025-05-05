import java.util.*;
import java.io.*;

public class p1780 {
    static int[][] paper;
    static int[] cnt;

    static void recursive(int x, int y, int size) {
        int start = paper[x][y];
        boolean ch = false;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (start!=paper[i][j]) {
                    ch = true;
                    break;
                }
            }
        }
        if (!ch) {
            if (start == -1) cnt[0]++;
            else if (start == 0) cnt[1]++;
            else cnt[2]++;
            return;
        }

        int newSize = size/3;
        // 9등분
        recursive(x, y, newSize);
        recursive(x, y+newSize, newSize);
        recursive(x, y+2*newSize, newSize);

        recursive(x+newSize, y, newSize);
        recursive(x+newSize, y+newSize, newSize);
        recursive(x+newSize, y+2*newSize, newSize);

        recursive(x+2*newSize, y, newSize);
        recursive(x+2*newSize, y+newSize, newSize);
        recursive(x+2*newSize, y+2*newSize, newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        cnt = new int[3];

        for (int i = 0; i < n; i++) {  // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0,0, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }
}
