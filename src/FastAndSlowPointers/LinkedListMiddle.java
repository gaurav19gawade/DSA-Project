package FastAndSlowPointers;

import LinkListHelper.LinkedList;
import LinkListHelper.LinkedListNode;

public class LinkedListMiddle {
  public static LinkedListNode middleNode(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    // We need to ensure both fast and fast.next are not null before moving fast two steps ahead
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    int[] arr = {5,10,15,25,30};
    LinkedList<Integer> list = new LinkedList<>();
    LinkedListNode head = list.createLinkList(arr);
    LinkedListNode middle = middleNode(head);
  }
}
