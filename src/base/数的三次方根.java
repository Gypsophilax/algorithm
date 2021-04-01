package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数的三次方根 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(reader.readLine());
        double v = bSearch(n, -100.0, 100.0);
        System.out.println(String.format("%.6f",v));

    }

    private static double bSearch(double n, double l, double r) {

        while (r - l > 1e-8) {
            double mid = (r + l) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }
}
