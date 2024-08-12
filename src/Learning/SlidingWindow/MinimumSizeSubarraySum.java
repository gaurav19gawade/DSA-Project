package Learning.SlidingWindow;

public class MinimumSizeSubarraySum {

  public static int minimumSizeSubArray(int[] arr, int target) {
    int windowSize = Integer.MAX_VALUE;
    int currentSum = 0;
    int start = 0;

    for (int i = 0; i < arr.length; i++) {
      currentSum += arr[i];

      while (currentSum >= target) {
        windowSize = Math.min(i - start + 1, windowSize);
        currentSum -= arr[start];
        start++;
      }
    }

    if (windowSize != Integer.MAX_VALUE) {
      return windowSize;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,1,2,4,3};
    int target = 7;
    System.out.println("Minimum subarray sum is "+ minimumSizeSubArray(arr, target));
  }
}
