#include <iostream>
#include <queue>
#include <vector>
using namespace std;

#define N 4

// Cost matrix
int graph[N][N] = {
    {0, 10, 15, 20},
    {10, 0, 35, 25},
    {15, 35, 0, 30},
    {20, 25, 30, 0}
};

// Node structure
struct Node {
    vector<int> path;
    vector<bool> visited;

    int cost;      // g(n)
    int city;
    int level;

    // f(n) = g(n) + h(n)
    int totalCost;
};

// Compare for priority queue
struct compare {
    bool operator()(Node a, Node b) {
        return a.totalCost > b.totalCost;
    }
};

// Simple heuristic
int heuristic() {
    return 0;
}

int main() {

    priority_queue<Node, vector<Node>, compare> pq;

    Node start;

    start.path.push_back(0);

    start.visited = vector<bool>(N, false);
    start.visited[0] = true;

    start.cost = 0;
    start.city = 0;
    start.level = 0;

    start.totalCost = start.cost + heuristic();

    pq.push(start);

    int minCost = 1e9;
    vector<int> bestPath;

    while(!pq.empty()) {

        Node current = pq.top();
        pq.pop();

        // All cities visited
        if(current.level == N - 1) {

            int finalCost =
                current.cost +
                graph[current.city][0];

            if(finalCost < minCost) {

                minCost = finalCost;

                bestPath = current.path;
                bestPath.push_back(0);
            }

            continue;
        }

        // Generate child nodes
        for(int i = 0; i < N; i++) {

            if(!current.visited[i]) {

                Node child;

                child.path = current.path;
                child.path.push_back(i);

                child.visited = current.visited;
                child.visited[i] = true;

                child.cost =
                    current.cost +
                    graph[current.city][i];

                child.city = i;

                child.level =
                    current.level + 1;

                child.totalCost =
                    child.cost + heuristic();

                pq.push(child);
            }
        }
    }

    cout << "Minimum Cost = "
         << minCost << endl;

    cout << "Path: ";

    for(int city : bestPath) {
        cout << city << " ";
    }

    return 0;
}