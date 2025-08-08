package Arrays_and_Hashing;

/*
* Time Complexity: O(n^2)
* Space Complexity: O(n^2)
*/
public class ProductsOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
            System.out.println(pref[i]);
        }
        System.out.println();
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
            System.out.println(suff[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
            System.out.println(res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[] { 1, 2, 4, 6 });
    }
}
