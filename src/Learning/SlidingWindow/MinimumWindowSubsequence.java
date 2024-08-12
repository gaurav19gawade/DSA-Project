package Learning.SlidingWindow;

public class MinimumWindowSubsequence {

  public static String minimumWindow(String source, String sub) {
    //We start by iterating over source and sub using pointers sourcePtr and subPtr
    //if element at sourcePtr and element at subPtr are same we increment both the pointers if not we just increment
    // subPtr
    // once we have identified string sub in source we move pointer to the occucrence of first letter of sub in source
    // and then again start iterating

    int indexSource = 0, indexSub = 0;
    int minWindow = Integer.MAX_VALUE;
    String subSequence = "";
    while (indexSource < source.length()) {
      if(sub.charAt(indexSub) == source.charAt(indexSource)) {
        indexSub++;
        if(indexSub == sub.length()) {
          int start = indexSource;
          int end = indexSource;
          indexSub--;
          while(indexSub >= 0) {
            if(sub.charAt(indexSub) == source.charAt(start)) {
              indexSub-=1;
            }
            start-=1;
          }
          start +=1;
          if(minWindow > (end - start + 1)) {
            minWindow = end - start + 1;
            subSequence = source.substring(start, end+1);
          }
          indexSource = start;
          indexSub = 0;
        }
      }
      indexSource++;
    }
    return subSequence;
  }
  public static void main(String[] args) {
    System.out.println(minimumWindow("abcdebdde", "bde"));
  }
}
