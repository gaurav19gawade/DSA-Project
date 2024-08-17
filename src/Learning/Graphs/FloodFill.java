package Learning.Graphs;

public class FloodFill {

  static int[] rowDimension = {0,-1,0,1};
  static int[] colDimension = {-1,0,1,0};

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    colorChanger(image, sr, sc, image[sr][sc], color, image.length, image[0].length);
    return image;
  }

  public static void colorChanger(int[][] image, int sr, int sc, int originalColor, int newColor,
                                  int rowLength, int colLength){

    image[sr][sc] = newColor;
    for(int i = 0; i<rowDimension.length;i++){
      int newRow = rowDimension[i]+sr;
      int newCol = colDimension[i]+sc;

      if(newRow >=0 && newRow < rowLength && newCol >=0 && newCol < colLength && image[newRow][newCol] == originalColor
          && image[newRow][newCol] != newColor){
        colorChanger(image, newRow, newCol, originalColor, newColor, rowLength, colLength);
      }

    }


  }

  public static void main(String[] args){
    int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    int sr = 1, sc = 1, color = 2;
    floodFill(image, sr, sc, color);
  }
}
