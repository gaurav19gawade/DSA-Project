package Practice;

public class ContainersWithMostWater {

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
