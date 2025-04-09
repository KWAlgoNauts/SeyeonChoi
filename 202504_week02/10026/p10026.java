import java.util.*;
import java.io.*;

public class p10026 {
    static char[][] ch;
    static boolean[][] visit;  // 적록색약 X 사람
    static int n;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int cnt = 0;

    static Queue<int[]> queue = new LinkedList<>();

    static void bfs(int x, int y) {
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            // 현재 글자 추출 (좌표로)
            char now = ch[queue.peek()[0]][queue.peek()[1]];
            int[] index = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = index[0] + dx[i];  // 상하좌우 다 살펴보기
                int ny = index[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (ch[nx][ny] == now && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new char[n][n];
        visit = new boolean[n][n];

        for (int k = 0; k < 2; k++) {
            if (k == 0) {
                for (int i = 0; i < n; i++) {  // 적록색약 아닌 경우 글자 넣기
                    String s = br.readLine();
                    for (int j = 0; j < n; j++) {
                        ch[i][j] = s.charAt(j);
                    }
                }
            } else {
                // 초기화
                cnt = 0;
                for (int i = 0; i < n; i++) Arrays.fill(visit[i], false);

                for (int i = 0; i < n; i++) {  // 적록색약인 경우 글자 넣기
                    for (int j = 0; j < n; j++) {
                        if (ch[i][j] == 'B') ch[i][j] = 'B';
                        else ch[i][j] = 'R';
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i][0]) {
                    cnt++;
                    bfs(i, 0);
                }
                for (int j = 1; j < n; j++) {
                    if (!visit[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            System.out.print(cnt + " ");
        }
    }
}
