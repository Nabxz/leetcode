package Arrays_and_Hashing;

import java.util.HashSet;

/*
* Time Complexity: O(n^2) / O(1)
* Space Complexity: O(n) / O(1)
*/
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {

        // We use isValid to break out of our loops early
        boolean isValid = true;

        // Note
        // empty spots are sent in as a '.' character, we must
        // account for this when counting the set
        int numOfEmptySpots = 0;

        // If each row, column and 3x3 has a size of 9
        // in a hash set then we are valid
        HashSet<Character> sudokuAxisChecker = new HashSet<>();

        // Checking columns
        for (int row = 0; isValid && row < board.length; row++) {
            for (int col = 0; isValid && col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    isValid = sudokuAxisChecker.add(board[row][col]);
                } else {
                    numOfEmptySpots++;
                }
            }

            if (sudokuAxisChecker.size() + numOfEmptySpots != 9) {
                return false;
            }
            numOfEmptySpots = 0;
            sudokuAxisChecker.clear();
        }

        // Checking rows
        for (int row = 0; isValid && row < board.length; row++) {
            for (int col = 0; isValid && col < board[row].length; col++) {
                if (board[col][row] != '.') {
                    isValid = sudokuAxisChecker.add(board[col][row]);
                } else {
                    numOfEmptySpots++;
                }
            }

            if (sudokuAxisChecker.size() + numOfEmptySpots != 9) {
                return false;
            }
            numOfEmptySpots = 0;
            sudokuAxisChecker.clear();
        }

        // Checking each 3x3
        int currRow = 0;
        int currCol = 0;
        int currentColResetFrom = 0;
        int currentRowLimit = 3;
        int currentColLimit = 3;
        while (isValid && currRow < currentRowLimit) {
            while (isValid && currCol < currentColLimit) {
                if (board[currRow][currCol] != '.') {
                    isValid = sudokuAxisChecker.add(board[currRow][currCol]);
                } else {
                    numOfEmptySpots++;
                }
                currCol++;
            }
            currCol = currentColResetFrom;

            // If we are moving to next 3x3 grid
            if (currRow == currentRowLimit - 1) {

                if (sudokuAxisChecker.size() + numOfEmptySpots != 9) {
                    return false;
                }
                sudokuAxisChecker.clear();

                // If it's still valid we move to next grid, if there's a next grid
                if (currentRowLimit + 3 <= 9) {
                    currentRowLimit += 3;
                    numOfEmptySpots = 0;
                } else if (currentColLimit + 3 <= 9) {

                    currentColResetFrom += 3;
                    currCol = currentColResetFrom;
                    currentColLimit += 3;
                    currRow = -1;
                    currentRowLimit = 3;
                    numOfEmptySpots = 0;
                }
            }

            currRow++;
        }

        return isValid;
    }

    public static void main(String[] args) {
        System.out.print("Expected: true\nResult: ");
        System.out.println(isValidSudoku(new char[][] {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));

        System.out.print("\nExpected: false\nResult: ");
        System.out.println(isValidSudoku(new char[][] {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '1', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));

        System.out.print("\nExpected: false\nResult: ");
        System.out.println(isValidSudoku(new char[][] {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }
        }));
    }
}
