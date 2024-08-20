package Learning.Graphs;

public class NumberOfIslands {
  public static int numIslands(char[][] grid) {
    int rowLength = grid.length;
    int colLength = grid[0].length;
    int countIsland = 0;
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    for(int row = 0; row < rowLength; row++){
      for(int col = 0; col < colLength; col++){
          if (grid[row][col] == '1'){
            countIsland += 1;
            dfs(row, col, rowLength, colLength, grid, directions);
          }
      }
    }
    return countIsland;
  }

  public static void dfs(int row, int col, int rowLength, int colLength, char[][] grid, int[][] directions){
    grid[row][col] = '0';
    for(int[] direction: directions){
      int newRow = row+direction[0];
      int newCol = col+direction[1];

      if(newRow >= 0 && newRow < rowLength && newCol >= 0 && newCol < colLength && grid[newRow][newCol] == '1'){
        dfs(newRow, newCol, rowLength, colLength, grid, directions);
      }
    }
  }

  public static void main(String[] args){
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println("Total islands are "+ numIslands(grid));
  }


}
