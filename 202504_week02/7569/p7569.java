import java.util.*;
import java.io.*;

public class p7569 {
    static int[][][] box;
    static int M;
    static int N;
    static int H;

    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    static Queue<int[]> queue;

    public static void bfs(int x, int y, int z) {
        queue.offer(new int[]{x, y, z});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now[2] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[0] + dz[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[now[0]][now[1]][now[2]] + 1;  // 오늘 날짜에 +1
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) queue.offer(new int[]{i, j, k});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            bfs(now[0], now[1], now[2]);
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[i][j][k]);
                }
            }
        }
        System.out.println(answer-1);
    }
}
