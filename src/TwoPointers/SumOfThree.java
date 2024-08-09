package TwoPointers;

import java.util.Arrays;

public class SumOfThree {

  public static boolean findSumOfThree(int[] nums, int target) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int firstNum = nums[i];
      int firstPointer = i + 1;
      int lastPointer = nums.length - 1;

      while (firstPointer < lastPointer) {
        int totalSum = firstNum + nums[firstPointer] + nums[lastPointer];
        if (totalSum == target) {
          return true;
        }

        if (totalSum > target) {
          lastPointer --;
        }

        if (totalSum < target) {
          firstPointer++;
        }
      }

    }
    return false;
  }

  public static void main(String[] args) {
    int[] arrays = {1,-1,0};

  SumOfThree obj = new SumOfThree();
  Boolean result = obj.findSumOfThree(arrays, -1);
  System.out.println(result);
  }
}
