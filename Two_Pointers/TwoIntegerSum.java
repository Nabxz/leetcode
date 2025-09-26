/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class TwoIntegerSum {

    public int[] twoSum(int[] numbers, int target) {

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
}
