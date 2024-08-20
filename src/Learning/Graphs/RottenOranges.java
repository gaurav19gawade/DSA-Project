package Learning.Graphs;

import java.util.LinkedList;
import java.util.Queue;


/*
We add all the rotten oranges to the queue and keep a count of fresh oranges;
While processing a queue we process all the rotten oranges in the queue present at the moment
which is loop over the size of the present queue.
while processing we check for neighboring oranges to these rotten ones and add them to the queue

once we have processed the queue for initial rotten oranges queue size we increase the minute.
 */

public class RottenOranges {

  public static int orangesRotting(int[][] grid){
    int minutesCount = 0;
    int freshOranges = 0;
    int rowL = grid.length;
    int colL = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col < grid[0].length; col++) {
        if(grid[row][col] == 2){ //find any first rotten orange
          queue.add(new int[]{row, col});
        } else if (grid[row][col] == 1){
          freshOranges++;
        }
      }
    }

    if (freshOranges == 0){return 0;}

    while(!queue.isEmpty() && freshOranges > 0){
      int size = queue.size();
      for(int i =0; i < size; i++){
        int[] coords = queue.poll();
        int row = coords[0];
        int col = coords[1];
        //getting all the neighbors
        for(int[] xy: directions){
          int newRow = row+xy[0];
          int newCol = col+xy[1];
          if(newRow >= 0 && newRow < rowL && newCol >=0 && newCol < colL && grid[newRow][newCol] == 1){
            freshOranges--;
            grid[newRow][newCol] = 2;
            queue.add(new int[]{newRow, newCol});
          }
        }
      }
      minutesCount++;
    }
    return freshOranges==0 ? minutesCount:-1;
  }

  public static void main(String[] args){
    int[][] grid = {
        {2, 1, 1, 0, 1},
        {1, 0, 1, 2, 1},
        {1, 1, 0, 1, 1},
        {0, 1, 1, 1, 2},
        {1, 1, 0, 1, 1}
    };
    System.out.println("Total minutes " + orangesRotting(grid));

  }
}
