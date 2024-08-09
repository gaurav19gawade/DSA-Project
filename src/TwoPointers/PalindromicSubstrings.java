package TwoPointers;

public class PalindromicSubstrings {

  public static int countSubstrings(String s) {
    int left = 0, right = 0, palindromeCount = 0;


    for(int i = 0; i < s.length(); i++) {

      left = right = i;

      while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
        palindromeCount++;
      }

      left = i;
      right = i +1;

      while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
        palindromeCount++;
      }

    }
    return palindromeCount;
  }

  public static void main(String[] args) {
    System.out.println(countSubstrings("aaa"));
  }
}
