import java.util.*;
import java.io.*;

public class p2630 {
    static int n;
    static int[][] color;
    static int white;
    static int blue;

    static void recursive(int x, int y, int size) {
        int start = color[x][y];
        boolean cut = false;
        for (int i = x ; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (start != color[i][j]) {
                    cut = true;
                    break;
                }
            }
            if (cut) break;
        }

        if (cut) {
            int newSize = size/2;
            recursive(x, y, newSize);
            recursive(x, y+newSize, newSize);
            recursive(x+newSize, y, newSize);
            recursive(x+newSize, y+newSize, newSize);
        } else {
            if (start == 0) white++;
            else blue++;
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        color = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;
        recursive(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }
}
