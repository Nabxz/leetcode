/*
* Time Complexity: O()
* Space Complexity: O()
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> allThreeValuesThatAddToZeroWithNoDuplicates = new ArrayList<>();

        // Check every 2 pairs of numbers for the third value that'd make the three add up to 0
        for (int i = 0; i < nums.length - 1; i++) {

            int value1Index = i;
            int value2Index = i + 1;
            int valueNeeded = -(nums[value1Index]) -(nums[value2Index]);

            List<Integer> threeValuesThatAddToZero = new ArrayList<>();

            // For each needed value, check if it's in the array
            for(int currIndex = 0; currIndex < nums.length; currIndex++)
            {
                // If we are on the same value we are checking skip, those values can't be reused
                if (currIndex == value1Index || currIndex == value2Index){
                    continue;
                }

                // If the value we need is in the array then add it to the list of values that add up to zero
                if (nums[currIndex] == valueNeeded) {

                    threeValuesThatAddToZero.add(nums[value1Index]);
                    threeValuesThatAddToZero.add(nums[value2Index]);
                    threeValuesThatAddToZero.add(nums[currIndex]);
                }
            }
        }


        return allThreeValuesThatAddToZeroWithNoDuplicates;        
    }
}