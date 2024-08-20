package Learning.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
In Java, PriorityQueue for strings uses natural ordering (lexicographical) by default.
 */

public class ReconstructItinerary {

  public static List<String> findItinerary(List<List<String>> tickets) {
    LinkedList<String> route = new LinkedList<>();
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    //Create a map of routes; such as for tickets ["MUC", "LHR"] and ["MUC", "JFK"]
    for(List<String> ticket: tickets){
      map.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<String>()).add(ticket.get(1));
    }
    dfs("JFK", map, route);
    return route;
  }

  public static void dfs(String station, HashMap<String, PriorityQueue<String>> map, LinkedList<String> route){
    PriorityQueue<String> stationList = map.get(station);
    while(stationList!=null && !stationList.isEmpty()){
      dfs(stationList.poll(), map, route);
    }
    route.addFirst(station);
  }

  public static void main(String[] args){
    String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
    List<List<String>> ticketList = new ArrayList<>();
    for(String[] ticket: tickets){
      List<String> temp = new ArrayList<>();
      temp.add(ticket[0]);
      temp.add(ticket[1]);
      ticketList.add(temp);
    }
    System.out.println("Itinerary is " + findItinerary(ticketList));

  }
}

/*

//    Collections.sort(tickets, (o1,o2) -> {
//      int cmp = o1.get(0).compareTo(o2.get(0));
//      return (cmp != 0) ? cmp : o1.get(1).compareTo(o2.get(1));
//    });

Collections.sort(tickets, ...):

This is calling the sort method from the Collections class.
It's used to sort the tickets list, which is presumably a List<List<String>>.


(o1, o2) -> { ... }:

This is a lambda expression defining a Comparator.
o1 and o2 represent two elements from the tickets list that are being compared.
Each of these is a List<String> (an inner list).


int cmp = o1.get(0).compareTo(o2.get(0));:

o1.get(0) gets the first string from the first list.
o2.get(0) gets the first string from the second list.
compareTo compares these strings lexicographically.
The result is stored in cmp.


return (cmp != 0) ? cmp : o1.get(1).compareTo(o2.get(1));:

This is a ternary operator. It's a shorthand if-else statement.
If cmp != 0 (meaning the first strings were different):

It returns cmp, using the comparison of the first strings to determine order.


If cmp == 0 (meaning the first strings were the same):

It compares the second strings: o1.get(1).compareTo(o2.get(1)).
This comparison of the second strings is then returned.

This implements a lexicographic comparison:

Lists are primarily ordered based on their first elements.
When first elements are equal, they're ordered based on their second elements.
 */
