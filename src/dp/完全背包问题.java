package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 完全背包问题 {
    int[] v, w;
    int[] dp;

    public static void main(String[] args) throws IOException {
        new 完全背包问题().dp();
    }

    private void dp() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int V = Integer.parseInt(split[1]);
        v = new int[N + 1];
        w = new int[N + 1];
        dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            split = reader.readLine().split(" ");
            v[i] = Integer.parseInt(split[0]);
            w[i] = Integer.parseInt(split[1]);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp[V]);

    }
}
