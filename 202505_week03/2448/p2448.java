import java.io.*;

public class p2448 {
    static char[][] arr;

    public static void recursive(int y, int x, int size) {
        if (size == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = '*';
            arr[y+1][x+1] = '*';
            arr[y+2][x-2] = '*';
            arr[y+2][x-1] = '*';
            arr[y+2][x] = '*';
            arr[y+2][x+1] = '*';
            arr[y+2][x+2] = '*';
        } else {
            int newSize = size/2;
            recursive(y, x, newSize);  // 가장 위 삼각형
            recursive(y + newSize, x-newSize, newSize);  // 아래 왼쪽 삼각형
            recursive(y + newSize, x+newSize, newSize);  // 아래 오른쪽 삼각형
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n*2-1];

        for (int i = 0; i < n; i++) {   // 빈칸으로 채우기
            for (int j = 0; j < n*2-1; j++) {
                arr[i][j] = ' ';
            }
        }

        recursive(0, n-1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2-1; j++) {
                bw.write(arr[i][j]);
            }
            bw.write('\n');
        }
        bw.flush();
    }
}