package Learning.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/*
Sorting the words by lesser frequency and if the frequencies are same we sort them by greater alphabetical order
because we are pulling words from heap for it to only have k elements

words with less frequency stay up of the heap and words with low frequency go down
 */

public class TopKFrequentWords {

  public static List<String> topKFrequent(String[] words, int k){
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    for(String word: words){
      map.put(word, map.getOrDefault(word,0)+1);
    }

    PriorityQueue<String> frequency = new PriorityQueue<>(new Comparator<String>() {
      @Override
      // String1 could potentially be top of the heap
      public int compare(String string1, String string2){
        int freq1 = map.get(string1);
        int freq2 = map.get(string2);
        System.out.println(string1 + "'s" + " frequency is "+freq1);
        System.out.println(string2 + "'s" + " frequency is "+freq2);
        if (freq1 == freq2) return string2.compareTo(string1);
        return freq1-freq2;
      }
    });

    for(Map.Entry<String, Integer> set: map.entrySet()){
      frequency.add(set.getKey());
      if(frequency.size() > k){
        frequency.poll();
      }
    }

    while(!frequency.isEmpty()) {
      result.add(frequency.poll());
    }

    Collections.reverse(result);

    return result;
  }

  public static void main(String[] args){
    String[] words = {"apple", "banana", "cherry", "banana", "apple", "banana"};
    int k = 3;
    System.out.println(topKFrequent(words, k));
  }
}
