package Learning.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FindingAllAnagramsInString {

  public static List<Integer> findAnagrams(String s, String p) {

    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length()) return result;
    HashMap<Character, Integer> pMap = new HashMap<>();
    HashMap<Character, Integer> sMap = new HashMap<>();


    //initial window
    for(int i = 0; i < p.length(); i++) {
      pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
    }

    if(pMap.equals(sMap)){
        result.add(0);
    }

    for(int i = p.length(); i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);

      char charRemove = s.charAt(i-p.length());
      sMap.put(charRemove, sMap.getOrDefault(charRemove, 0)-1);

      if(sMap.get(charRemove) == 0){
        sMap.remove(charRemove);
      }

      if(sMap.equals(pMap)) {
        result.add(i-p.length()+1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
  }
}
