package Learning.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


/*
Here the problem is to identify if graph is a valid tree and this can be done by checking if there is cycle in a graph
This can be done by using basic DFS algorithm and stack. After processing all the nodes the visited set should have all
nodes. If it doesn't that means its not a valid tree
 */

public class GraphValidTree {

  public static boolean validTree(int n, int[][] edges) {

    if(edges.length != n-1){
      return false;
    }
    Stack<Integer> stack = new Stack<>();
    Set<Integer> visited = new HashSet<>();
    stack.push(0);
    visited.add(0);
    List<List<Integer>> adjacency = new ArrayList<>();

    for(int i = 0; i<n; i++){
      adjacency.add(new ArrayList<>());
    }

    for(int[] edge: edges){
      //Should be done in case of uni-directional graphs
      adjacency.get(edge[0]).add(edge[1]);
      adjacency.get(edge[1]).add(edge[0]);
    }


    while(!stack.isEmpty()){
      int current = stack.pop();
      List<Integer> neighbors = adjacency.get(current);
      for(int neigh: neighbors){
        if(!visited.contains(neigh)){
          visited.add(neigh);
          stack.push(neigh);
        }
      }
    }

    return visited.size() == n;
  }

  public static void main(String[] args) {
    int[][] edgeCase1 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
    int[][] edgeCase2 = {{0,1},{0,2},{0,3},{1,4}};
    int[][] edgeCase3 = {{1,0}};
    int n = 2;
    System.out.println("Graph is a valid tree? " + validTree(n, edgeCase3));
  }
}
