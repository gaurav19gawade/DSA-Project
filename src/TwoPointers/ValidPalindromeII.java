package TwoPointers;

public class ValidPalindromeII {
  public static boolean isPalindrome(String s) {
    int startPtr = 0;
    int endPtr = s.length() - 1;

    while (startPtr < endPtr) {
      if (s.charAt(startPtr) != s.charAt(endPtr)) {
        return checkPalindrome(startPtr + 1, endPtr, s) || checkPalindrome(startPtr, endPtr - 1, s);
      }
      endPtr--;
      startPtr++;
    }
    return true;
  }

  public static boolean checkPalindrome(int left, int right, String s) {
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "abcdefedbba";
    System.out.println(isPalindrome(s));
  }
}
