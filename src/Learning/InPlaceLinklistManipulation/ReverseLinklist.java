package Learning.InPlaceLinklistManipulation;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;

public class ReverseLinklist {

  public static LinkedListNode reverse(LinkedListNode head){
    LinkedListNode previous = null, current = head;

    while(current != null) {
      LinkedListNode forward = current.next;
      current.next = previous;
      previous = current;
      current = forward;
    }
    return previous;
  }

  public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6};
    LinkedList<Integer> list = new LinkedList<>();
    LinkedListNode head = list.createLinkList(arr);
    LinkedListNode reversed = reverse(head);

    while(reversed != null) {
      System.out.println(reversed.data);
      reversed = reversed.next;
    }
  }
}
