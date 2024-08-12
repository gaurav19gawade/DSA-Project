package Learning.FastAndSlowPointers;

import Learning.LinkListHelper.LinkedList;
import Learning.LinkListHelper.LinkedListNode;

//Reversing second half of the link list is the key
public class PalindromeLinkList {
  public static boolean palindrome(LinkedListNode head) {
    LinkedListNode fast = head, slow = head;

    if(slow == null){
      return false;
    }

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    LinkedListNode reversed = reverse(slow);
    slow = head;
    fast = reversed;
    while (slow != null && fast != null) {
      if (slow.data != fast.data) {
        return false;
      } else {
        slow = slow.next;
        fast = fast.next;
      }
    }
    return true;
  }

  public static LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode prev = null;
    LinkedListNode curr = head;
    LinkedListNode next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,5,5,3,2};
    LinkedList<Integer> list = new LinkedList<>();
    LinkedListNode head = list.createLinkList(arr);
    System.out.println("Is LL palindrome? ->" + palindrome(head));
  }
}
