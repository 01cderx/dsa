// package backtracking;

// public class backtrack {
//     public static void printPermutation(String str, String permutation, int idx) {
//         if (str.length() == 0) {
//             System.out.println(permutation);    
//             return;
//         }
//         for (int i = 0; i < str.length(); i++) {
//             char currChar = str.charAt(i);
//             String newStr = str.substring(0, i) + str.substring(i+1);
//             printPermutation(newStr, permutation + currChar, idx+1);

//         }
//     }
//     public static void main(String[] args) {
//         String str = "ABC";
//         printPermutation(str, "", 0);
//     }
// }

package backtracking;

// import java.util.ArrayList;
// import java.util.List;

// public class backtrack {

//     public static void main(String[] args) {
//         List<List<String>> allBoards = new ArrayList<>();
//         char[][] board = new board[n][n];

//     }
// }

// public class backtrack {
//     static int N = 4;

//     public static void main(String[] args) {
//         char[][] board = new char[N][N];
//         for (int i = 0; i < N; i++)
//             for (int j = 0; j < N; j++)
//                 board[i][j] = '.';

//         solve(board, 0);
//     }

//     static void solve(char[][] board, int row) {
//         if (row == N) {
//             print(board);
//             return;
//         }

//         for (int col = 0; col < N; col++) {
//             if (isSafe(board, row, col)) {
//                 board[row][col] = 'Q';       // Place queen
//                 solve(board, row + 1);       // Go to next row
//                 board[row][col] = '.';       // Backtrack: Remove queen
//             }
//         }
//     }

//     static boolean isSafe(char[][] board, int row, int col) {
//         // Check column
//         for (int i = 0; i < row; i++)
//             if (board[i][col] == 'Q') return false;

//         // Check left diagonal
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
//             if (board[i][j] == 'Q') return false;

//         // Check right diagonal
//         for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
//             if (board[i][j] == 'Q') return false;

//         return true;
//     }

//     static void print(char[][] board) {
//         for (char[] row : board) {
//             for (char c : row)
//                 System.out.print(c + " ");
//             System.out.println();
//         }
//         System.out.println("--------------");
//     }
// }


    


public class backtrack {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solve(board))
                                return true;

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == ch) return false;
            // Check column
            if (board[i][col] == ch) return false;
            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new backtrack().solveSudoku(board);

        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}






