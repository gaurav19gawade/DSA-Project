package Practice;

/*
Given a list of non-overlapping intervals with start and end time which are sorted order, we
need to insert a new interval while keeping original data in sorted order


We first add the intervals that appear before this new inteval in the result array
We also merge the overlapping sub intervals
Remaining intervals are then added to the result array
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

  public static int[][] insertNewInterval(int[][] interval, int[] newInterval){
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int size = interval.length;

    while(i < size && newInterval[0] > interval[i][1]) {
      result.add(new int[]{interval[i][0], interval[i][1]});
      i++;
    }


    //check for overlaps
    while(i < size && newInterval[1] >= interval[i][0]) {
      newInterval[0] = Math.min(newInterval[0], interval[i][0]);
      newInterval[1] = Math.max(newInterval[1], interval[i][1]);
      i++;
    }

    //Add the merged interval
    result.add(newInterval);


    while (i < size) {
      result.add(interval[i]);
      i++;
    }
    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
    int[][] existingIntervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] newInterval = {4, 8};
    System.out.println(
        "New Learning.Intervals list is " + Arrays.deepToString(insertNewInterval(existingIntervals, newInterval)));
  }
}
