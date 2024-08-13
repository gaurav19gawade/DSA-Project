package Practice;

import java.util.HashMap;
import java.util.Objects;

/*
We have two strings S and T of size m and n respectively; We need to find window of minimum size in S such that it
contains all characters of T.

s = "ADOBECODEBANC", t = "ABC"

We will have hashmap created for T as a frequency of characters in t.
Another hashmap te keep frequency of characters in current window.
We will need a requiredCount variable to indicate minimum variables required.

We start by expanding the window from the right pointer and add variable seen to the current window map.
we only increment requiredCount when frequency of variable in pointer
at current window equals its frequency in required window.

While requiredCount matches size of required hashmap (which is the minimum size of window)
we calculate the minimum window
start reducing the size of window from left and at the same time reduce its frequency in current window map
The required count is only reduced when character we are removing from current window has frequency less than what is
in required window map.

 */
public class MinimumWindowSubstring {

  public static String minWindow(String s, String t) {
    int left = 0, right = 0, currentCount = 0, minWindowLength = Integer.MAX_VALUE;
    int[] windowSize = {-1,-1};



    HashMap<Character, Integer> required = new HashMap<>();
    HashMap<Character, Integer> currentWindowMap = new HashMap<>();

    for(int i = 0; i < t.length(); i++){
      required.put(t.charAt(i), required.getOrDefault(t.charAt(i),0)+1);
    }

    while(right < s.length()){
      currentWindowMap.put(s.charAt(right),currentWindowMap.getOrDefault(s.charAt(right), 0)+1);
      if(required.containsKey(s.charAt(right))
          && Objects.equals(currentWindowMap.get(s.charAt(right)),required.get(s.charAt(right)) )) {
        currentCount++;
      }

      while(currentCount == required.size()){

        if(right-left+1 < minWindowLength) {
          windowSize[0] = left;
          windowSize[1] = right;
        }

        currentWindowMap.put(s.charAt(left),currentWindowMap.get(s.charAt(left))-1);

        if(required.containsKey(s.charAt(left)) && currentWindowMap.get(s.charAt(left))
            < required.get(s.charAt(left))){
          currentCount--;
        }
        left++;
      }
      right++;
    }
    return windowSize[0] == -1 ? "" : s.substring(windowSize[0], windowSize[1] + 1);
  }

  public static void main(String[] args){
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}
