#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src) {

        // Adjacency List
        vector<vector<pair<int,int>>> adjL(V);

        for(auto it : edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adjL[u].push_back({v, wt});
            adjL[v].push_back({u, wt});
        }

        // Min Heap -> {distance, node}
        priority_queue<
            pair<int,int>,
            vector<pair<int,int>>,
            greater<pair<int,int>>
        > pq;

        vector<int> dist(V, INT_MAX);

        dist[src] = 0;
        pq.push({0, src});

        while(!pq.empty()){

            int currWt = pq.top().first;
            int node = pq.top().second;

            pq.pop();

            for(auto it : adjL[node]){

                int neighbor = it.first;
                int wt = it.second;

                if(currWt + wt < dist[neighbor]){

                    dist[neighbor] = currWt + wt;

                    pq.push({dist[neighbor], neighbor});
                }
            }
        }

        return dist;
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

    int src;

    cout << "Enter source node: ";
    cin >> src;

    Solution obj;

    vector<int> ans = obj.dijkstra(V, edges, src);

    cout << "\nShortest distances from source " << src << ":\n";

    for(int i = 0; i < V; i++){
        cout << "Node " << i << " -> " << ans[i] << endl;
    }

    return 0;
}