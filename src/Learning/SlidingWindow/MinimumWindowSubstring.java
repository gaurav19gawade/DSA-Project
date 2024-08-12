package Learning.SlidingWindow;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {

  public static String minWindow(String s, String t) {
    HashMap<Character, Integer> currentWindow = new HashMap<>();
    HashMap<Character, Integer> reqCount = new HashMap<>();
    int required, current = 0, start = 0, minimumWindowLength = Integer.MAX_VALUE;

    int[] result = {-1, -1};

    for (int i = 0; i < t.length(); i++) {
      reqCount.put(t.charAt(i), 1 + reqCount.getOrDefault(t.charAt(i), 0));
    }

    required = reqCount.size();

    for (int i = 0; i < s.length(); i++) {
      currentWindow.put(s.charAt(i), 1 + currentWindow.getOrDefault(s.charAt(i), 0));

      if (reqCount.containsKey(s.charAt(i)) &&
          Objects.equals(currentWindow.get(s.charAt(i)), reqCount.get(s.charAt(i)))) {
        current++;
      }

      while (current == required) {
        // If this window is smaller than the smallest found so far
        if ((i - start + 1) < minimumWindowLength) {
          minimumWindowLength = i - start + 1;
          result[0] = start;
          result[1] = i;
        }

        char startChar = s.charAt(start);
        currentWindow.put(startChar, currentWindow.get(startChar) - 1);

        if (reqCount.containsKey(startChar) && currentWindow.get(startChar) < reqCount.get(startChar)) {
          current--;
        }

        start++;
      }
    }
    return result[0] == -1 ? "" : s.substring(result[0], result[1] + 1);
  }


  public static void main(String[] args) {
    System.out.println("Minimum window size is " + minWindow("ADOBECODEBANC", "ABC"));
  }

}
