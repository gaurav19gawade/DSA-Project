package Learning.ModifiedBinarySearch;

public class BinarySearch {

  public static int search(int[] arr, int target) {
    return binarySearchHelper(arr, arr.length-1, 0, target);
  }

  public static int binarySearchHelper(int[] arr, int high, int low, int target){

    while(low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target){
        return mid;
      }else if (target > arr[mid]){
        low = mid + 1;
      }else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    System.out.println("Index of target elements is "+ search(new int[]{1,2,3,4,5}, 6));
  }
}
