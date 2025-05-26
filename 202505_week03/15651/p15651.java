import java.io.*;
import java.util.StringTokenizer;

public class p15651 {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // false 위치를 잘 해주면 될 것 같음.

    // 현재 k개까지 수를 택했음.
    static void backTracking(int at, int depth) throws IOException{
        if (depth == m) {   // m개의 수를 모두 택했으면
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");  // arr에 기록해둔 수를 출력
            }
            bw.write('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {  // 1부터 시작
            arr[depth] = i;  // k번째 수를 i로 정함
            backTracking(at+1, depth+1);   // 다음 수를 정하러 한 단계 더 들어감
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[8];

        backTracking(0, 0);
        bw.flush();
    }
}
