package Learning.Stringss;

import java.util.Arrays;

public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
      String firstWord = strs[0];
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i < firstWord.length()){
      for(int j = 1; j < strs.length; j++){
        String currentWord = strs[j];
        if(i >= currentWord.length() || currentWord.charAt(i) != firstWord.charAt(i)){
          return sb.toString();
        }
      }
      sb.append(firstWord.charAt(i));
      i++;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println("Longest prefix is "+longestCommonPrefix(new String[]{"flower","flow","flight"}));
  }
}
