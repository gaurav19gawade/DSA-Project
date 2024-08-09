package FastAndSlowPointers;

/*
Circular array loop with improved time complexity
 */
public class CircularArryaLoopII {

  public static boolean detectCycle(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      boolean currentDirection = nums[i] > 0;
      int slow = i, fast = i;

      while (true){
        slow = nextStep(nums, currentDirection, slow);
        fast = nextStep(nums, currentDirection, fast);

        if (fast != -1) {
          fast = nextStep(nums, currentDirection, fast);
        }

        if (slow == -1 || fast == -1 || slow == fast) {
          break;
        }

        visited[slow] = true;
        if (fast != -1) visited[fast] = true;
      }

      if (slow != -1 && slow == fast) {
        return true;
      }

    }
    return false;
  }

  public static int nextStep(int[] nums, Boolean prevDirection, int currPointer) {
    boolean currentDirection = nums[currPointer] >= 0;

    //Condition to check if direction has not changed
    if (prevDirection != currentDirection) {
      return -1;
    }

    //Calculates next step
    int next = (currPointer + nums[currPointer]) % nums.length;
    if (next < 0) {
      next += nums.length;
    }

    //If new index is same as previous
    if (next == currPointer) {
      return -1;
    }
    return next;
  }

  public static void main(String[] args) {
    System.out.println(detectCycle(new int[]{1,3,-2,-4,1}));
  }
}

/*
public static boolean circularArrayLoop(int[] nums) {
  int n = nums.length;
  boolean[] visited = new boolean[n];

  for (int i = 0; i < n; i++) {
    if (visited[i]) continue;

    int slow = i, fast = i;
    boolean forward = nums[i] > 0;

    do {
      slow = nextIndex(nums, slow, forward);
      fast = nextIndex(nums, fast, forward);
      if (fast != -1) {
        fast = nextIndex(nums, fast, forward);
      }

      if (slow == -1 || fast == -1 || slow == fast) {
        break;
      }

      visited[slow] = true;
      if (fast != -1) visited[fast] = true;

    } while (true);

    if (slow != -1 && slow == fast) {
      return true;
    }
  }

  return false;
}

private static int nextIndex(int[] nums, int current, boolean forward) {
  boolean direction = nums[current] >= 0;
  if (direction != forward) return -1;

  int next = (current + nums[current]) % nums.length;
  if (next < 0) next += nums.length;
  if (next == current) return -1;

  return next;
}
*/