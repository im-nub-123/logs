#include<bits/stdc++.h> 
/*

1.Implement Depth First Search (DFS) algorithm,
  Use an undirected graph and develop a recursive algorithm for 
  searching all the vertices of a graph or tree data structure.


*/
using namespace std; 
void DFS(int node, vector<vector<int>>&adjL,vector<int>& visited){
    visited[node] = 1;
    cout<<node <<" ";
    for(auto it : adjL[node]){
        if(!visited[it]){
          DFS(it,adjL,visited);
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
            DFS(i,adjL,visited);
        }
    }

    
return 0 ; 

}