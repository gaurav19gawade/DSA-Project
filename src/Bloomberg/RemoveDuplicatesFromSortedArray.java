package Bloomberg;

/*
Left is basically keeping track of duplicate values
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int left = 1;

    for(int right = 1; right < nums.length; right++){
      if(nums[right] != nums[right-1]){
        nums[left] = nums[right];
        left++;
      }
    }
    return left;
  }

  public static void main(String[] args){
    RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
    int[] arr = {0,0,1,1,1,2,2,3,3,4};
    r.removeDuplicates(arr);
  }
}
