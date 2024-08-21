package Learning.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntrance {

  public static int nearestExit(char[][] maze, int[] entrance) {
    Queue<int[]> queue = new LinkedList<>();
    int[] rowDirection = {0,1,-1,0};
    int[] colDirection = {1,0,0,-1};
    int rowL = maze.length;
    int colL = maze[0].length;
    int steps = 0;

    queue.add(entrance);
    maze[entrance[0]][entrance[1]] = '+';

    while(!queue.isEmpty()){
      int size = queue.size();
      steps++;
      for(int j = 0; j < size; j++){
        int[] path = queue.poll();
        int row = path[0];
        int col = path[1];

        for(int i = 0; i< rowDirection.length; i++){
          int newRow = row+rowDirection[i];
          int newCol = col+colDirection[i];
          //check for out of bounds
          if(newRow < 0 || newRow >= rowL || newCol < 0 || newCol >= colL){
            continue;
          }

          //check if direction is the wall
          if(maze[newRow][newCol] == '+'){continue;}

          // If this direction is empty, not visited and is at the boundary, we have arrived at the exit.
          if (newRow == 0 || newRow == rowL - 1 || newCol == 0 || newCol == colL - 1) return steps;

          queue.add(new int[]{newRow, newCol});
          maze[newRow][newCol] = '+';
        }
      }
    }
    return -1;
  }

  public static void main(String[] args){
    char[][] maze = {{'.'}};
    int[] entrance = {0,0};
    System.out.println("Number of steps required? " + nearestExit(maze, entrance));
  }
}
