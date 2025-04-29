import java.io.*;
import java.util.*;

public class p9466 {
    static int[] arr;
    static boolean[] visit;
    static boolean[] finished;

    static int cnt;

    static void dfs(int cur) {
        visit[cur] = true;
        int next = arr[cur];
        if (!visit[next]) {  // 아직 방문하지 않았다면
            dfs(next);
        } else {  // 이미 방문했다면
            if (!finished[next]) {  // 완성은 안됐을때
                cnt++;
                while (next != cur) {  // 다음 노드로 넘어감
                    cnt++;
                    next = arr[next];
                }
            }
        }
        finished[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];  // 방문 여부
            finished = new boolean[n+1];  // 탐색 종료 여부
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {  // 입력
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) dfs(i);
            }
            System.out.println(n-cnt);
        }
    }
}
