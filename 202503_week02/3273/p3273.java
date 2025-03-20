import java.io.*;
import java.util.*;

public class p3273 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] num = new int[n+1];
    boolean[] visit = new boolean[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
        num[i] = Integer.parseInt(st.nextToken());
    }
    int sum = Integer.parseInt(br.readLine());
    int cnt = 0;

    for (int i = 0; i < n-1; i++) {
        if (visit[i]) continue;
        for (int j = i+1; j < n; j++) {
            if (num[i]+num[j] == sum) {
                cnt++;
                visit[j] = true;
                break;
            }
        }
    }

    System.out.println(cnt);
}
}