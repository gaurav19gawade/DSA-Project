package Learning.InPlaceLinklistManipulation;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;

public class ReverseNodesInKGroups {

  public static LinkedListNode reverseInKgroups(LinkedListNode head, int groupSize) {
    LinkedListNode dummy = new LinkedListNode(0);
    dummy.next = head;
    LinkedListNode prevGroupTail = dummy;
    LinkedListNode current = head;

    while(current != null) {
      LinkedListNode groupStart = current;
      LinkedListNode previous = null;
      int i;
      for(i = 0; i < groupSize && current != null; i++) {
        LinkedListNode forward = current.next;
        current.next = previous;
        previous = current;
        current = forward;
      }

      //connect the reversed group
      prevGroupTail.next = previous;
      groupStart.next = current;

      // Move prevGroupTail to the end of current group
      prevGroupTail = groupStart;

      if (i < groupSize){
        break;
      }
    }
    return dummy.next;
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
