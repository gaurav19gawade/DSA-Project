package Learning.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
  public static int numBusesToDestination(int[][] routes, int source, int target) {

    if (source == target) {
      return 0;
    }

    HashMap<Integer, Set<Integer>> busStationMap = new HashMap<>();
    Queue<int[]> queue = new LinkedList<>();
    Set<Integer> visitedStops = new HashSet<>();
    Set<Integer> visitedBuses = new HashSet<>();
    int busNo = 0;

    //graph building
    for (int[] route : routes) {
      for (int station : route) {
        busStationMap.computeIfAbsent(station, key -> new HashSet<>()).add(busNo);
      }
      busNo++;
    }

    queue.add(new int[] {source, 0});

    while (!queue.isEmpty()) {
      int[] data = queue.remove();
      int station = data[0];
      int routeLength = data[1]; //number of buses

      if (station == target) {
        return routeLength;
      }

      if (busStationMap.containsKey(station)) {
        for (int bus : busStationMap.get(station)) {
          if (!visitedBuses.contains(bus)) { //this check is to avoid cycles
            visitedBuses.add(bus);
            for (int route : routes[bus]) {
              if (!visitedStops.contains(route)) {
                visitedStops.add(route);
                queue.add(new int[] {route, routeLength + 1});
              }
            }
          }
        }
      }
    }

    return -1;

  }

  public static void main(String[] args) {
    int[][] routes = {{1, 2, 7}, {3, 6, 7}};
    int source = 8, target = 6;
    System.out.println("Number of buses " + numBusesToDestination(routes, source, target));
  }
}
