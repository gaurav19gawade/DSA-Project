package Learning.LinkListHelper;

public class LinkedList<T> {
  LinkedListNode head = null;
  LinkedListNode curr = null;

  public LinkedList(){
    this.head = null;
    this.curr = null;
  }

  public void insertAtEnd(LinkedListNode node){
    if(this.head == null){
      this.head = node;
      this.curr = node;
    } else {
      this.curr.next = node;
      this.curr = node;
    }
  }

  public LinkedListNode createLinkList(int [] arr) {
    for (int j : arr) {
      this.insertAtEnd(new LinkedListNode(j));
    }
    return this.head;
  }

}
