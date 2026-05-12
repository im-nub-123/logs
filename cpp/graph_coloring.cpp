#include <iostream>
using namespace std;

#define V 4

// Graph adjacency matrix
int graph[V][V] = {
    {0, 1, 1, 1},
    {1, 0, 1, 0},
    {1, 1, 0, 1},
    {1, 0, 1, 0}
};

int color[V];

// Check if color can be assigned
bool isSafe(int node, int c) {

    for(int i = 0; i < V; i++) {

        // Adjacent vertex has same color
        if(graph[node][i] == 1 &&
           color[i] == c) {
            return false;
        }
    }

    return true;
}

// Backtracking function
bool graphColoring(int node, int m) {

    // All vertices colored
    if(node == V) {
        return true;
    }

    // Try all colors
    for(int c = 1; c <= m; c++) {

        // Branch & Bound pruning
        if(isSafe(node, c)) {

            color[node] = c;

            // Recur for next node
            if(graphColoring(node + 1, m))
                return true;

            // Backtrack
            color[node] = 0;
        }
    }

    return false;
}

int main() {

    int m = 3; // Number of colors

    // Initialize colors
    for(int i = 0; i < V; i++)
        color[i] = 0;

    if(graphColoring(0, m)) {

        cout << "Solution Exists\n";

        for(int i = 0; i < V; i++) {
            cout << "Vertex "
                 << i
                 << " ---> Color "
                 << color[i]
                 << endl;
        }
    }
    else {
        cout << "No Solution Exists";
    }

    return 0;
}