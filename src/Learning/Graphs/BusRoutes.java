package Learning.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
We are given routes of buses in routes array that each bus repeats forever, a source station and target station
For example - routes = [[1,2,7],[7,8,9]] --> indicates bus 0 has routes 1,2,7, bus 1 has routes 7,8,9 and so on...

we maintain a hashmap of stations and list of buses which stop at these stations.
For example - {7: [0,1]}


we will BFS algo to traverse over the stations staring from the source station and adding it to the queue

for each poped station we over the bus(if not visited) get all the routes (if not visited) of the bus and add these
routes(station) to the queue. For every route that we add we increase the route length (i.e number of buses)


 */

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
