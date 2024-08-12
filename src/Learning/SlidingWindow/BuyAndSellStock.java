package Learning.SlidingWindow;

public class BuyAndSellStock {

  public static int buyStock(int[] arr) {
    int maxProfit = Integer.MIN_VALUE;
    int start = 0;

    for (int i = 0; i < arr.length; i++) {
      maxProfit = Math.max(maxProfit, arr[i] - arr[start]);
      if (arr[i] < arr[start]) {
        start = i;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] arr = {7,1,5,3,6,4};
    System.out.println("Maximum profit is " + buyStock(arr));
  }
}
