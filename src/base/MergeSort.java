package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    static int n;
    static int[] nums;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        nums = new int[n];
        tmp = new int[n];
        String[] split = reader.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        final int mid = r + l >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (int m = l, n = 0; m <= r; m++, n++) {
            nums[m] = tmp[n];
        }

    }


}
