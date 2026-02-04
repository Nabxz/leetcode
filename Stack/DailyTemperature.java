/*
* Time Complexity: O()
* Space Complexity: O()
 */

import java.util.Stack;

public class DailyTemperature {

    static Stack<String> operationStack = new Stack<>();

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];

        return results;
    }

    public static void main(String[] args) {
        System.out.print("Test 1:\nExpected: [1,4,1,2,1,0,0]\nResult: [");
        for (int value : dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})) {
            System.out.print(value);
            System.out.print(",");
        }
        System.out.print("]\n\n");

        System.out.print("Test 2:\nExpected: [0,0,0]\nResult: [");
        for (int value : dailyTemperatures(new int[]{22, 21, 20})) {
            System.out.print(value);
            System.out.print(",");
        }
        System.out.print("]\n\n");
    }
}
