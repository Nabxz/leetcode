/*
* Time Complexity: O()
* Space Complexity: O()
 */

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {

        record Rectangle(int indexStart, int height) {
        }

        int largestArea = heights[0];
        Stack<Rectangle> validRectangles = new Stack<>();

        // Add the first rectangle in the list
        validRectangles.push(new Rectangle(0, heights[0]));

        for (int index = 1; index < heights.length; index++) {

            // If the height is bigger that's fine, the width will keep expanding,
            // if it's smaller then pop the last entry and calculate the area it made
            if (heights[index] < validRectangles.peek().height) {

                int rectStartIndex = validRectangles.peek().indexStart;
                while (!validRectangles.isEmpty() && heights[index] < validRectangles.peek().height) {
                    Rectangle rect = validRectangles.pop();
                    int area = rect.height * (index - rect.indexStart);
                    rectStartIndex = rect.indexStart;
                    if (area > largestArea) {
                        largestArea = area;
                    }
                }

                // Add the current rectangle
                validRectangles.push(new Rectangle(rectStartIndex, heights[index]));
            } else {
                // Add the current rectangle
                validRectangles.push(new Rectangle(index, heights[index]));
            }
        }

        // Check the area of each rectangle left in the stack
        while (!validRectangles.isEmpty()) {
            Rectangle rect = validRectangles.pop();
            int area = rect.height * (heights.length - rect.indexStart);
            if (area > largestArea) {
                largestArea = area;
            }
        }

        return largestArea;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 8\nResult: " + largestRectangleArea(new int[] { 7, 1, 7, 2, 2, 4 }));
        System.out.println("\nTest 2:\nExpected: 7\nResult: " + largestRectangleArea(new int[] { 1, 3, 7 }));
    }
}
