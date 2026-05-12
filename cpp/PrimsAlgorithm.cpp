#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    int spanningTree(int V, vector<vector<int>>& edges) {

        int sum = 0;

        // Adjacency List
        vector<vector<pair<int,int>>> adjL(V);

        for(auto it : edges){

            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adjL[u].push_back({v, wt});
            adjL[v].push_back({u, wt});
        }

        // pq => {weight, node, parent}
        priority_queue<
            vector<int>,
            vector<vector<int>>,
            greater<vector<int>>
        > pq;

        vector<int> visited(V, 0);

        // {wt, node, parent}
        pq.push({0, 0, -1});

        cout << "\nEdges in MST:\n";

        while(!pq.empty()){

            auto top = pq.top();
            pq.pop();

            int currWt = top[0];
            int node = top[1];
            int parent = top[2];

            if(visited[node]) continue;

            visited[node] = 1;

            sum += currWt;

            // Skip printing source node
            if(parent != -1){
                cout << parent << " - " << node
                     << " : " << currWt << endl;
            }

            for(auto it : adjL[node]){

                int neighbor = it.first;
                int wt = it.second;

                if(!visited[neighbor]){
                    pq.push({wt, neighbor, node});
                }
            }
        }

        return sum;
    }
};

int main() {

    int V, E;

    cout << "Enter number of vertices: ";
    cin >> V;

    cout << "Enter number of edges: ";
    cin >> E;

    vector<vector<int>> edges;

    cout << "Enter edges (u v wt):\n";

    for(int i = 0; i < E; i++){

        int u, v, wt;
        cin >> u >> v >> wt;

        edges.push_back({u, v, wt});
    }

    Solution obj;

    int mstWeight = obj.spanningTree(V, edges);

    cout << "\nTotal MST Weight = " << mstWeight << endl;

    return 0;
}