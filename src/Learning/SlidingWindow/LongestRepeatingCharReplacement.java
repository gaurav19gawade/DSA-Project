package Learning.SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

  public static int windowLength(String s, int k) {
    int maxWindowLength = Integer.MIN_VALUE;
    HashMap<String, Integer> map = new HashMap<>();
    int freqOfRepeatingChars = 0;
    int start =0, end = 0;

    while (end < s.length()) {
      if(!map.containsKey(Character.toString(s.charAt(end)))) {
        map.put(Character.toString(s.charAt(end)), 1);
      } else {
        map.put(Character.toString(s.charAt(end)), map.get(Character.toString(s.charAt(end))) + 1);
      }

      if (map.get(Character.toString(s.charAt(end))) > freqOfRepeatingChars) {
        freqOfRepeatingChars = map.get(Character.toString(s.charAt(end)));
      }

      if (end - start + 1 - freqOfRepeatingChars <= k) {
        maxWindowLength = Math.max(maxWindowLength, end - start + 1);
      } else {
        map.put(Character.toString(s.charAt(start)), map.get(Character.toString(s.charAt(start))) - 1);
        start++;
      }
      end ++;
    }

  return maxWindowLength;
  }

  public static void main(String[] args) {
    System.out.println(windowLength("aabccbb", 2));
  }
}
