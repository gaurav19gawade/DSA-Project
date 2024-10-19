package Bloomberg;

public class TrappingRainWater {
  /*
  at each element in height array which represents the height of the building,
  We keep track of max height to the left of that current building and max heigh to the
  right of that current building
   */
  public int trap(int[] height) {
    int[] leftToRight = new int[height.length];
    int[] rightToLeft = new int[height.length];
    int totalHeight = 0;

    leftToRight[0] = height[0];
    rightToLeft[height.length-1] = height[height.length-1];

    for(int i = 1; i < height.length; i++){
      leftToRight[i] = Math.max(leftToRight[i-1], height[i]);
    }

    for(int i = height.length-2; i >= 0; i--){
      rightToLeft[i] = Math.max(rightToLeft[i+1], height[i]);
    }
    for(int i = 0; i < height.length; i++){
      totalHeight += (Math.min(leftToRight[i], rightToLeft[i]) - height[i]);
    }
    return totalHeight;
  }

  public static void main(String[] args){
    int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    TrappingRainWater tp = new TrappingRainWater();
    tp.trap(arr);
  }
}
