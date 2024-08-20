package Learning.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Problem: Course Schedule

Given a number of courses and their prerequisites, determine if it's possible to complete all courses.

Input:
- numCourses: total number of courses
- prerequisites: array of [course, prerequisite] pairs

Output:
- boolean: true if all courses can be completed, false otherwise

Solution Approach:
1. Represent the courses and prerequisites as a directed graph using an adjacency list.
2. Use Depth-First Search (DFS) to detect cycles in the graph.
3. Implement a DFS-based cycle detection algorithm.

Algorithm:
1. Create an adjacency list (HashMap) where each course maps to its list of prerequisites.
2. Use three data structures to track the state of each course:
   - Grey set: Courses currently being processed (in the current DFS path).
   - Black set: Courses that have been fully processed.
   - ArrayList: To accumulate the topological order (optional, for consistency with Course Schedule II).
3. Perform DFS for each course:
   - If the course is in the Grey set, a cycle is detected; return false.
   - If the course is in the Black set, it is already processed; skip to the next course.
   - Recursively process all prerequisites.
   - After processing all prerequisites, move the course from Grey to Black set and add it to the result list (if required).
4. If DFS completes for all courses without detecting a cycle, return true.

Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites.
Space Complexity: O(V) for the adjacency list, sets, and optional result list.

Note: This solution checks for cycles in the directed graph to determine if the course schedule is feasible. A cycle in the graph indicates an impossible prerequisite relationship, making it impossible to complete all courses.
*/


public class CourseSchedule {

  static HashMap<Integer, List<Integer>> courseMap = new HashMap<>();

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    courseMap.clear();
    HashSet<Integer> black = new HashSet<>(); // Processed
    HashSet<Integer> grey = new HashSet<>(); // Currently processing
    ArrayList<Integer> result = new ArrayList<>(); // Accumulating the courses processed

    for (int i = 0; i < numCourses; i++) {
      courseMap.put(i, new ArrayList<>());
    }

    // Build the graph
    for (int[] course : prerequisites) {
      courseMap.get(course[0]).add(course[1]);
    }

    // Perform DFS for each course
    for (int i = 0; i < numCourses; i++) {
      if (!black.contains(i)) {
        if (!dfs(black, grey, result, i)) {
          return false; // Cycle detected
        }
      }
    }

    return true; // No cycle detected, all courses can be completed
  }

  public static boolean dfs(HashSet<Integer> black, HashSet<Integer> grey, List<Integer> result, int current) {
    if (grey.contains(current)) {
      return false; // Cycle detected
    }
    if (black.contains(current)) {
      return true; // Already processed
    }

    grey.add(current);
    for (int course : courseMap.get(current)) {
      if (!dfs(black, grey, result, course)) {
        return false;
      }
    }

    grey.remove(current);
    black.add(current);
    result.add(current); // Optional: Add to result to mirror the other problem's structure
    return true;
  }

  public static void main(String[] args) {
    int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println("Can complete all courses? " + canFinish(4, courses));
  }
}

