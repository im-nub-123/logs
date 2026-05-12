import java.util.*;

public class BFSGraph {

    // BFS Function
    static void BFS(int src, ArrayList<ArrayList<Integer>> adjList,
                    boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print(node + " ");

            for (int adjNode : adjList.get(node)) {

                if (!visited[adjNode]) {

                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");

        int v = sc.nextInt();
        int e = sc.nextInt();

        // Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter edges:");

        // Input edges
        for (int i = 1; i <= e; i++) {

            int u = sc.nextInt();
            int w = sc.nextInt();

            adjList.get(u).add(w);
            adjList.get(w).add(u); // Undirected Graph
        }

        boolean[] visited = new boolean[v + 1];

        System.out.println("BFS Traversal:");

        // For disconnected graph
        for (int i = 1; i <= v; i++) {

            if (!visited[i]) {
                BFS(i, adjList, visited);
            }
        }

        sc.close();
    }
}