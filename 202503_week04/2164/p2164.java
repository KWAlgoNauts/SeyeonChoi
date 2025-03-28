import java.io.*;
import java.util.*;

public class p2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (true) {
            if (q.size() == 1) break;
            q.poll();
            if (q.size() == 1) break;
            q.offer(q.poll());
        }

        System.out.println(q.peek());
    }
}