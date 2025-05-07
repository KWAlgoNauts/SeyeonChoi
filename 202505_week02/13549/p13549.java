import java.io.*;
import java.util.*;

public class p13549 {
    static int answer;

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] visit = new int[100001];
        queue.add(new int[]{x, 1});
        visit[x] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] +1 <= 100000 && (visit[now[0]+1] == 0 || visit[now[0]+1] > now[1]+1)) {
                queue.add(new int[]{now[0]+1, now[1]+1});
                visit[now[0]+1] = now[1]+1;
            }

            if (now[0] > 0 && (visit[now[0]-1] == 0 || visit[now[0]-1] > now[1]+1)) {
                queue.add(new int[]{now[0]-1, now[1]+1});
                visit[now[0]-1] = now[1]+1;
            }

            if (now[0] > 0 && now[0]*2 <= 100000 && (visit[now[0]*2] == 0 || visit[now[0]*2] > now[1])) {
                queue.add(new int[]{now[0]*2, now[1]});
                visit[now[0]*2] = now[1];
            }
        }
        answer = visit[y]-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {  // 수빈이와 동생의 위치가 같은 경우 끝
            System.out.println(0);
            return;
        }

        bfs(n, k);

        System.out.println(answer);
    }
}
