import java.io.*;

public class 1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] num = new int[10];
        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            num[Integer.parseInt(String.valueOf(n.charAt(i)))]++;
        }
        if ((num[6]+num[9]) % 2 == 1) {
            num[6] = (num[6] + num[9])/2 + 1;
        } else {
            num[6] = (num[6] + num[9])/2;
        }
        num[9] = 0;
        for (int i = 0; i < 10; i++) {
            if (ans < num[i]) {
                ans = num[i];
            }
        }
        System.out.println(ans);
    }
}