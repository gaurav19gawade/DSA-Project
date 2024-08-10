package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {

  public static int[][] intervalIntersection(int[][] intervalLista, int[][] intervalListb) {
    int pointerA = 0, pointerB = 0;
    List<int[]> result = new ArrayList<>();

    while(pointerA < intervalLista.length && pointerB < intervalListb.length) {
      int latestStartTime = Math.max(intervalLista[pointerA][0], intervalListb[pointerB][0]);
      int EarliestEndTime = Math.min(intervalLista[pointerA][1], intervalListb[pointerB][1]);

      if(latestStartTime <= EarliestEndTime) {
        int[] overlap = new int[2];
        overlap[0] = latestStartTime;
        overlap[1] = EarliestEndTime;
        result.add(overlap);
      }

      if (intervalLista[pointerA][1] < intervalListb[pointerB][1]) {
        pointerA++;
      }else{
        pointerB++;
      }
    }
    return result.toArray(new int[0][]);
  }

  public static void main(String[] args) {
    int[][] intervalLista = {{1,4},{5,6},{7,8},{9,15}};

    int[][] intervalListb = {{2,4},{5,7},{9,15}};

    System.out.println("Intersection is " + Arrays.deepToString(intervalIntersection(intervalLista, intervalListb)));
  }

}
