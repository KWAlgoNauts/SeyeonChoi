import java.util.*;
import java.io.*;

public class p2206 {
    static int[][] arr;
    static int[][][] visit;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static int cnt;
    static boolean check;

    static Queue<int[]> queue;
    static Queue<int[]> recQueue;  // 벽 부수는 거 알기 위한 queue

    public static void bfs(int x, int y) {
        queue.offer(new int[]{x, y, 0});
        visit[1][1][0] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (visit[nx][ny][nz] != 0) continue;

                    if (nz == 0) {  // 벽을 깨지 않은 경우
                        // 그냥 갈 수 있는 경우
                        if (arr[nx][ny] == 0) {
                            visit[nx][ny][0] = visit[now[0]][now[1]][0] + 1;
                            queue.offer(new int[] {nx, ny, 0});
                        } else if (arr[nx][ny] == 1) { // 벽인데 한 개 부술 수 있는 경우
                            visit[nx][ny][0] = visit[now[0]][now[1]][0] + 1;
                            visit[nx][ny][1] = visit[now[0]][now[1]][1] + 1;
                            recQueue.offer(new int[]{now[0], now[1], 1});
                            queue.offer(new int[] {nx, ny, 1});
                        }
                        // 같은 경우의 수라 부술 수 있는 경우
                        else if (arr[nx][ny] == 1 && recQueue.peek()[0] == now[0]
                                && recQueue.peek()[1] == now[1] && recQueue.peek()[2] == 1) {
                            visit[nx][ny][0] = visit[now[0]][now[1]][0] + 1;
                            visit[nx][ny][1] = visit[now[0]][now[1]][1] + 1;
                            queue.offer(new int[] {nx, ny, 1});
                        }
                    } else if (nz == 1) {
                        if (arr[nx][ny] == 0) {
                            visit[nx][ny][1] = Math.max(visit[now[0]][now[1]][0], visit[now[0]][now[1]][1]) + 1;
                            queue.offer(new int[] {nx, ny, 1});
                        } else if (arr[nx][ny] == 1) {
                            continue;
                        }
                    }
                    if (nx == n && ny == m) {  // 도착한 경우
                        visit[nx][ny][0] = visit[now[0]][now[1]][0] + 1;
                        visit[nx][ny][1] = visit[now[0]][now[1]][1] + 1;
                        cnt = Math.max(visit[nx][ny][0], visit[nx][ny][1]);
                        return;
                    }
                }
            }
        }
        if (queue.isEmpty()) {
            cnt = -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visit = new int[n+1][m+1][2];
        queue = new LinkedList<>();
        recQueue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {  // 일단 입력받고
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
            }
        }

        if (n==1 && m==1) {  // 한 번에 끝나는 경우
            System.out.println(1);
            return;
        }

        cnt = 0;
        bfs(1, 1);

        System.out.println(cnt);
    }
}