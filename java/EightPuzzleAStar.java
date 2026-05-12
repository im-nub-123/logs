import java.util.*;

// Node class
class Node {

    int[][] mat = new int[3][3];

    int x, y;       // Blank tile position
    int cost;       // Heuristic value h(n)
    int level;      // Depth g(n)

    Node(int[][] mat, int x, int y,
         int cost, int level) {

        for (int i = 0; i < 3; i++) {
            this.mat[i] = mat[i].clone();
        }

        this.x = x;
        this.y = y;
        this.cost = cost;
        this.level = level;
    }
}

public class EightPuzzleAStar {

    static final int N = 3;

    // Goal State
    static int[][] goal = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };

    // Row and Column Moves
    static int[] row = {1, 0, -1, 0};
    static int[] col = {0, -1, 0, 1};

    // Print Matrix
    static void printMatrix(int[][] mat) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Calculate misplaced tiles heuristic
    static int calculateCost(int[][] mat) {

        int count = 0;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (mat[i][j] != 0 &&
                        mat[i][j] != goal[i][j]) {

                    count++;
                }
            }
        }

        return count;
    }

    // Check valid position
    static boolean isSafe(int x, int y) {

        return (x >= 0 && x < N &&
                y >= 0 && y < N);
    }

    public static void main(String[] args) {

        int[][] initial = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 5, 8}
        };

        int x = 1, y = 1; // Blank tile position

        // Priority Queue for A*
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) ->
                        (a.cost + a.level) -
                        (b.cost + b.level)
        );

        Node start = new Node(
                initial,
                x,
                y,
                calculateCost(initial),
                0
        );

        pq.add(start);

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            System.out.println("Current State:");

            printMatrix(current.mat);

            System.out.println(
                    "f(n) = " +
                            (current.cost + current.level)
            );

            System.out.println("------------------");

            // Goal reached
            if (current.cost == 0) {

                System.out.println(
                        "Goal State Reached!"
                );

                return;
            }

            // Generate child states
            for (int i = 0; i < 4; i++) {

                int newX = current.x + row[i];
                int newY = current.y + col[i];

                if (isSafe(newX, newY)) {

                    int[][] newMat =
                            new int[N][N];

                    for (int r = 0; r < N; r++) {
                        newMat[r] =
                                current.mat[r].clone();
                    }

                    // Swap tiles
                    int temp =
                            newMat[current.x][current.y];

                    newMat[current.x][current.y] =
                            newMat[newX][newY];

                    newMat[newX][newY] = temp;

                    Node child = new Node(
                            newMat,
                            newX,
                            newY,
                            calculateCost(newMat),
                            current.level + 1
                    );

                    pq.add(child);
                }
            }
        }
    }
}