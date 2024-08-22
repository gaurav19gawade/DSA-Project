package Learning.Graphs;

public class MaxAreaOfIsland {

  public static int maxAreaOfIsland(int[][] grid) {
    int maxArea = Integer.MIN_VALUE;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col <grid[0].length; col++){
        if(!visited[row][col] && grid[row][col] == 1){
          maxArea = Math.max(maxArea, islandArea(row, col, grid, visited));
        }
      }
    }
    return maxArea;
  }

  public static int islandArea(int row, int col, int[][] grid, boolean[][] visited){
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
      return 0;
    }

    if(grid[row][col] == 0){
      return 0;
    }
    int count = 1; //for every place we start we need this one
    grid[row][col] = 0;
    visited[row][col] = true;
    count += islandArea(row+1,col, grid, visited);
    count += islandArea(row,col+1, grid, visited);
    count += islandArea(row-1,col, grid, visited);
    count += islandArea(row,col-1, grid, visited);
    return count;
  }


  public static void main(String[] args){
    int[][] island = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
    System.out.println("Max area is " + maxAreaOfIsland(island));
  }
}
