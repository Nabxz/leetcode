/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
class TrappingRainWater {

    public static int trap(int[] height) {
        int totalTrappedWater = 0;
        int maxHeightSeenSoFar = 0;
        int[] maxContainerHeightFromLeftSide = new int[height.length];
        int[] maxContainerHeightFromRightSide = new int[height.length];

        // Find max container heights from left side
        for (int i = 0; i < maxContainerHeightFromLeftSide.length; i++) {
            if (height[i] > maxHeightSeenSoFar) {
                maxHeightSeenSoFar = height[i];
            }
            maxContainerHeightFromLeftSide[i] = maxHeightSeenSoFar;
        }

        // Find max container heights from left side
        maxHeightSeenSoFar = 0;
        for (int i = maxContainerHeightFromRightSide.length - 1; i >= 0; i--) {
            if (height[i] > maxHeightSeenSoFar) {
                maxHeightSeenSoFar = height[i];
            }
            maxContainerHeightFromRightSide[i] = maxHeightSeenSoFar;
        }

        // Find trapped water
        for (int i = 0; i < height.length; i++) {
            if (Math.min(maxContainerHeightFromLeftSide[i], maxContainerHeightFromRightSide[i]) - height[i] > 0) {
                totalTrappedWater += Math.min(maxContainerHeightFromLeftSide[i], maxContainerHeightFromRightSide[i]) - height[i];
            }
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 9\nResult: " + trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}));
        System.out.println("\nTest 2:\nExpected: 6\nResult: " + trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
