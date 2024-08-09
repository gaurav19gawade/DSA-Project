package SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {

  public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i <= nums.length - k; i++) {
      int maxSize = i + k, j = i;
      while(j < maxSize) {
        maxHeap.add(nums[j]);
        j++;
      }
      list.add(maxHeap.peek());
      maxHeap.clear();
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }
}
