package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

  public static int[][] insertingIntervals(int[] newInterval, int[][] existingIntervals) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = existingIntervals.length;

    //add existing intervals that occurs before new interval
    while(i < n && existingIntervals[i][1] < newInterval[0]) {
      result.add(existingIntervals[i]);
      i++;
    }

    //Merge overlapping intervals
    while(i < n && newInterval[1] >= existingIntervals[i][0]) {
      newInterval[0] = Math.min(newInterval[0], existingIntervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], existingIntervals[i][1]);
      i++;
    }

    result.add(newInterval);

    //add remaining intervals
    while(i < n) {
      result.add(existingIntervals[i]);
      i++;
    }

    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
    int[][] existingIntervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] newInterval = {4, 8};
    System.out.println(
        "New Intervals list is " + Arrays.deepToString(insertingIntervals(newInterval, existingIntervals)));
  }
}
