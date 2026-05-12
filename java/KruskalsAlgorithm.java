import java.util.*;

// Edge class
class Edge {

    int u, v, wt;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

// Disjoint Set Class
class DisjointSet {

    int[] parent;
    int[] size;

    DisjointSet(int n) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {

            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find Parent with Path Compression
    int findParent(int node) {

        if (node == parent[node]) {
            return node;
        }

        return parent[node] =
                findParent(parent[node]);
    }

    // Union by Size
    void unionBySize(int u, int v) {

        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {

            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {

            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class KruskalsAlgorithm {

    // Kruskal's MST Function
    static int kruskalsMST(int V,
                           ArrayList<Edge> edges) {

        // Sort edges according to weight
        Collections.sort(edges,
                (a, b) -> a.wt - b.wt);

        DisjointSet ds =
                new DisjointSet(V);

        int mstWeight = 0;

        System.out.println("\nEdges in MST:");

        for (Edge edge : edges) {

            int u = edge.u;
            int v = edge.v;
            int wt = edge.wt;

            // Different components
            if (ds.findParent(u) !=
                    ds.findParent(v)) {

                mstWeight += wt;

                ds.unionBySize(u, v);

                // Print selected edge
                System.out.println(
                        u + " -- " + v +
                        "  weight = " + wt
                );
            }
        }

        return mstWeight;
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

        ArrayList<Edge> edges =
                new ArrayList<>();

        System.out.println(
                "\nEnter edges in format:"
        );

        System.out.println("u v weight\n");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            edges.add(
                    new Edge(u, v, wt)
            );
        }

        int totalWeight =
                kruskalsMST(V, edges);

        System.out.println(
                "\nTotal Weight of MST = "
                + totalWeight
        );

        sc.close();
    }
}