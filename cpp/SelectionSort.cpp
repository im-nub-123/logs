#include<bits/stdc++.h> 

using namespace std; 
void SelectionSort(vector<int>&arr){
    int n = arr.size();

    for(int i = 0 ;i < n-1 ; i++){
        int min_idx = i;
        for(int j = i+1 ; j < n ; j++){
            if(arr[j] < arr[min_idx]){
                min_idx = j;
            }
        }

        swap(arr[i],arr[min_idx]);
    }
}

int main(){
cout<<"Enter size of the array : ";

int n;
cin>>n;
vector<int>arr;

for(int i = 0 ; i < n ; i++){
    int u ;
    cin>>u;
    arr.push_back(u);
}

cout<<"Array before Selection Sort : "<<endl;
for(auto it : arr){
    cout<<it<<" ";
}
cout<<endl;

SelectionSort(arr);

cout<<"Array After Selection Sort : "<<endl;
for(auto it : arr){
    cout<<it<<" ";
}
cout<<endl;

return 0 ; 

}