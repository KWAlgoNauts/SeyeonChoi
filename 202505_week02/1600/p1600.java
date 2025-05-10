import java.io.*;
import java.util.*;

public class p1600 {
    static int k;
    static int w;
    static int h;
    static boolean[][] arr;
    static int[][][] visit;
    static int answer;

    static int[] dx = {-1, 0, 1, 0, 2, 1, 2, 1, -2, -1, -2, -1};
    static int[] dy = {0, 1, 0, -1, 1, 2, -1, -2, 1, 2, -1, -2};

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 12; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2];
                if (nx < 0 || ny < 0 || nx >h-1 || ny > w-1) continue;
                // 예외 처리 할 걸 생각해보자...
                // 1. arr==1이라서 못 가는 경우
                // 2. 현재 visit이 원래 visit보다 더 큰 경우
                // i=4부터는 visit[][][k] 업데이트 해야함 +1 하기
                // 단, 같은 턴에서는 k 한번 +1 했으면 더 ++하지 X
                if (nx == h-1 && ny == w-1) {
                    if (i < 4) {
                        visit[nx][ny][nz] = visit[now[0]][now[1]][nz]+1;
                    } else {
                        if (nz>=k) continue;
                        visit[nx][ny][nz+1] = visit[now[0]][now[1]][nz]+1;
                    }
                    return;
                }
                if (arr[nx][ny]) continue;
                if (nz == k && visit[nx][ny][nz] != 0) continue;
                if (i < 4) {
                    if (visit[nx][ny][nz] != 0) continue;
                    visit[nx][ny][nz] = visit[now[0]][now[1]][nz] + 1;
                    queue.add(new int[] {nx, ny, nz});
                }
                if (i >= 4) {
                    if (nz >= k || visit[nx][ny][nz+1] != 0) continue;
                    visit[nx][ny][nz+1] = visit[now[0]][now[1]][nz]+1;
                    queue.add(new int[] {nx, ny, nz+1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new boolean[h][w];
        visit = new int[h][w][k+1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        if (w == 1 && h == 1) {
            if (!arr[0][0]) System.out.println(0);
            else System.out.println(-1);
            return;
        }

        bfs();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visit[h-1][w-1][i] == 0) continue;
            min = Math.min(min, visit[h-1][w-1][i]);
        }
        if (min == Integer.MAX_VALUE) answer = -1;
        else answer = min-1;

        System.out.println(answer);
    }
}
