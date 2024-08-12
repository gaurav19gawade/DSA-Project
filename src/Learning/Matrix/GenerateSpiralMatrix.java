package Learning.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSpiralMatrix {

  public static int[][] generateMatrix(int n) {
    int[][] newMatrix = new int[n][n];

    int left = 0, right = n, top = 0, bottom = n;
    int number = 1;

    while(left < right && top < bottom) {

      //left to right
      for(int i = left; i < right; i++) {
        newMatrix[top][i] = number;
        number++;
      }

      top++;

      //top to bottom
      for(int i = top; i < bottom; i++) {
        newMatrix[i][right-1] = number;
        number++;
      }

      right--;

      //right to left
      for(int i = right-1; i>left-1; i--) {
        newMatrix[bottom-1][i] = number;
        number++;
      }

      bottom--;

      //bottom to top
      for(int i = bottom-1; i>top-1; i--){
        newMatrix[i][left] = number;
        number++;
      }
      left++;
    }
    return newMatrix;
  }

  public static void main(String[] args) {
    System.out.println("Genereated matrix is" + Arrays.deepToString(generateMatrix(1)));
  }

}
