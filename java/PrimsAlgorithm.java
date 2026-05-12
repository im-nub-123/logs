import java.util.*;

// Pair class for adjacency list
class Pair {

    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

// Node class for Priority Queue
class Node {

    int weight;
    int node;
    int parent;

    Node(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

public class PrimsAlgorithm {

    // Prim's MST Function
    static int spanningTree(int V,
                            ArrayList<ArrayList<Pair>> adjList) {

        int sum = 0;

        // Min Heap
        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                a.weight - b.weight
                );

        boolean[] visited =
                new boolean[V];

        // {weight, node, parent}
        pq.add(new Node(0, 0, -1));

        System.out.println("\nEdges in MST:");

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            int currWt = current.weight;
            int node = current.node;
            int parent = current.parent;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            sum += currWt;

            // Skip source node
            if (parent != -1) {

                System.out.println(
                        parent + " - " +
                        node + " : " +
                        currWt
                );
            }

            // Traverse neighbors
            for (Pair neighborPair :
                    adjList.get(node)) {

                int neighbor =
                        neighborPair.node;

                int wt =
                        neighborPair.weight;

                if (!visited[neighbor]) {

                    pq.add(
                            new Node(
                                    wt,
                                    neighbor,
                                    node
                            )
                    );
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V, E;

        System.out.print(
                "Enter number of vertices: "
        );

        V = sc.nextInt();

        System.out.print(
                "Enter number of edges: "
        );

        E = sc.nextInt();

        // Adjacency List
        ArrayList<ArrayList<Pair>> adjList =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adjList.add(
                    new ArrayList<>()
            );
        }

        System.out.println(
                "Enter edges (u v wt):"
        );

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            adjList.get(u).add(
                    new Pair(v, wt)
            );

            adjList.get(v).add(
                    new Pair(u, wt)
            );
        }

        int mstWeight =
                spanningTree(V, adjList);

        System.out.println(
                "\nTotal MST Weight = "
                + mstWeight
        );

        sc.close();
    }
}