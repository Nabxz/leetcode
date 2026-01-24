
/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
class TrappingRainWater {

    public static int trap(int[] height) {
        int leftPtr = 0;
        int rightPtr = 0;
        int totalTrappedWater = 0;
        int possibleTrappedWater = 0;

        // Move left and right pointer to first non-zero height
        while (leftPtr < height.length && height[leftPtr] == 0) {
            leftPtr++;
            rightPtr++;
        }

        // Find trapped water
        while (rightPtr < height.length - 1) {
            rightPtr++;

            // End of water container and possible start of a new container
            if (height[rightPtr] >= height[leftPtr]) {
                leftPtr = rightPtr;
                totalTrappedWater += possibleTrappedWater;
                possibleTrappedWater = 0;

                // Still accumulating trapped water
            } else {
                possibleTrappedWater += height[leftPtr] - height[rightPtr];
            }
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 9\nResult: " + trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}));
        System.out.println("\nTest 2:\nExpected: 6\nResult: " + trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
