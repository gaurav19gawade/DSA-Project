package Learning.InPlaceLinklistManipulation;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;

public class ReverseNodesInKGroups {

  public static LinkedListNode reverseInKgroups(LinkedListNode head, int k) {
    if (head == null || k == 1) {
      return head;
    }

    LinkedListNode dummy = new LinkedListNode(0);
    dummy.next = head;
    LinkedListNode previous = dummy;
    LinkedListNode current = head;


    while(true){
      int count = 0;
      LinkedListNode groupStart = previous.next;

      while(current != null && count < k){
        current = current.next;
        count++;
      }

      if(count == k){
        LinkedListNode reversedHead = reversed(groupStart, k);
        previous.next = reversedHead;
        groupStart.next = current; // Connect the end of the reversed group to the next part
        previous = groupStart; // Move previous to the end of the reversed group
      } else{
        break;
      }
    }
    return dummy.next;
  }

  public static LinkedListNode reversed(LinkedListNode head, int k){
    LinkedListNode previous = null, current = head;

    while(k > 0) {
      LinkedListNode forward = current.next;
      current.next = previous;
      previous = current;
      current = forward;
      k--;
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
