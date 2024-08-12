package Learning.TwoPointers;

public class ReverseWords {

  public static String reverseWords(String str) {
    String[] words = str.trim().split("\\s+");
    StringBuilder result = new StringBuilder();
    int start = 0;
    int end = words.length - 1;

    while(start < end) {
      String temp = words[start];
      words[start] = words[end];
      words[end] = temp;
      start++;
      end--;
    }

    for (int i = 0; i < words.length; i++) {
      result.append(words[i]);
      if (i < words.length - 1) { //adding space between words until i reaches final word
        result.append(" ");
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String s = " uwllkmwrgtouodjnenuawaqqkpbthajsfzzyy ssqdwnmyhjkwupqcbbmmhwctmzfqfmyrcqnpwornacmbwpkizwngat xyrvvsckkxulselcjw puefau mrmzfeibgwytnwqcwhyidubrgwoqvtojlgfwci ethnzypoztnm ";
    System.out.println(ReverseWords.reverseWords(s));
  }
}
