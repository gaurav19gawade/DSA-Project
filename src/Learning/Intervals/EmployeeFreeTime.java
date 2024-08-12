package Learning.Intervals;

import Learning.Intervals.basePackage.Interval;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

  public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<int[]> allEmployeesTime = new ArrayList<>();
    List<Interval> result = new ArrayList<>();

    for(List<Interval> employee: schedule){
      for(Interval times: employee){
        allEmployeesTime.add(new int[]{times.start, times.end});
      }
    }

    //Sort times based on start time
    Collections.sort(allEmployeesTime, new Comparator<int[]>(){
      @Override
      public int compare(int[] a, int[] b){
        return Integer.compare(a[0], b[0]);
      }
    });

    int previousEndTime = allEmployeesTime.get(0)[1];

    for(int i = 1; i < allEmployeesTime.size(); i++){
      int currentStartTime = allEmployeesTime.get(i)[0];
      int currentEndTime = allEmployeesTime.get(i)[1];

      if(currentStartTime > previousEndTime){
        result.add(new Interval(previousEndTime, currentStartTime));
      }
      previousEndTime = Math.max(previousEndTime, currentEndTime);
    }

//    // Print sorted times
//    System.out.println("Employee free time");
//    for (Interval free : result) {
//      System.out.println("Start time "+free.start+ " End time "+free.end);
//    }

    return result;
  }

  public static void main(String[] args){
    List<List<Interval>> schedule = new ArrayList<>();

    // Create and add the first inner list
    List<Interval> firstList = new ArrayList<>();
    firstList.add(new Interval(1, 2));
    firstList.add(new Interval(5, 6));
    schedule.add(firstList);

    // Create and add the second inner list
    List<Interval> secondList = new ArrayList<>();
    secondList.add(new Interval(1, 3));
    schedule.add(secondList);

    // Create and add the third inner list
    List<Interval> thirdList = new ArrayList<>();
    thirdList.add(new Interval(4, 10));
    schedule.add(thirdList);
    employeeFreeTime(schedule);

  }



}
