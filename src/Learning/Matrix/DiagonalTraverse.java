package Learning.Matrix;

import java.util.Arrays;

public class DiagonalTraverse {

  //row, col
  // 0 1,2,1,0
  //[0,0] ->[ 0,1 -> 1,0 ]->[ 2,0 -> 1,1 -> 0,2 ] -> [1,2 -> 2,1] ->[2,2]
  // looks like row increase and column decrease?
  // we will use x and y initialized to 0, and they indicate row and col respectively
  // if x+y is even; we are traversing up; while traversing up we first check for columns outbound;
  // then check if x is 0 increase y else decrease x and increase y

  // if x+y is odd; we are traversing down; while traversing up we first check for rows outbound;
  //then check if y is 0 increase x else increase x and decrease y

  public static int[] findDiagonalOrder(int[][] matrix) {
    int[] result = new int[matrix.length * matrix[0].length];
    int rows = matrix.length;
    int cols = matrix[0].length;
    int x = 0, y = 0;

    for (int i = 0; i< result.length; i++){
      result[i] = matrix[x][y];

      //going up
      if((x+y) % 2 == 0) {
        if(y == cols -1){
          x++;
        } else if (x == 0){
          y++;
        } else {
          x--;
          y++;
        }
      } else { //goimg down
        if(x == rows -1){
          y++;
        } else if(y == 0){
          x++;
        } else {
          x++;
          y--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println("Diagonal Traverse is " + Arrays.toString(findDiagonalOrder(matrix)));
  }
}
