package Learning.Matrix;

import java.util.Arrays;

public class TransposeMatrix {

  public static int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];

    for (int row=0; row < matrix.length; row++) {
      for (int col =0; col < matrix[0].length; col++) {
        result[col][row] = matrix[row][col];
      }
    }
    return result;
  }

  public static void main(String[] args){
    int[][] matrix = {{1,2,3},{4,5,6}};
    System.out.println("Transposed Learning.Matrix is "+ Arrays.deepToString(transpose(matrix)));
  }
}
