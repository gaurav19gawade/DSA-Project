package Practice;

public class MergeKSortedLists {
  /*
  First iteration (step = 1):

Merge lists[0] and lists[1], store result in lists[0]
Merge lists[2] and lists[3], store result in lists[2]
Merge lists[4] and lists[5], store result in lists[4]
Merge lists[6] and lists[7], store result in lists[6]
After this: [0-1, x, 2-3, x, 4-5, x, 6-7, x]

Second iteration (step = 2):

Merge lists[0] and lists[2], store result in lists[0]
Merge lists[4] and lists[6], store result in lists[4]
After this: [0-1-2-3, x, x, x, 4-5-6-7, x, x, x]

Third iteration (step = 4):

Merge lists[0] and lists[4], store result in lists[0]
After this: [0-1-2-3-4-5-6-7, x, x, x, x, x, x, x]
   */

  public ListNode mergeKLists(ListNode[] lists) {
    int step = 1;
    while(step < lists.length){
      for(int i = 0; i < lists.length - step; i += step*2){
        lists[i] = mergeTwoList(lists[i], lists[i+step]);
      }
      step *=2;
    }
    return lists[0];
  }

  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        curr.next = l1;
        l1 = l1.next;
      }else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if(l1 != null){
      curr.next = l1;
    }

    if(l2 != null){
      curr.next = l2;
    }
    return dummy.next;
  }

  public static void main(String[] args){

  }
}
