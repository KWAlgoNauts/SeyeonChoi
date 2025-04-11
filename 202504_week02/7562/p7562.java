import java.util.*;
import java.io.*;

public class p7562 {
    static int[][] board;

    static int n;

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, -2, -1, 1, 2 };

    static int c;
    static int d;
    static int cnt = 0;

    static Queue<int[]> queue;
    static boolean check = false;

    public static void bfs(int x, int y) {
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >=0 && nx < n && ny >= 0 && ny < n) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = board[now[0]][now[1]] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                    if (nx == c && ny == d) {
                        cnt = board[nx][ny];
                        check = true;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            queue = new LinkedList<>();
            check = false;

            n = Integer.parseInt(br.readLine());
            board = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.offer(new int[]{a, b});
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (a==c && b==d) {
                System.out.println(0);
                continue;
            }

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                bfs(now[0], now[1]);
                if (check) break;
            }

            System.out.println(cnt);
        }
    }
}