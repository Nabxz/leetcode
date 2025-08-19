package Arrays_and_Hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
* Time Complexity: O(n^2)
* Space Complexity: O(n)
*/
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {

        int longestConsecutive = 0;
        HashMap<Integer, ArrayList<Integer>> consecutiveNumberMap = new HashMap<>();
        for (int number : nums) {

            boolean foundPosition = false;
            boolean foundPrevious = consecutiveNumberMap.containsKey(number - 1);
            boolean foundAfter = consecutiveNumberMap.containsKey(number + 1);

            // If it's a duplicate do nothing
            if (!consecutiveNumberMap.containsKey(number)) {

                if (foundPrevious && foundAfter) {
                    // Contains both, combine both and delete bigger key
                    consecutiveNumberMap.get(number - 1).add(number);
                    consecutiveNumberMap.get(number - 1).addAll(consecutiveNumberMap.get(number + 1));
                    consecutiveNumberMap.remove(number + 1);
                    foundPosition = true;

                    if (consecutiveNumberMap.get(number - 1).size() > longestConsecutive) {
                        longestConsecutive = consecutiveNumberMap.get(number - 1).size();
                    }

                } else {
                    // Check values list to see if it belongs any where, if not add to key
                    for (int key : consecutiveNumberMap.keySet()) {
                        // If it's a duplicate do nothing
                        if (consecutiveNumberMap.get(key).contains(number)) {
                            foundPosition = true;
                            // If we found it in this key no need to search values list
                        } else if (!((foundPrevious && key == number - 1) || (foundAfter && key == number + 1))) {
                            if (consecutiveNumberMap.get(key).contains(number - 1)
                                    || consecutiveNumberMap.get(key).contains(number + 1)) {

                                // If found in values list & is a key then combine both and delete bigger
                                if (foundPrevious) {
                                    consecutiveNumberMap.get(number - 1).add(number);
                                    consecutiveNumberMap.get(number - 1).addAll(consecutiveNumberMap.get(key));
                                    consecutiveNumberMap.remove(key);

                                    if (consecutiveNumberMap.get(number - 1).size() > longestConsecutive) {
                                        longestConsecutive = consecutiveNumberMap.get(number - 1).size();
                                    }

                                    foundPosition = true;

                                } else if (foundAfter) {
                                    consecutiveNumberMap.get(number + 1).add(number);
                                    consecutiveNumberMap.get(number + 1).addAll(consecutiveNumberMap.get(key));
                                    consecutiveNumberMap.remove(key);

                                    if (consecutiveNumberMap.get(number + 1).size() > longestConsecutive) {
                                        longestConsecutive = consecutiveNumberMap.get(number + 1).size();
                                    }

                                    foundPosition = true;

                                } else {
                                    consecutiveNumberMap.get(key).add(number);

                                    if (consecutiveNumberMap.get(key).size() > longestConsecutive) {
                                        longestConsecutive = consecutiveNumberMap.get(key).size();
                                    }

                                    foundPosition = true;
                                }

                            }
                        }

                        // Leave early if it does belong in the list
                        if (foundPosition) {
                            break;
                        }
                    }

                }

                if (!foundPosition) {
                    if (foundPrevious && foundAfter) {
                        // Contains both, delete bigger key
                        consecutiveNumberMap.get(number - 1).add(number);
                        consecutiveNumberMap.get(number - 1).addAll(consecutiveNumberMap.get(number + 1));
                        consecutiveNumberMap.remove(number + 1);

                        if (consecutiveNumberMap.get(number - 1).size() > longestConsecutive) {
                            longestConsecutive = consecutiveNumberMap.get(number - 1).size();
                        }

                    } else if (foundPrevious) {
                        consecutiveNumberMap.get(number - 1).add(number);

                        if (consecutiveNumberMap.get(number - 1).size() > longestConsecutive) {
                            longestConsecutive = consecutiveNumberMap.get(number - 1).size();
                        }

                    } else if (foundAfter) {
                        consecutiveNumberMap.get(number + 1).add(number);

                        if (consecutiveNumberMap.get(number + 1).size() > longestConsecutive) {
                            longestConsecutive = consecutiveNumberMap.get(number + 1).size();
                        }

                    } else {
                        ArrayList<Integer> valuesArray = new ArrayList<>();
                        valuesArray.add(number);
                        consecutiveNumberMap.put(number, valuesArray);

                        if (consecutiveNumberMap.get(number).size() > longestConsecutive) {
                            longestConsecutive = consecutiveNumberMap.get(number).size();
                        }

                    }
                }

            }
        }

        return longestConsecutive;
    }

    public static void main(String[] args) {
        int[] test = { 2, 20, 4, 10, 3, 4, 5 };
        System.out.println("Test 1:\nExpected: 4\nResult: " +
                longestConsecutive(test));
        int[] test2 = { 0, 3, 2, 5, 4, 6, 1, 1 };
        System.out.println("\nTest 2:\nExpected: 7\nResult: " +
                longestConsecutive(test2));
        int[] test3 = { 0 };
        System.out.println("\nTest 3:\nExpected: 1\nResult: " +
                longestConsecutive(test3));
        int[] test4 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("\nTest 4:\nExpected: 9\nResult: " +
                longestConsecutive(test4));
    }
}
