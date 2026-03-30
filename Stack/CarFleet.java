import java.util.Arrays;
import java.util.Stack;

/*
* Time Complexity: O(nlogn)
* Space Complexity: O(n)
 */
public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {

        // First we sort the cars, so the cars closest to target are last, while storing their speed
        record Car(int carPosition, int carSpeed) implements Comparable<Car>{

            @Override
            public int compareTo(Car otherCar) {
                return this.carPosition - otherCar.carPosition;
            }
        }
        Car[] listOfCars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            listOfCars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(listOfCars);

        // Add last car as a fleet
        Stack<Car> carFleet = new Stack<>();
        carFleet.push(listOfCars[listOfCars.length - 1]);

        for (int i = listOfCars.length - 2; i >= 0; i--) {

            // Calculate when both cars get to target
            float car1ArrivalTime = (float) (target - carFleet.peek().carPosition) / carFleet.peek().carSpeed;
            float car2ArrivalTime = (float) (target - listOfCars[i].carPosition) / listOfCars[i].carSpeed;

            // Add the new car as a fleet
            carFleet.push(listOfCars[i]);

            if (car2ArrivalTime <= car1ArrivalTime) {
                carFleet.pop();
            } 
        }

        return carFleet.size();
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 1\nResult: " + carFleet(10, new int[] {1,4}, new int[] {3,2}));
        System.out.println("\nTest 2:\nExpected: 3\nResult: " + carFleet(10, new int[] {4, 1, 0, 7}, new int[] {2, 2, 1, 1}));
        System.out.println("\nTest 3:\nExpected: 2\nResult: " + carFleet(10, new int[] {6,8}, new int[] {3,2}));
    }
}
