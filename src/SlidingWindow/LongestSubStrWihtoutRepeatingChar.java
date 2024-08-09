package SlidingWindow;
import java.util.HashSet;

public class LongestSubStrWihtoutRepeatingChar {

  public static int findLongestSubStr(String str) {
    int start = 0;
    HashSet<Character> seen = new HashSet<>();
    int minSubStr = Integer.MIN_VALUE;

    for (int i = 0; i < str.length(); i++) {
      while(seen.contains(str.charAt(i))) {
        seen.remove(str.charAt(start));
        start++;
      }
      minSubStr = Math.max(minSubStr, i - start + 1);
      seen.add(str.charAt(i));
    }
    return minSubStr;
  }

  public static void main(String[] args) {
    System.out.println(findLongestSubStr("aba"));
  }
}
