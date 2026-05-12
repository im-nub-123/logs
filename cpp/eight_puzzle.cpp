#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define N 3

// Goal state
int goal[N][N] = {
    {1,2,3},
    {4,5,6},
    {7,8,0}
};

// Node structure
struct Node {
    vector<vector<int>> mat;
    int x, y;      // blank tile position
    int cost;      // heuristic value h(n)
    int level;     // depth g(n)
};

// Compare function for priority queue
struct compare {
    bool operator()(Node a, Node b) {
        return (a.cost + a.level) > (b.cost + b.level);
    }
};

// Print matrix
void printMatrix(vector<vector<int>> mat) {
    for(auto row : mat) {
        for(auto val : row)
            cout << val << " ";
        cout << endl;
    }
}

// Calculate misplaced tiles
int calculateCost(vector<vector<int>> mat) {
    int count = 0;

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {

            if(mat[i][j] != 0 &&
               mat[i][j] != goal[i][j]) {
                count++;
            }
        }
    }

    return count;
}

// Check valid position
bool isSafe(int x, int y) {
    return (x >= 0 && x < N && y >= 0 && y < N);
}

// Row and column moves
int row[] = {1, 0, -1, 0};
int col[] = {0, -1, 0, 1};

int main() {

    vector<vector<int>> initial = {
        {1,2,3},
        {4,0,6},
        {7,5,8}
    };

    int x = 1, y = 1; // blank tile position

    priority_queue<Node, vector<Node>, compare> pq;

    Node start;
    start.mat = initial;
    start.x = x;
    start.y = y;
    start.level = 0;
    start.cost = calculateCost(initial);

    pq.push(start);

    while(!pq.empty()) {

        Node current = pq.top();
        pq.pop();

        cout << "Current State:\n";
        printMatrix(current.mat);

        cout << "f(n) = "
             << current.cost + current.level;

        cout << "\n------------------\n";

        // Goal reached
        if(current.cost == 0) {
            cout << "Goal State Reached!";
            return 0;
        }

        // Generate child states
        for(int i = 0; i < 4; i++) {

            int newX = current.x + row[i];
            int newY = current.y + col[i];

            if(isSafe(newX, newY)) {

                Node child = current;

                swap(child.mat[current.x][current.y],
                     child.mat[newX][newY]);

                child.x = newX;
                child.y = newY;

                child.level = current.level + 1;

                child.cost = calculateCost(child.mat);

                pq.push(child);
            }
        }
    }

    return 0;
}