package Learning.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Here we need to processs more frequent character first because that will give us more idle time
//eg i/p = [A,A,A,B,B,C,C] -> {A:3, B:2, C:2} , n = 1 idle time between identicle tasks
//Lets say we process C first, then CBCBA_A_A; total units of time - 9
//if we start with most frequent characters
//ABCABCA - total units of time - 7 these reduces idle time

/*
Let's analyze the example [A, A, A, B, B, C, C] with a cooldown period n = 2 in detail.
A _ _ A _ _ A

Number of Gaps:
The number of gaps between the As is calculated as maxFreq - 1:
maxFreq - 1 = 3 - 1 = 2.
So, there are 2 gaps.

Potential Idle Time:
Since n = 2, each gap must have 2 idle slots.
Therefore, the total potential idle time is 2 gaps * 2 (n) = 4 idle slots.

 */

public class TaskScheduler {

  public static int leastTime(char[] tasks, int n) {
    int[] frequencies = new int[26]; // Array to store the frequency of each task, assuming tasks are named from A-Z

    // Count the frequency of each task
    for (char task : tasks) {
      frequencies[task - 'A']++;
    }

    Arrays.sort(frequencies); // Sort the array to get the task with the highest frequency at the end

    int maxFreq = frequencies[25]; // The highest frequency task is now at the last index (25)

    // Calculate the total idle slots required between the most frequent tasks
    // maxFreq - 1 gives the number of gaps between the most frequent tasks
    // Multiply by n (cooldown period) to get the total number of idle slots
    int idleSlots = (maxFreq - 1) * n;

    // Try to fill the idle slots with the remaining tasks
    for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
      // For each remaining task, reduce the idleSlots by the smaller value between:
      // 1) the frequency of the current task (frequencies[i])
      // 2) maxFreq - 1, since we can only place up to (maxFreq - 1) tasks in these gaps
      idleSlots -= Math.min(frequencies[i], maxFreq - 1);
    }

    // If there are no idle slots left, the time required is just the length of the tasks array
    // Otherwise, we add the remaining idleSlots to the total time
    return Math.max(tasks.length, tasks.length + idleSlots);
  }


  public static void main(String[] args){
    char[] tasks = {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'};
    System.out.println("Units of time required for given tasks are "+leastTime(tasks, 2));
  }

}

/*
Simulation example -

Tasks: {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}
Frequencies:
D: 3
X: 2
A: 1, K: 1, M: 1, W: 1, B: 1, C: 1, O: 1, Z: 1, E: 1, Q: 1

Sorted Frequencies (desc): [3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Arrange the Most Frequent Task (D)
D _ _ D _ _ D => associates with this line of code -> int idleSlots = (maxFreq - 1) * n;

Gaps (Idle Slots) Calculation:
maxFreq - 1 = 3 - 1 = 2 gaps.
Each gap must have n = 2 slots, so 2 * 2 = 4 total idle slots.

Filling remaining gaps by processing remaining tasks
D X _ D X _ D

idleSlots -= Math.min(frequencies[i], maxFreq - 1);
idleSlots = (4(idle slots) - minimum(2, (3-1))) = 2

Remaining Idle Slots: 4 - 2 = 2.



 */
