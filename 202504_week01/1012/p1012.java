import java.util.*;
import java.io.*;

public class p1012 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] cabbage;
    static boolean[][] visit;
    static int cnt = 0;

    static int M;
    static int N;

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();  // 출발지점
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (cabbage[nx][ny] && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cabbage = new boolean[M][N];
            visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                cabbage[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (cabbage[i][j] && !visit[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
}
