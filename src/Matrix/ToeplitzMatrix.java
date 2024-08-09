package Matrix;

public class ToeplitzMatrix {

  public static boolean isToeplitzMatrix(int[][] matrix) {
    //In toeplitz matrix, every diagonal should be equal

    //for all columns
    for (int col = 0; col < matrix[0].length; col++){
      if (!isDiagonalEqual(0, col, matrix)){
        return false;
      }
    }

    //for all rows
    for (int row = 0; row < matrix.length; row++){
      if (!isDiagonalEqual(row, 0, matrix)){
        return false;
      }
    }


    return true;
  }

  public static boolean isDiagonalEqual(int row, int col, int[][] matrix) {
    int currentValue = matrix[row][col];

    while(row < matrix.length && col < matrix[0].length) {
      if(matrix[row][col] != currentValue) {
        return false;
      }
      row++;
      col++;
    }
    return true;
  }

  public static void main(String[] args){
    int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
    System.out.println("Is matrix toeplitz " + isToeplitzMatrix(matrix));
  }
}
