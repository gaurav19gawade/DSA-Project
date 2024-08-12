package Learning.FastAndSlowPointers;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;
import java.util.List;

public class LinkedListCycleDetection {
  /**
   * 5 -> 10 -> 15 -> 25 -> 30
   *      ^------------------|
   * 5,5
   * 10,15
   * 15,30
   * 25,15
   * 10,30
   * 15,15
   */
  public static boolean detectCyle(LinkedListNode head) {
    LinkedListNode slowPtr = head;
    LinkedListNode fastPtr = head;
    // We need to ensure both fast and fast.next are not null before moving fast two steps ahead
    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
      if (slowPtr == fastPtr) {
        return true;
      }
    }
    return false;
  }

  public static LinkedListNode createCycle(LinkedListNode head) {
    LinkedListNode slowPtr = head.next;

    LinkedListNode curr = head;

    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = slowPtr;
    return head;
  }

  public static void main(String[] args) {
    int[] arr = {5,10,15,25,30};
    LinkedList<Integer> list = new LinkedList<>();
    LinkedListNode head = list.createLinkList(arr);
    System.out.println(detectCyle(createCycle(head)));
  }
}
