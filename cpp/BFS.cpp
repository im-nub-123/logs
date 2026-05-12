#include<bits/stdc++.h> 
/*

1.Implement Breadth First Search (BFS) algorithm,
  Use an undirected graph and develop a recursive algorithm for 
  searching all the vertices of a graph or tree data structure.


*/
using namespace std; 


void BFS(int src, vector<vector<int>>&adjL,vector<int>& visited){

    queue<int>q;
    q.push(src);
    visited[src] = 1;
  
    while(!q.empty()){
        int node = q.front();q.pop();
        cout<<node<<" ";
        for(auto adjNode : adjL[node]){
            if(!visited[adjNode]){
                visited[adjNode] = 1;
                q.push(adjNode);
            }
        }
    }
}
int main(){
    int v,e;
    cout<<"Enter Number of vertices and edges : ";
    cin>>v>>e;

    vector<vector<int>>adjL(v+1);

    for(int i = 1 ; i <= e ;  i++){
        int u , w;
        cin>>u>>w;
        adjL[u].push_back(w);
        adjL[w].push_back(u);
    }
    vector<int>visited(v+1,0);

    for(int i = 1 ;i <= v ; i++){
        if(!visited[i]){
            BFS(i,adjL,visited);
        }
    } 
return 0 ; 

}