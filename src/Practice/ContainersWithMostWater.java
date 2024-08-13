package Practice;

public class ContainersWithMostWater {
  /*
  Given an array of heights which indicates height of container, we need to find the containers with max area.

  We use left and right pointers, pointing to the exterems and traversing inwards.
  at each step we calculate the maximum height using max height and length cal as (right - left)
   */

  public static int maxArea(int[] height) {
    int left = 0, right = height.length-1, area = 0;

    while(left < right) {
      area = Math.max(area, (right-left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]){
        left++;
      } else {
        right--;
      }
    }
    return area;
  }

  public static void main(String[] args){
    int[] height = {1,8,6,2,5,4,8,3,7};
    System.out.println("Most water "+maxArea(height));
  }
}
