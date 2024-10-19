package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Python tuples are immutable and hashable by default. When you create a tuple from a list of integers, Python can use this tuple directly as a dictionary key. It compares tuples element by element, so two tuples with the same elements in the same order are considered equal and will hash to the same value.
Java Implementation:
In Java, we can't use an int[] array directly as a HashMap key because:
a. Arrays in Java use reference equality, not value equality. Two arrays with the same content are not considered equal.
b. Java arrays don't override the hashCode() and equals() methods, which are crucial for HashMap keys.
That's why in our Java solution, we converted the int[] to a String:
 */

public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();

    for (String s : strs) {
      char[] charCount = new char[26];
      for (char c : s.toCharArray()) {
        charCount[c - 'a']++;
      }
      String key = new String(charCount);

      anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(anagramMap.values());
  }

  public static void main(String[] args){
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    groupAnagrams(strs);
  }
}
