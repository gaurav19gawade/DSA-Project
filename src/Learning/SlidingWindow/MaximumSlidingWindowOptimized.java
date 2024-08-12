package Learning.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaximumSlidingWindowOptimized {

  public static ArrayList<Integer> maxSlidingWindowOptimized(int[] nums, int k) {
    // first ---> [3,2,1,1] <--- last
    //first of the queue contains max element seen in window size so far
    //last has the least element in window so far
    //if window size is equal to the given window size remove elements from the first
    //we compare new element entering the queue to the index that is being pointed by last
    ArrayList<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {

      // check if we have reached the size of window
      if(!deque.isEmpty() && deque.peekFirst() == i - k) {
        deque.removeFirst();
      }

      // to check if the current element (index) which we want to insert is greater than the front of queue.
      // In this case element pointed by last
      while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }

      //as above conditions takes care of window size and maximum element property we just add the index
      deque.addLast(i);

      //if index has reached its desired size
      if (i >= k - 1) {
        res.add(nums[deque.peekFirst()]);
      }
    }

    int[] result = new int[res.size()];
    int i = 0;
    for(int re: result) {
      result[i] = re;
      i++;
    }
    System.out.println(result);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(maxSlidingWindowOptimized(new int[]{3, 1, 4, -3, 5, 3, 6, 7}, 3));
  }

}
