package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数的范围 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);
        split = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(reader.readLine());
            int l = bSearchL(nums, k, 0, n - 1);
            if (nums[l]==k){
                int r = l;
                while (r < n && nums[r] == k) r++;
                System.out.println(l + " " + (r-1));
            }else {
                System.out.println("-1 -1");
            }

        }
    }

    private static int bSearchL(int[] nums, int k, int l, int r) {
        if (l >= r) {
            return r;
        }
        int mid = l + r >> 1;
        if (nums[mid] >= k) {
            return bSearchL(nums, k, l, mid);
        } else {
            return bSearchL(nums, k, mid + 1, r);
        }
    }
}
