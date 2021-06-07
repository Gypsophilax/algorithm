package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 多重背包问题 {
    final int c = 1000 * (20);
    List<Integer> v, w;
    int[] dp = new int[c];
    int N, V;

    public static void main(String[] args) throws IOException {
        new 多重背包问题().doSomething();
    }

    private void doSomething() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        v = new ArrayList<>();
        w = new ArrayList<>();

        N = Integer.parseInt(split[0]);
        V = Integer.parseInt(split[1]);
        for (int i = 1; i <= N; i++) {
            int tmp = 1;
            int x, y, z;
            split = reader.readLine().split(" ");
            x = Integer.parseInt(split[0]);
            y = Integer.parseInt(split[1]);
            z = Integer.parseInt(split[2]);
            while (z >= tmp) {
                v.add(x * tmp);
                w.add(y * tmp);
                z -= tmp;
                tmp <<= 1;
            }
            if (z > 0) {
                v.add(x * z);
                w.add(y * z);
            }
        }
        dp();
    }

    private void dp() {
        for (int i = 1; i <= v.size(); i++) {
            for (int j = V; j >= v.get(i - 1); j--) {
                dp[j] = Math.max(dp[j], dp[j - v.get(i - 1)] + w.get(i - 1));
            }
        }
        System.out.println(dp[V]);
    }
}
