package Learning.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {

  static HashMap<Integer, List<Integer>> courseMap = new HashMap<>();

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    courseMap.clear();
    HashSet<Integer> black = new HashSet<>(); // Processed
    HashSet<Integer> grey = new HashSet<>(); // Currently processing
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      courseMap.put(i, new ArrayList<>());
    }

    for (int[] course : prerequisites) {
      courseMap.get(course[0]).add(course[1]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (!black.contains(i)) {
        if (!dfs(black, grey, result, i)) {
          return new int[0];
        }
      }
    }

    int[] order = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      order[i] = result.get(i);
    }

    return order;
  }

  public static boolean dfs(HashSet<Integer> black, HashSet<Integer> grey, List<Integer> result, int current) {
    if (grey.contains(current)) {
      return false; // cycle detected
    }
    if (black.contains(current)) {
      return true; // already processed
    }

    grey.add(current);
    for (int course : courseMap.get(current)) {
      if (!dfs(black, grey, result, course)) {
        return false;
      }
    }

    grey.remove(current);
    black.add(current);
    result.add(current); // Add to the result in topological order
    return true;
  }

  public static void main(String[] args) {
    int[][] courses = {{0, 1}};
    System.out.println("Course order: " + Arrays.toString(findOrder(2, courses)));
  }
}
