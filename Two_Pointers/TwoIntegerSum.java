/*
* Time Complexity: O()
* Space Complexity: O()
*/
public class TwoIntegerSum {
  public int[] twoSum(int[] numbers, int target) {
        
        int leftIndex = 0;
        int rightIndex = numbers.length;
        boolean targetFound = false;

        while (leftIndex < rightIndex && !targetFound) {
          if (numbers[left] + numbers[right] == target) {
            targetFound = true;
          } else if (numbers[left] + numbers[right] < target) {
            leftIndex++;
          } else if (numbers[left] + numbers[right] > target) {
            rightIndex--;
          }
        }

        return new int[] {leftIndex, rightIndex};
    }
}

