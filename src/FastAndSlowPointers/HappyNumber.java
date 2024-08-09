package FastAndSlowPointers;

import static FastAndSlowPointers.SumOfSquaredDigits.sumOfSquaredDigits;

public class HappyNumber {

  public static boolean isHappyNumber(int n) {
    int slowNumber = n;
    int fastNumber = sumOfSquaredDigits(n);

    while (fastNumber != slowNumber) {
      slowNumber = sumOfSquaredDigits(slowNumber);
      fastNumber = sumOfSquaredDigits(sumOfSquaredDigits(fastNumber));
      if (fastNumber == 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isHappyNumber(0));
  }
}
