import java.io.*;
import java.util.*;

public class p18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int temp = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("pop")) {
                if (q.isEmpty()) bw.write("-1\n");
                else bw.write(q.poll()+"\n");
            } else if (s.equals("size")) {
                bw.write(q.size()+"\n");
            } else if (s.equals("empty")) {
                if (q.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            } else if (s.equals("front")) {
                if (q.isEmpty()) bw.write(-1+"\n");
                else bw.write(q.peek()+"\n");
            } else if (s.equals("back")) {
                if (q.isEmpty()) bw.write(-1+"\n");
                else bw.write(temp+"\n");
            } else {
                String[] push = s.split(" ");
                q.offer(Integer.valueOf(push[1]));
                temp = Integer.parseInt(push[1]);
            }
        }
        bw.flush();
    }
}