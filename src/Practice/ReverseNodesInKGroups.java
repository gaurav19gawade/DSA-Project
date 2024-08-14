package Practice;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;

public class ReverseNodesInKGroups {

  public static LinkedListNode reverseInKgroups(LinkedListNode head, int k) {
    LinkedListNode current = head, next, previous = null;
    int count = k;

    if (head == null){
      return null;
    }

    while(current != null && count > 0){
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
      count--;
    }

    if (current == null && count > 0){
      current = previous;
      previous = null;
      while(current != null){
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }
    }

    if (count > 0){
      return previous;
    } else {
      head.next = reverseInKgroups(current, k);
    }

    return previous;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    LinkedList<Integer> list = new LinkedList<>();
    LinkedListNode head = list.createLinkList(arr);
    LinkedListNode reversed = reverseInKgroups(head, 3);
    while (reversed != null) {
      System.out.println(reversed.data);
      reversed = reversed.next;
    }
  }
}
