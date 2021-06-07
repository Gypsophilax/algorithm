package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01背包问题
 */
public class 背包问题 {
    static int[][] dp;
    static int[] d;
    static int[] v;
    static int[] w;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int V = Integer.parseInt(split[1]);
        dp = new int[N + 1][V + 1];
        d = new int[V + 1];
        v = new int[N + 1];
        w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            split = reader.readLine().split(" ");
            v[i] = Integer.parseInt(split[0]);
            w[i] = Integer.parseInt(split[1]);
        }
        doDp(N, V);
        System.out.println(dp[N][V]);

    }

    public static void doDp(int N, int V) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
    }

    public static void doSimpleDp(int N, int V) {
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                if (j >= v[i]) {
                    d[j] = Math.max(d[j], d[j - v[i]] + w[i]);
                }
            }
        }
    }
}
