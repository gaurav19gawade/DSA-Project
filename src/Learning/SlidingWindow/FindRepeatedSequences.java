package Learning.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences{

  public static Set<String> findRepeatedSequences(String dna, int k) {

    HashSet<String> res = new HashSet<>();
    HashSet<String> output = new HashSet<>();

    for (int i = 0; i <= dna.length() - k; i++) {
      String s = dna.substring(i, i + k);
      if (res.contains(s)) {
        output.add(s);
      } else {
        res.add(s);
      }
    }
    return output;
  }

  public static void main(String[] args) {
    String dna = "AACCAA";
    System.out.println(findRepeatedSequences(dna, 2));
  }
}
