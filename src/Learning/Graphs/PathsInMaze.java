package Learning.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Understanding the problem:
We're looking for cycles of length 3 in an undirected graph.
A cycle of length 3 is also known as a triangle in graph theory.
The key insight:
A triangle exists when three nodes are all connected to each other.
In other words, for any two connected nodes, if they have a common neighbor, that forms a triangle.
 */

public class PathsInMaze {

  public static int numberOfPaths(int n, int[][] corridors) {
    int confusion = 0;
    HashMap<Integer, Set<Integer>> adjacency = new HashMap<>();

    for(int[] corridor: corridors){
      int room1 = corridor[0];
      int room2 = corridor[1];

      adjacency.computeIfAbsent(room1, key -> new HashSet<>()).add(room2);
      adjacency.computeIfAbsent(room2, key -> new HashSet<>()).add(room1);
      confusion += countIntersection(adjacency.get(room1), adjacency.get(room2));
    }

    return confusion;
  }

  public static int countIntersection(Set<Integer> a, Set<Integer> b){
    int count = 0;
    for(int element: a){
      if (b.contains(element)){
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] corridors = {{1,2},{5,2},{4,1},{2,4},{3,1},{3,4}};
    numberOfPaths(5, corridors);
  }
}
