package FastAndSlowPointers;

public class FindDuplicate {

  public static int findDuplicate(int[] nums) {
    // 0,1,2,3,4
    //slow,,,fast
    int slow = nums[0], fast = nums[0];
    int size = nums.length;
    while (true) {
      fast = nums[nums[fast]] % size;
      slow = nums[slow] % size;
      if (slow == fast) {
        break;
      }
    }
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow] % size;
      fast = nums[fast] % size;
    }

    return fast;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,3,4,2,5};
    System.out.println(findDuplicate(nums));
  }
}
