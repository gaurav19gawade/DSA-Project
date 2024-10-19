package Bloomberg;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int maxLength = 0;
    String result = "";
    for(int i = 0; i < s.length(); i++){
      //odd length
      String palindrome = isPalindrome(i,i,s);
      if(maxLength < palindrome.length()){
        result = palindrome;
        maxLength = palindrome.length();
      }

      //even length
      palindrome = isPalindrome(i,i+1,s);
      if(maxLength < palindrome.length()){
        result = palindrome;
        maxLength = palindrome.length();
      }
    }
    return result;
  }

  public String isPalindrome(int left, int right, String s){
    while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
      left--;
      right++;
    }
    return s.substring(left+1, right);
  }

  public static void main(String[] args){
    LongestPalindromicSubstring p = new LongestPalindromicSubstring();
    p.longestPalindrome("babad");
  }
}
