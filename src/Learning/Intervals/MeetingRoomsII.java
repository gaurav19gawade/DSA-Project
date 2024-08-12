package Learning.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public static int findSets(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //sorting intervals based on first value
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(intervals[0][1]); //push end time of first interval

    for(int i = 1; i < intervals.length; i++){
      int startTimeCurrentInterval = intervals[i][0];
      int endTimeCurrentInterval = intervals[i][1];
      int topOfHeap = minHeap.peek();

      //Check for overlap
      if(startTimeCurrentInterval >= topOfHeap) {
        minHeap.poll();
      }
      minHeap.offer(endTimeCurrentInterval);
    }
    return minHeap.size(); // this indicates number of meeting rooms
  }

  public static void main(String[] args){
    int[][] intervals = {{2,8},{3,4},{5,11},{8,20},{11,15}};
    System.out.println("No of meeting rooms required -" + findSets(intervals));
  }
}
