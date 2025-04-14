import java.io.*;
import java.util.*;

public class p5427 {
    static char[][] board;
    static int[][] sang;
    static int[][] fire;
    static boolean[][] visit;

    static Queue<int[]> sangQueue;
    static Queue<int[]> fireQueue;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int h;
    static int w;

    static long max;
    static String ans;

    public static void fireBfs(int x, int y) {
        fireQueue.offer(new int[]{x, y});
        while (!fireQueue.isEmpty()) {
            int[] now = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (nx > 0 && nx <= w && ny > 0 && ny <= h) {
                    if (board[ny][nx] == '#') continue;
                    // fire이 0이거나 (아직 안간겨) 현재 숫자보다 크다면? 갱신
                    if (fire[ny][nx] == 0 || fire[ny][nx] > fire[now[0]][now[1]] + 1) {
                        fire[ny][nx] += fire[now[0]][now[1]] + 1;
                        fireQueue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void sangBfs(int x, int y) {
        sangQueue.offer(new int[]{x, y});
        visit[x][y] = true;
        boolean check = false;
        while (!sangQueue.isEmpty()) {
            int[] now = sangQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (nx >= 0 && nx <= w+1 && ny >= 0 && ny <= h+1) {
                    // 상근이가 탈출을 못하면 IMPOSSIBLE
                    if (nx == 0 || nx == w+1 || ny == 0 || ny == h+1) {
                        long min = Long.MAX_VALUE;
                        for (int j = 0; j < 4; j++) {
                            int ny2 = ny + dy[j];
                            int nx2 = nx + dx[j];
                            if (nx2 < 0 || nx2 > w+1 || ny2 < 0 || ny2 > h+1) continue;
                            if (visit[ny2][nx2]) {
                                min = Math.min(min, sang[ny2][nx2]);
                            }
                        }
                        min++;
                        ans = String.valueOf(min);
                        check = true;
                        return;
                    }
                    if (board[ny][nx] == '#' || board[ny][nx] == '*'
                        || (fire[ny][nx] != 0 && fire[ny][nx] <= sang[now[0]][now[1]] + 1)) continue;
                    if (sang[ny][nx] == 0 || sang[ny][nx] > sang[now[0]][now[1]] + 1) {
                        sang[ny][nx] += sang[now[0]][now[1]] + 1;
                        visit[ny][nx] = true;
                        sangQueue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        if (!check) ans = "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            board = new char[h+2][w+2];
            sang = new int[h+2][w+2];
            fire = new int[h+2][w+2];
            visit = new boolean[h+2][w+2];

            sangQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();
            for (int i = 1; i <= h; i++) {
                String sentence = br.readLine();
                for (int j = 1; j <= w; j++) {
                    board[i][j] = sentence.charAt(j-1);
                    if (board[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                    } else if (board[i][j] == '@') {
                        sangQueue.offer(new int[]{i, j});
                    }
                }
            }

            // 불 먼저 채워놓기
            // 불 같은 경우 queue에서 꺼내면서
            while (!fireQueue.isEmpty()) {
                int[] fireNow = fireQueue.poll();
                fireBfs(fireNow[0], fireNow[1]);
            }

            // 그 다음 상근이 움직이기
            // 상근이가 없는 경우는 없지 않을까,,
            int[] sangNow = sangQueue.poll();
            sangBfs(sangNow[0], sangNow[1]);

            System.out.println(ans);
            fireQueue.clear();
            sangQueue.clear();
        }
    }
}