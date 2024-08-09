package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static int[][] intervalsMerged(int[][] intervals) {
    List<int[]> output = new ArrayList<>();
    output.add(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int[] lastIntervalOfOutput = output.get(output.size() - 1);

      if (interval[0] <= lastIntervalOfOutput[1]) {
        output.set(output.size()-1, new int[]{lastIntervalOfOutput[0], Math.max(lastIntervalOfOutput[1], interval[1])});
      } else {
        output.add(interval);
      }
    }

    int[][] result = new int[output.size()][2];

    for(int i = 0; i < output.size(); i++) {
      int[] currentArray = output.get(i);

      for (int j = 0; j < currentArray.length; j++) {
        result[i][j] = currentArray[j];
      }
    }

    return result;
  }

  public static void main(String[] args){
    int[][] intervals = {{1,5},{3,7},{4,6}};
    System.out.println("Merged interval is "+ Arrays.deepToString(intervalsMerged(intervals)));
  }

}
