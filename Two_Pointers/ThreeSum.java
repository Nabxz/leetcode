
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time Complexity: O(n^2)
* Space Complexity: O(1)
 */
class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        int a = 0;
        int b;
        int c;
        List<List<Integer>> allThreeValuesThatAddToZeroWithNoDuplicates = new ArrayList<>();

        // Sorting input array
        Arrays.sort(nums);

        while (a + 2 < nums.length) {

            b = a + 1;
            c = nums.length - 1;

            while (b < c) {

                if (nums[a] + nums[b] + nums[c] > 0) {
                    // move c to the left and ignore duplicates
                    do {
                        c--;
                    } while (c > 0 && nums[c] == nums[c + 1]);
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    // move b to the right and ignore duplicates
                    do {
                        b++;
                    } while (b < nums.length && nums[b] == nums[b - 1]);
                } else {
                    // Adding the three numbers equals to zero
                    List<Integer> threeValuesThatAddToZero = new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c]));
                    allThreeValuesThatAddToZeroWithNoDuplicates.add(threeValuesThatAddToZero);
                    do {
                        b++;
                    } while (b < nums.length && nums[b] == nums[b - 1]);
                }
            }

            // Move to next a and ignore dusplicates
            a++;
            while (nums[a] == nums[a - 1] && a + 2 < nums.length) {
                a++;
            }
        }

        return allThreeValuesThatAddToZeroWithNoDuplicates;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.print("Test 1:\nExpected: [[-1,-1,2],[-1,0,1]]\nResult: [");
        for (List<Integer> list : result) {
            System.out.print(list);
            System.out.print(",");
        }
        System.out.print("]\n\n");

        List<List<Integer>> result2 = threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
        System.out.print("Test 2:\nExpected: [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]\nResult: [");
        for (List<Integer> list : result2) {
            System.out.print(list);
            System.out.print(",");
        }
        System.out.print("]\n\n");

        List<List<Integer>> result3 = threeSum(new int[]{0, 0, 0});
        System.out.print("Test 3:\nExpected: [[0,0,0]]\nResult: [");
        for (List<Integer> list : result3) {
            System.out.print(list);
            System.out.print(",");
        }
        System.out.print("]");
    }
}
