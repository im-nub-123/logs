import java.util.*;

public class NQueens {

    // Check whether queen placement is safe
    static boolean isSafe(int row,
                          int col,
                          char[][] board,
                          int n) {

        int dupRow = row;
        int dupCol = col;

        // Upper diagonal check
        while (row >= 0 && col >= 0) {

            if (board[row][col] == 'Q') {
                return false;
            }

            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Left side check
        while (col >= 0) {

            if (board[row][col] == 'Q') {
                return false;
            }

            col--;
        }

        row = dupRow;
        col = dupCol;

        // Lower diagonal check
        while (row < n && col >= 0) {

            if (board[row][col] == 'Q') {
                return false;
            }

            row++;
            col--;
        }

        return true;
    }

    // Recursive function
    static void solve(int col,
                      char[][] board,
                      List<List<String>> ans,
                      int n) {

        // All queens placed
        if (col == n) {

            List<String> solution =
                    new ArrayList<>();

            for (int i = 0; i < n; i++) {

                solution.add(
                        new String(board[i])
                );
            }

            ans.add(solution);

            return;
        }

        // Try placing queen in every row
        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                solve(col + 1,
                        board,
                        ans,
                        n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    // Main solving function
    static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans =
                new ArrayList<>();

        char[][] board =
                new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                board[i][j] = '.';
            }
        }

        solve(0, board, ans, n);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");

        int n = sc.nextInt();

        List<List<String>> result =
                solveNQueens(n);

        System.out.println(
                "\nTotal Solutions: "
                + result.size()
                + "\n"
        );

        for (int i = 0; i < result.size(); i++) {

            System.out.println(
                    "Solution " + (i + 1) + ":"
            );

            for (String row : result.get(i)) {

                System.out.println(row);
            }

            System.out.println();
        }

        sc.close();
    }
}