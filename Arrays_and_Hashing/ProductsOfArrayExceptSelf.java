package Arrays_and_Hashing;

/*
* Time Complexity: O(n^2)
* Space Complexity: O(n^2)
*/
public class ProductsOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    output[i] *= nums[j];
                }
            }
        }
        return output;
    }
}
