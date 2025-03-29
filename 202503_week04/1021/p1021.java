import java.io.*;
import java.util.*;

public class p1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int min = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < M; i++) {
            int temp_left = 0;
            int temp_right = 0;
            if (dq.peek() - arr[i] == 0) {
                dq.poll();
                continue;
            }
            while (dq.peek() - arr[i] != 0) {
                dq.offer(dq.poll());
                temp_left++;
            }
            for (int j = 0; j < temp_left; j++) {
                dq.offerFirst(dq.pollLast());
            }

            while (dq.peek() - arr[i] != 0) {
                dq.offerFirst(dq.pollLast());
                temp_right++;
            }

            dq.poll();
            cnt += Math.min(temp_left, temp_right);
        }

        System.out.println(cnt);
    }
}