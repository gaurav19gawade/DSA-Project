package Learning.Graphs;

import java.util.HashMap;

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
