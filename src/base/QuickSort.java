package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        nums = new int[n];
        String[] split = reader.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
//        System.out.println("x,l,r: " + x + " " + l + " " + r);
        while (i < j) {
            do i++; while (nums[i] < x); // 如果用while循环的话，还需在swap的时候对 i, j进行处理，这样更优雅
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

            }
        }
        quickSort(l, j);
        quickSort(j + 1, r);
    }
}
