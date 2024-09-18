package Learning.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class NumberOfConnectedComponents {


  public static int countComponents(int n, int[][] edges){
    UnionFind uf = new UnionFind(n);
    int connectedComponents = 0;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for(int[] edge: edges){
      uf.union(edge[0], edge[1]);
    }
    for(int i=0;i<n;i++){
      if(uf.parents[i] == i){
        connectedComponents++;
      }
    }
    return connectedComponents;
  }

  public static void main(String[] args){
    int[][] edges = {{0,1},{1,2},{3,4}};
    int n = 5;

    System.out.println("Number of connected components " + countComponents(n, edges));
  }
}
