import java.util.*;

// Class to represent pair of (distance, node)
class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgorithm {

    // Dijkstra Function
    public static int[] dijkstra(int V,
                                 ArrayList<ArrayList<Pair>> adjList,
                                 int src) {

        // Min Heap -> {distance, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int currDist = current.distance;
            int node = current.node;

            for (Pair neighborPair : adjList.get(node)) {

                int neighbor = neighborPair.node;
                int wt = neighborPair.distance;

                // Relaxation Step
                if (currDist + wt < dist[neighbor]) {

                    dist[neighbor] = currDist + wt;

                    pq.add(new Pair(dist[neighbor], neighbor));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V, E;

        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        E = sc.nextInt();

        // Adjacency List
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v wt):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            adjList.get(u).add(new Pair(wt, v));
            adjList.get(v).add(new Pair(wt, u)); // Undirected Graph
        }

        System.out.print("Enter source node: ");

        int src = sc.nextInt();

        int[] ans = dijkstra(V, adjList, src);

        System.out.println("\nShortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {

            System.out.println("Node " + i + " -> " + ans[i]);
        }

        sc.close();
    }
}