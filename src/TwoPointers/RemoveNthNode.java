package TwoPointers;

import LinkListHelper.LinkedListNode;
import LinkListHelper.LinkedList;

public class RemoveNthNode {



  public static LinkedListNode removeNthNode(LinkedListNode head, int n) {
    LinkedListNode right = head;
    LinkedListNode left = head;

    for (int i = 0; i < n; i++) {
      right = right.next;
    }

    if (right == null) {
      return head.next;
    }

    while (right.next != null) {
      right = right.next;
      left = left.next;
    }

    left.next = left.next.next;

    return head;
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    int[] arr = {1,2,3,4,5,6};
    LinkedListNode head = linkedList.createLinkList(arr);
    LinkedListNode result = removeNthNode(head,2);
    System.out.println(result);

  }

}
