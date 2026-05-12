import java.util.*;

// Node class
class Node {

    List<Integer> path;
    boolean[] visited;

    int cost;       // g(n)
    int city;
    int level;

    // f(n) = g(n) + h(n)
    int totalCost;

    Node() {

        path = new ArrayList<>();
        visited = new boolean[4];
    }
}

public class TSP_AStar {

    static final int N = 4;

    // Cost Matrix
    static int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };

    // Simple Heuristic
    static int heuristic() {

        return 0;
    }

    public static void main(String[] args) {

        // Priority Queue
        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                a.totalCost -
                                b.totalCost
                );

        Node start = new Node();

        start.path.add(0);

        start.visited[0] = true;

        start.cost = 0;
        start.city = 0;
        start.level = 0;

        start.totalCost =
                start.cost + heuristic();

        pq.add(start);

        int minCost = Integer.MAX_VALUE;

        List<Integer> bestPath =
                new ArrayList<>();

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            // All cities visited
            if (current.level == N - 1) {

                int finalCost =
                        current.cost +
                        graph[current.city][0];

                if (finalCost < minCost) {

                    minCost = finalCost;

                    bestPath =
                            new ArrayList<>(
                                    current.path
                            );

                    bestPath.add(0);
                }

                continue;
            }

            // Generate child nodes
            for (int i = 0; i < N; i++) {

                if (!current.visited[i]) {

                    Node child =
                            new Node();

                    child.path =
                            new ArrayList<>(
                                    current.path
                            );

                    child.path.add(i);

                    child.visited =
                            current.visited.clone();

                    child.visited[i] = true;

                    child.cost =
                            current.cost +
                            graph[current.city][i];

                    child.city = i;

                    child.level =
                            current.level + 1;

                    child.totalCost =
                            child.cost +
                            heuristic();

                    pq.add(child);
                }
            }
        }

        System.out.println(
                "Minimum Cost = " + minCost
        );

        System.out.print("Path: ");

        for (int city : bestPath) {

            System.out.print(city + " ");
        }
    }
}