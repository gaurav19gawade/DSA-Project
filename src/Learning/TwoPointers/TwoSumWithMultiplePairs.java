package Learning.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumWithMultiplePairs {

  public static List<List<Integer>> twoSumPairs(int[] arr, int target){
    HashMap<Integer, Integer> map = new HashMap<>();
    Set<List<Integer>> finalList = new HashSet<>();
    for(int index = 0; index < arr.length; index++){
      int diff = target - arr[index];
      if(map.containsKey(diff)){
        //We are math.min and max to keep pairs unique
        //if we just add diff and arr[index] it would have pairs like 3,4 or 4,3
        List<Integer> innerList = Arrays.asList(Math.min(diff, arr[index]), Math.max(arr[index], diff));
        finalList.add(innerList);
      }
      map.put(arr[index], index);
    }
    return new ArrayList<>(finalList);
  }

  public static void main(String[] args){
    int[] arr = {2,3,4,5,2,9};
    twoSumPairs(arr, 7);
  }
}
