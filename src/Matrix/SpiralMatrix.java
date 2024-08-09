package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static List<Integer> spiralOrder(int[][] matrix) {
    //left to right, top to bottom, right to left, bottom to top
    //left = 0, right = length of column - 1, top = 0, bottom = length of rows - 1
    int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
    List<Integer> result = new ArrayList<>();

    while(left < right && top < bottom) {
      //left to right
      for(int i = left; i < right; i++){
        result.add(matrix[top][i]);
      }

      top++;

      //top to bottom
      for(int i = top; i < bottom; i++) {
        result.add(matrix[i][right-1]);
      }

      right--;

      if(!(left < right && top < bottom)) {
        break;
      }

      //right to left
      for(int i = right-1; i >left-1; i--) {
        result.add(matrix[bottom-1][i]);
      }

      bottom--;

      //bottom to top
      for(int i = bottom-1; i > top-1; i--) {
        result.add(matrix[i][left]);
      }
      left++;
    }


    return result;
  }

  public static void main(String[] args) {
      int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
      System.out.println("Spiral list is " + spiralOrder(matrix));
  }
}
