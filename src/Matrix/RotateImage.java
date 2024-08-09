package Matrix;

import java.util.Arrays;

public class RotateImage {

  public static void rotateImage(int[][] matrix){

    int left = 0;
    int right = matrix.length-1;

    while(left < right) {
      for(int i = 0; i < right-left; i++){
        int top = left;
        int bottom = right;

        //save top left
        int topLeft = matrix[top][left+i];

        //bottom left to top left
        matrix[top][left+i] = matrix[bottom-i][left];

        //bottom right to bottom left
        matrix[bottom-i][left] = matrix[bottom][right-i];

        //top right to bottom right
        matrix[bottom][right-i] = matrix[top+i][right];

        //top left to top right
        matrix[top+i][right] = topLeft;

      }
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    rotateImage(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}
