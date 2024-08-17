package Learning.Stringss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
  public static String largestNumber(int[] nums) {
    StringBuilder sb = new StringBuilder();
    String[] numbers = Arrays
        .stream(nums)
        .mapToObj(String::valueOf)
        .toArray(String[]::new);

    Arrays.sort(numbers, new Comparator<String>(){
      @Override
      public int compare(String a, String b){
        String order1 = a+b;
        String order2 = b+a;
        return order2.compareTo(order1);
      }
    });

    for(String s: numbers){
      sb.append(s);
    }
    String result = sb.toString();
    if (result.charAt(0) == '0') {
      return "0";
    }
    return result;
  }

  public static void main(String[] args){
    int[] nums = {8308,8308,830};
    System.out.println("Largest number is " + largestNumber(nums));
  }
}
