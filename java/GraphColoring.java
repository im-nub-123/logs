public class GraphColoring {

    static final int V = 4;

    // Graph adjacency matrix
    static int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
    };

    static int[] color = new int[V];

    // Check if color can be assigned
    static boolean isSafe(int node, int c) {

        for (int i = 0; i < V; i++) {

            // Adjacent vertex has same color
            if (graph[node][i] == 1 &&
                    color[i] == c) {

                return false;
            }
        }

        return true;
    }

    // Backtracking function
    static boolean graphColoring(int node, int m) {

        // All vertices colored
        if (node == V) {
            return true;
        }

        // Try all colors
        for (int c = 1; c <= m; c++) {

            // Branch & Bound pruning
            if (isSafe(node, c)) {

                color[node] = c;

                // Recur for next node
                if (graphColoring(node + 1, m)) {
                    return true;
                }

                // Backtrack
                color[node] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int m = 3; // Number of colors

        // Initialize colors
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }

        if (graphColoring(0, m)) {

            System.out.println("Solution Exists\n");

            for (int i = 0; i < V; i++) {

                System.out.println(
                        "Vertex " + i +
                        " ---> Color " + color[i]
                );
            }
        }
        else {

            System.out.println("No Solution Exists");
        }
    }
}