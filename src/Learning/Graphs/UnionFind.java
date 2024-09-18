package Learning.Graphs;

public class UnionFind {

  int[] rank;
  int[] parents;

  public UnionFind(int size){
   this.rank = new int[size];
   this.parents = new int[size];
   for(int i=0; i<size; i++){
     this.parents[i] = i;
   }

   for(int i = 0; i<size;i++){
     this.rank[i]=1;
   }
  }

  public void union(int x, int y){
    int parentX = find(x);
    int parentY = find(y);

    if(parentX == parentY){
      return;
    } else if(rank[parentX] > rank[parentY]){
      parents[parentY] = parentX;
    } else if(rank[parentX] < rank[parentY]){
      parents[parentX] = parentY;
    } else{
      parents[parentY] = parentX; //changing parent of parentY to parentX
      rank[parentX]++;//incrementing the rank of parentX
    }
  }

  public int find(int x){
    if(parents[x] != x){
      parents[x] = find(parents[x]); //path compression
    }
    return parents[x];
  }
}
