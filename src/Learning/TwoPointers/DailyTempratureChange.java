package Learning.TwoPointers;

import java.util.Arrays;
import java.util.Stack;

public class DailyTempratureChange {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] results = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for(int i =0; i< temperatures.length; i++) {
      while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
        results[stack.peek()] = i - stack.peek();
        stack.pop();
      }
      stack.push(i);
    }
    return results;
  }

  public static void main(String[] args){
    int[] temperatures = {73,74,75,71,69,72,76,73};
    System.out.println("Temprature Changes are - "+ Arrays.toString(dailyTemperatures(temperatures)));
  }
}
