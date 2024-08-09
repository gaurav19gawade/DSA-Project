package TwoPointers;

import java.util.HashMap;

public class ValidWordAbbreviation {
  public static boolean validWordAbbreviation(String word, String abbr) {
    int wordPtr = 0;
    int abbrPtr = 0;

    while (abbrPtr < abbr.length() && wordPtr < word.length()) {
      if (word.charAt(wordPtr) == abbr.charAt(abbrPtr)) {
        wordPtr++;
        abbrPtr++;
      } else if (Character.isDigit(abbr.charAt(abbrPtr))) {
        if (abbr.charAt(abbrPtr) == '0') {
          return false;
        } else {
          int newIndex = 0;
          while(abbrPtr < abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))) {
            newIndex = (newIndex * 10) + Character.getNumericValue(abbr.charAt(abbrPtr));
            abbrPtr++;
          }
          wordPtr += newIndex;
        }
      } else {
        return false;
      }
    }
    return wordPtr == word.length() && abbrPtr == abbr.length();
  }

  public static void main(String[] args) {
    // "internationalization", "13iz4n"
    // "championship", "c06z"
    // "undergraduate", "u4r4te"
    // "abbreviation", "a34tion"

    HashMap<String, String> inputs = new HashMap<>();
    inputs.put("internationalization", "13iz4n");
    inputs.put("championship", "c06z");
    inputs.put("undergraduate", "u4r4te");
    inputs.put("abbreviation", "a34tion");
    inputs.put("z" , "2");

    for (String word : inputs.keySet()) {
      System.out.println("For word " + word +" result is - " + ValidWordAbbreviation.validWordAbbreviation(word, inputs.get(word)));
    }
  }
}
