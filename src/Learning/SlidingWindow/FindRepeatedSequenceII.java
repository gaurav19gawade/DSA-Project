package Learning.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// implemented using rabin karp algorithm which is rolling hash
public class FindRepeatedSequenceII {

  public static Set<String> findRepeated(String s, int k) {
    int baseValue = 4;
    int hashValue = 0;
    HashMap<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("C", 2);
    map.put("G", 3);
    map.put("T", 4);
//    "ACGAATTCCG" ACG - 27; CGA = [H(ACG) - H(A)] * 4 + H(A) = [[27 - 16] * 4] + [1] = 45?
//    H(CGA) = (4^2 * 2) + (4^1 * 3) + (4^0 * 1) = (32 + 12 + 1) = 45

    HashSet<Integer> hashSet = new HashSet<>();
    HashSet<String> output = new HashSet<>();


    for (int i = 0; i < s.length() - k + 1; i++) {
      if (i == 0) {
        for (int j = 0; j < k ; j++) {
          hashValue += map.get(Character.toString(s.charAt(j))) * (int)Math.pow(baseValue, k - j  -1);
        }
      } else {
        int previousHash = hashValue;
        hashValue = ((previousHash - (map.get(Character.toString(s.charAt(i-1))) * (int) Math.pow(baseValue, k - 1))) * baseValue)
            + map.get(Character.toString(s.charAt(i + k - 1)));
      }

    if (hashSet.contains(hashValue)) {
      output.add(s.substring(i, i+k));
    }

    hashSet.add(hashValue);
    }

    return output;
  }

  public static void main(String[] args) {
    System.out.println("Return value is " + findRepeated("ACGAATTCCG", 3));
  }
}
