import java.io.*;

public class 2577 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    long ans = 0;
    int[] arr = new int[10];

    ans = a*b*c;
    String ansStr = String.valueOf(ans);
    for (int i = 0; i < ansStr.length(); i++) {
        arr[Integer.parseInt(String.valueOf(ansStr.charAt(i)))]++;
    }
    for (int ch : arr) {
        System.out.println(ch);
    }
}
}