import java.io.*;
import java.util.*;

public class p2573 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] ice;  // 현재 얼음 있는지 없는지
    static boolean[][] visit;  // 현재 방문
    static boolean[][] visited;
    static int cnt;
    static int day;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visit[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!ice[nx][ny] && map[now[0]][now[1]] > 0) {
                        map[now[0]][now[1]]--;
                    } else if (ice[nx][ny] && !visit[nx][ny]) {
                        // 빙산인 경우 큐에 넣기 (다음에 탐색해야하니까)
                        queue.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void count(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 1 && nx < n && ny >= 1 && ny < m) {
                    if (map[nx][ny] > 0 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ice = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) ice[i][j] = true;
            }
        }

        day = 0;
        while (true) {
            cnt = 0;
            visit = new boolean[n][m];  // 매번 초기화
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (ice[i][j] && !visit[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            // ice 갱신해줘야함
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 0) ice[i][j] = false;
                }
            }

            // 빙산 개수 세기
            visited = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (ice[i][j] && !visited[i][j]) {
                        count(i, j);
                        cnt++;
                    }
                }
            }
            if (cnt == 1) day++;
            else if (cnt > 1) {
                day++;
                break;
            } else {  // cnt 0인 경우
                day = 0;
                break;
            }
        }
        System.out.println(day);
    }
}