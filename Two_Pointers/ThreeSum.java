
import java.util.ArrayList;
import java.util.List;

/*
* Time Complexity: O()
* Space Complexity: O()
 */
class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> allThreeValuesThatAddToZeroWithNoDuplicates = new ArrayList<>();
        int value1Index;
        int value2Index;
        int valueNeeded;
        List<Integer> threeValuesThatAddToZero;
        boolean valueFound;
        boolean containsDuplicate;

        // Check every 2 pairs of numbers for the third value that'd make the three add up to 0
        for (int i = 0; i < nums.length - 1; i++) {

            value1Index = i;
            value2Index = i + 1;
            valueNeeded = -(nums[value1Index]) - (nums[value2Index]);
            threeValuesThatAddToZero = new ArrayList<>();
            valueFound = false;
            containsDuplicate = false;

            // For each needed value, check if it's in the array
            for (int currIndex = 0; currIndex < nums.length && !valueFound; currIndex++) {
                // If we are on the same value we are checking skip, those values can't be reused
                if (currIndex == value1Index || currIndex == value2Index) {
                    continue;
                }

                System.out.println("current: " + nums[currIndex] + ", needed: " + valueNeeded);
                // If the value we need is in the array then add it to the list of values that add up to zero
                if (nums[currIndex] == valueNeeded) {
                    System.out.println("I was called");
                    threeValuesThatAddToZero.add(nums[value1Index]);
                    threeValuesThatAddToZero.add(nums[value2Index]);
                    threeValuesThatAddToZero.add(nums[currIndex]);
                    System.out.println(threeValuesThatAddToZero);
                    valueFound = true;

                    if (allThreeValuesThatAddToZeroWithNoDuplicates.isEmpty()) {
                        allThreeValuesThatAddToZeroWithNoDuplicates.add(threeValuesThatAddToZero);
                    } else {
                        // If the values we found aren't duplicates (already in the list) then add them to the final list
                        for (List<Integer> listInFinalList : allThreeValuesThatAddToZeroWithNoDuplicates) {
                            System.out.println("--> " + listInFinalList);
                            if (threeValuesThatAddToZero.get(0) != null
                                    && listInFinalList.get(0) != null
                                    && threeValuesThatAddToZero.get(0) == listInFinalList.get(0)
                                    && threeValuesThatAddToZero.get(1) == listInFinalList.get(1)
                                    && threeValuesThatAddToZero.get(2) == listInFinalList.get(2)) {
                                System.out.println("is a duplicate");
                                containsDuplicate = true;
                            }

                            if (!containsDuplicate) {
                                System.out.println("i was added");
                                allThreeValuesThatAddToZeroWithNoDuplicates.add(threeValuesThatAddToZero);
                            }
                        }
                    }

                }

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
        System.out.print("]");
    }
}
