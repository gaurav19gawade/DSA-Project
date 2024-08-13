package Practice;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

  public static int characterReplacement(String s, int k) {
    int windowSize = Integer.MIN_VALUE, frequencyOfRepeatingChar = 0, start = 0, end=0;
    HashMap<Character, Integer> map = new HashMap<>();

    while(end < s.length()) {
      map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);

      if(map.get(s.charAt(end)) > frequencyOfRepeatingChar){
        frequencyOfRepeatingChar = map.get(s.charAt(end));
      }

      if((end-start+1) - frequencyOfRepeatingChar <= k){
        windowSize = Math.max(windowSize, end-start+1);
      } else {
        map.put(s.charAt(start), map.get(s.charAt(start))-1);
        start++;
      }
      end++;
    }

    return windowSize;
  }

  public static void main(String[] args){
    String s = "ABAA";
    int k = 0;
    System.out.println("Window size "+characterReplacement(s, k));
  }
}
