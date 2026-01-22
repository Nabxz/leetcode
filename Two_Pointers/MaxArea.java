
/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
class MaxArea {

    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int leftPtr = 0;
        int rightPtr = heights.length - 1;

        while (leftPtr < rightPtr) {
            int currArea = (rightPtr - leftPtr) * Math.min(heights[leftPtr], heights[rightPtr]);
            if (currArea > maxArea) {
                maxArea = currArea;
            }

            // Move pointer with smaller value
            if (heights[leftPtr] < heights[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Test\nExpected: 36\nResult: " + maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6}));
    }
}
