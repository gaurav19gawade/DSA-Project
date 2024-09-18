package Learning.Graphs;

import java.util.HashMap;


/*
To clone a graph
we maintain a hashmap of current node in question as a key and its value as new node created with
data from current node.

we recursively create clone graph by passing the root of existing graph. In this function
we create a new node with current node's data and put it in the map
we then process the neighbors of this current node
we check if neigh is present in the map, if not recursively call node clone function.
and the value returned by node clone function is either null or new node created and
add it to the neighbors of new node created.

 */

public class CloneGraph {

  static HashMap<Node, Node> map = new HashMap<>();

  public static Node clone(Node current) {
    if(current == null){
      return null;
    }
    Node clonedNode = new Node(current.data);
    map.put(current, clonedNode);

    for(Node neigh: current.neighbors){
      Node x = map.get(neigh); //checking if a clone is present in the map
      if(x == null){
        clonedNode.neighbors.add(clone(neigh));
      } else {
        clonedNode.neighbors.add(x);
      }
    }
    return clonedNode;
  }

  public static Node createGraph(int[][] adjacencyList) {
    HashMap<Integer, Node> map = new HashMap<>();
    for(int[] node: adjacencyList){
      int node1 = node[0];
      int node2 = node[1];
      map.computeIfAbsent(node1, Node::new);
      map.computeIfAbsent(node2, Node::new);
      map.get(node1).neighbors.add(map.get(node2));
      map.get(node2).neighbors.add(map.get(node1));
    }

    return map.get(adjacencyList[0][0]);
  }

  public static void main(String[] args){
    int[][] list = {{2,3},{1,3},{1,2}};
    Node root = createGraph(list);
    clone(root);
  }
}
