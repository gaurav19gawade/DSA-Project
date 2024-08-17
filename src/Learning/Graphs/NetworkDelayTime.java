package Learning.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/*
Network Delay Time Algorithm

Problem:
Given a network of nodes and the time it takes for a signal to travel between them,
find the minimum time it takes for a signal from a start node to reach all other nodes.

Algorithm Overview:
1. Build an adjacency list from the input, representing the graph of node connections
   and signal travel times.
2. Use Dijkstra's algorithm with a min-heap priority queue to find the shortest paths.
3. The priority queue ensures we always process the node reachable in the least time first.
4. Keep track of visited nodes and the maximum time taken to reach any node.

Key Components:
- adjacency: HashMap<Integer, List<int[]>> representing the graph
- pq: PriorityQueue<int[]> min-heap, sorted by time to reach each node
- visited: HashSet<Integer> to keep track of processed nodes
- delayedTime: int to store the maximum time to reach any node

Important Line:
delayedTime = Math.max(delayedTime, currentTime);
This updates the overall delay time to the maximum time taken to reach any node,
which represents the time for the signal to propagate to all nodes.

Time Complexity: O(E log N), where E is the number of edges and N is the number of nodes
Space Complexity: O(N + E) for the adjacency list and priority queue

Return:
- The minimum time for the signal to reach all nodes
- -1 if not all nodes can be reached
*/

public class NetworkDelayTime {

  public static int minimumDelay(int n, int k, int[][] times){
    int delayedTime = 0;
    HashMap<Integer, List<int[]>> adjacency = new HashMap<>();


    //Create adjacency list
    for(int[] node: times) {
      int start = node[0];
      int destination = node[1];
      int time = node[2];
      adjacency.computeIfAbsent(start, key -> new ArrayList<>()).add(new int[]{destination, time});
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[]{0, k});
    HashSet<Integer> visited = new HashSet<>();

    while(!pq.isEmpty()){
      int[] currNode = pq.poll();
      int currentTime = currNode[0];
      int currentNode = currNode[1];

      if(visited.contains(currentNode)){
        continue;
      }
      visited.add(currentNode);
      //updated delay time
      delayedTime = Math.max(delayedTime, currentTime);
      List<int[]> neighbours = adjacency.getOrDefault(currentNode, new ArrayList<>());

        for(int[] neigh: neighbours){
          int currentNeigh = neigh[0];
          int currentNeighTime = neigh[1];
          if(!visited.contains(currentNeigh)){
            pq.offer(new int[]{currentNeighTime+currentTime, currentNeigh});
          }
        }
    }

    if (visited.size() == n){
      return delayedTime;
    }

    return -1;

  }

  public static void main(String[] args){
    int[][] times = {{2,1,2},{2,3,3},{2,4,1},{4,3,1}};
    int n = 4;
    int k = 2;
    System.out.println(minimumDelay(n, k, times));
  }
}
