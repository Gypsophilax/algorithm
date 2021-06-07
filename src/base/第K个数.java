package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 第K个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        split = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        quickSort(nums, 0, n - 1, k - 1);
        System.out.println(nums[k - 1]);

    }

    private static void quickSort(int[] n, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int x = n[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (n[i] < x);
            do j--; while (n[j] > x);
            if (i <= j) {
                int tmp = n[i];
                n[i] = n[j];
                n[j] = tmp;
            }
        }
        if (j >= k) {
            quickSort(n, l, j, k);
        } else {
            quickSort(n, j + 1, r, k);
        }

    }
}
