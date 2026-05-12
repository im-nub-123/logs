#include <bits/stdc++.h>
using namespace std;

class DisjointSet {
private:
    vector<int> parent, size;

public:
    DisjointSet(int n) {
        size.resize(n, 1);
        parent.resize(n);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findParent(int node) {

        if (node == parent[node])
            return node;

        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v) {

        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
};

class Solution {

public:
    int kruskalsMST(int V, vector<vector<int>>& edges) {

        // Sort edges according to weight
        sort(edges.begin(), edges.end(),
             [](const vector<int>& a, const vector<int>& b) {
                 return a[2] < b[2];
             });

        DisjointSet ds(V);

        int mstWeight = 0;

        cout << "\nEdges in MST:\n";

        for (auto& it : edges) {

            int u = it[0];
            int v = it[1];
            int wt = it[2];

            // If they belong to different components
            if (ds.findParent(u) != ds.findParent(v)) {

                mstWeight += wt;

                ds.unionBySize(u, v);

                // Print selected edge
                cout << u << " -- " << v
                     << "  weight = " << wt << endl;
            }
        }

        return mstWeight;
    }
};

int main() {

    int V, E;

    cout << "Enter number of vertices: ";
    cin >> V;

    cout << "Enter number of edges: ";
    cin >> E;

    vector<vector<int>> edges;

    cout << "\nEnter edges in format:\n";
    cout << "u v weight\n\n";

    for (int i = 0; i < E; i++) {

        int u, v, wt;
        cin >> u >> v >> wt;

        edges.push_back({u, v, wt});
    }

    Solution obj;

    int totalWeight = obj.kruskalsMST(V, edges);

    cout << "\nTotal Weight of MST = "
         << totalWeight << endl;

    return 0;
}