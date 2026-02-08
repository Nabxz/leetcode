/*
* Time Complexity: O(n)
* Space Complexity: O(n)
 */

import java.util.Stack;

public class DailyTemperature {

    private static class TemperatureReading{

        int temperature;
        int indexOfTemperature;

        public TemperatureReading(int temperature, int indexOfTemperature) {
            this.temperature = temperature;
            this.indexOfTemperature = indexOfTemperature;
        }
        
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<TemperatureReading> temperatureStack = new Stack<>();
        int[] results = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            // Keep the stack in monotonic decreasing order
            if (temperatureStack.isEmpty() || temperatures[i] <= temperatureStack.peek().temperature) {

                temperatureStack.push(new TemperatureReading(temperatures[i], i));
            
            } else { // We found a bigger number, update results array

                // Mantain monotonic order while computing results
                while (!temperatureStack.isEmpty() && temperatures[i] > temperatureStack.peek().temperature) {
                    TemperatureReading temperatureSolvedFor = temperatureStack.pop();
                    results[temperatureSolvedFor.indexOfTemperature] = i - temperatureSolvedFor.indexOfTemperature;
                }
                temperatureStack.push(new TemperatureReading(temperatures[i], i));
            }
        }

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
