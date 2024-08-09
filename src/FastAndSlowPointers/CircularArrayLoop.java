package FastAndSlowPointers;

/*
Algortihm to detect cycle in the array -

i. for every element in the array, we are using fast pointer and a slow pointer pointing at that index.
ii. we move the slow index once to the index where value of the current index points to
ii.1 we then check if the direction of value at new index is in opposite direction to previous index; if yes that's a cycle
iii. Similarly, we do ii and ii.1 on fast index but twice
iv. now if fast index and slow index meet we indicate that there is a cycle and return True
 */

/*
The use of % operator in int result = (pointer + value) % size;:
This operation is performing a "circular" or "wraparound" indexing. Here's what it does:

It adds the current pointer position and the value at that position.
Then it uses the modulo operator to ensure the result stays within the bounds of the array.
If the sum goes beyond the array size, it wraps around to the beginning of the array.

For example, if the array size is 6 and we're at index 4 with a value of 3:
(4 + 3) % 6 = 1
This means we move from index 4 to index 1, wrapping around the end of the array.

The condition Math.abs(nums[pointer] % nums.length) == 0:
This condition checks if the current element would cause a cycle of length 1,
which is not considered a valid cycle in this problem.

By using modular arithmetic, we're essentially creating a mathematical model that perfectly represents the
circular nature of the array in this problem, allowing us to navigate it as if it were a continuous loop regardless
of its actual linear structure in memory.
 */


public class CircularArrayLoop {
  public static boolean circularArrayLoop(int[] nums) {
    //[2, 5, -4, 3, -1, 4]
    int size  = nums.length;

    for (int i = 0; i < size; i++) {
      int slow = i, fast = i;
      boolean forward = nums[i] > 0;

      while (true) {
        slow = nextStep(slow, nums[slow], size);
        if (isNotCycle(nums, forward, slow)) {
          break;
        }

        fast = nextStep(fast, nums[fast], size);
        if (isNotCycle(nums, forward, fast)) {
          break;
        }

        fast = nextStep(fast, nums[fast], size);
        if (isNotCycle(nums, forward, fast)) {
          break;
        }

        if (fast == slow) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isNotCycle(int[] nums, Boolean prevDirection, int pointer) {
      boolean currenrDirection = nums[pointer] >= 0;
      return  (currenrDirection != prevDirection || Math.abs(nums[pointer] % nums.length) == 0);
  }

  public static int nextStep(int pointer, int value, int size) {
    int result = (pointer + value) % size;
    /*
    This condition is crucial for handling negative values correctly
    in the modular arithmetic system we're using.
    Example:
    Let's say we have an array of size 5 and we're at index 0 with a value of -1:
    Initial calculation: (0 + (-1)) % 5 = -1
    After adjustment: -1 + 5 = 4
    So we correctly end up at the last index of the array.
     */
    if (result < 0) {
      result += size;
    }
    return result;
  }



  public static void main(String[] args) {
    Boolean result = circularArrayLoop(new int[]{2, 5, -4, 3, -1, 4});
  }
}
