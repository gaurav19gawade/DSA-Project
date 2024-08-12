package Learning.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length-2; i++) {
      if (i > 0 && nums[i] == nums[i-1]) {continue;}
      int start = i + 1;
      int end = nums.length - 1;

      while (start < end) {
        int totalSum = nums[i] + nums[start] + nums[end];
        if (totalSum == 0) {
          result.add(Arrays.asList(nums[i],nums[start],nums[end]));
          start++;
          while(start <= end && nums[start] == nums[start-1]){
            start++;
          }
        } else if (totalSum > 0) {
          end--;
        } else {
          start++;
        }

      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
  }
}
