import java.io.*;

public class p1992 {
    static int[][] arr;
    static int n;

    static void recursive (int x, int y, int size) {
        int start = arr[x][y];
        String temp = "";

        boolean check = false;
        if (size == 2) {
            for (int i = x; i < x+size; i++) {
                for (int j = y; j < y+size; j++) {
                    if (start != arr[i][j]) check = true;
                    temp += arr[i][j];
                }
            }
            if (check) System.out.print("(" + temp + ")");
            else System.out.print(start);

        } else {
            for (int i = x; i < x+size; i++) {
                for (int j = y; j < y+size; j++) {
                    if (start != arr[i][j]) {
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }

            if (check) {  // 달라서 분할 해야하는 경우
                int newSize = size/2;
                System.out.print("(");
                recursive(x, y, newSize);
                recursive(x, y+newSize, newSize);
                recursive(x+newSize, y, newSize);
                recursive(x+newSize, y+newSize, newSize);
                System.out.print(")");
            } else {
                System.out.print(start);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }

        recursive(0, 0, n);
    }
}
