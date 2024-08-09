package TwoPointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NumberOfVisiblePeopeInQueue {

  public static int[] canSeePersonsCount(int[] heights) {
    Deque<Integer> tallest = new ArrayDeque<>();
    int[] personView = new int[heights.length];

    for(int i = heights.length-1; i >=0; i--) {
      while(!tallest.isEmpty() && heights[i] > tallest.peek()) {
        personView[i]++;
        tallest.pop();
      }

      if(!tallest.isEmpty()) {
        personView[i]++;
      }

      tallest.push(heights[i]);
    }
    return personView;
  }

  public static void main(String[] args) {
    int[] heights = {10,6,8,5,11,9};
    System.out.println("Array is " + Arrays.toString(canSeePersonsCount(heights)));
  }
}
