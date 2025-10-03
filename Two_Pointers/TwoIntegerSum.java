/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class TwoIntegerSum {

    public static int[] twoSum(int[] numbers, int target) {

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        boolean targetFound = false;

        while (leftIndex < rightIndex && !targetFound) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                targetFound = true;
            } else if (numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex++;
            } else if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            }
        }

        return new int[]{leftIndex + 1, rightIndex + 1};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[] {2, 3, 5}, 5);
        System.out.println("Test 1:\nExpected: [1,2]\nResult: [" + result[0] + "," + result[1] + "]");
    }
}
