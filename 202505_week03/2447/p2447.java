import java.io.*;

public class p2447 {
    static char[][] arr;
    public static void recursive(int x, int y, int size) {
        if (size == 3) {
            for (int i = x; i < x+size; i++) {
                for (int j = y; j < y+size; j++) {
                    arr[i][j] = '*';
                    if (i == x+1 && j == y+1) {
                        arr[i][j] = ' ';
                    }
                }
            }
        } else {
            int newSize = size/3;
            recursive(x, y, newSize);
            recursive(x, y+newSize, newSize);
            recursive(x, y+newSize*2, newSize);
            recursive(x+newSize, y, newSize);
            blank(x+newSize, y+newSize, newSize);
            recursive(x+newSize, y+newSize*2, newSize);
            recursive(x+newSize*2, y, newSize);
            recursive(x+newSize*2, y+newSize, newSize);
            recursive(x+newSize*2, y+newSize*2, newSize);
        }
    }

    public static void blank(int x, int y, int size) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        recursive(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
