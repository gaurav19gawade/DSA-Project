package Learning.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

  public static void wallsAndGates(int[][] rooms) {
    Queue<int[]> queue = new LinkedList<>();
    int dist = 0;
    int[] rowDirection = {0,1,-1,0};
    int[] colDirection = {1,0,0,-1};

    for(int row = 0; row <rooms.length; row++){
      for(int col = 0; col <rooms[0].length; col++){
        if(rooms[row][col] == 0){
          queue.add(new int[]{row,col});
        }
      }
    }

    while(!queue.isEmpty()){
      dist++;
      int size = queue.size();

      for(int i = 0; i < size; i++){
        int[] top = queue.poll();
        for(int j = 0; j < rowDirection.length; j++){
          int newRow = top[0] + rowDirection[j];
          int newCol = top[1] + colDirection[j];

          if(newRow < 0 || newRow >=  rooms.length || newCol < 0 || newCol >= rooms[0].length
              || rooms[newRow][newCol] <= dist){
            continue;
          }
          rooms[newRow][newCol] = dist;
          queue.add(new int[]{newRow, newCol});
        }
      }
    }
  }

  public static void main(String[] args){
    int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    wallsAndGates(rooms);
  }
}
