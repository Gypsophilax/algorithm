package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 逆序对数 {
    static long count;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        tmp = new int[n];
        String[] split = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        mergeSort(nums, 0, n - 1);
        System.out.println(count);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int m = l, n = mid + 1, i = 0;
        while (m <= mid && n <= r) {
            if (nums[m] <= nums[n]) {
                tmp[i++] = nums[m++];
            } else {

                count += mid - m + 1;
                tmp[i++] = nums[n++];
            }
        }
        while (m <= mid) {
            tmp[i++] = nums[m++];
        }
        while (n <= r) {
            tmp[i++] = nums[n++];
        }
        for (int j = l, k = 0; j <= r; j++, k++) {
            nums[j] = tmp[k];
        }

    }
}
