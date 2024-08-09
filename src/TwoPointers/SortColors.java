package TwoPointers;

import java.util.Arrays;

public class SortColors {

  public static void swapElements(int index1, int index2, int[] arr) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  public static int[] sortColors(int[] colors) {
    int start = 0, current = 0, end = colors.length - 1;

    while (current <= end) {
      if (colors[current] == 0) {
        swapElements(start, current, colors);
        start++;
        current++;
      } else if (colors[current] == 1) {
        current++;
      } else if (colors[current] == 2) {
        swapElements(end, current, colors);
        end--;

      }
    }
    return colors;
  }

  public static void main(String[] args) {
    int[] colors = {0, 1, 0};
    int[] result = SortColors.sortColors(colors);
    System.out.println(Arrays.toString(result));
  }
}
