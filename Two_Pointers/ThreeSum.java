/*
* Time Complexity: O()
* Space Complexity: O()
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

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
            valueNeeded = -(nums[value1Index]) -(nums[value2Index]);
            threeValuesThatAddToZero = new ArrayList<>();
            valueFound = false; 
            containsDuplicate = false;

            // For each needed value, check if it's in the array
            for(int currIndex = 0; currIndex < nums.length && !valueFound; currIndex++)
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
                    valueFound = true;

                    // If the values we found aren't duplicates (already in the list) then add them to the final list
                    for (List<Integer> listInFinalList : allThreeValuesThatAddToZeroWithNoDuplicates) {
                        for (int x = 0; x < 3; x++) {
                            if (threeValuesThatAddToZero.get(i) == listInFinalList.get(0)) {containsDuplicate = true;
                            if (threeValuesThatAddToZero.get(i) == listInFinalList.get(1)) {containsDuplicate = true;
                            if (threeValuesThatAddToZero.get(i) == listInFinalList.get(2)) {containsDuplicate = true;}
                        }
                    }

                    if (!containsDuplicate)
                    {
                        allThreeValuesThatAddToZeroWithNoDuplicates.add(threeValuesThatAddToZero);
                    }
                }
            }
        }


        return allThreeValuesThatAddToZeroWithNoDuplicates;        
    }
}