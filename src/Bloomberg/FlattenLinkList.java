package Bloomberg;

import java.util.Stack;

public class FlattenLinkList {

  public static Node flatten(Node head) {
    Node dummy = new Node();
    dummy.next = head;
    Node curr = dummy;
    Stack<Node> stack = new Stack<>();
    stack.push(head);

    while (!stack.isEmpty()) {
      Node element = stack.pop();
      if (element.child != null) {
        stack.push(element.child);
      } else {
        stack.push(element.next);
      }
      curr.next = element;
      element.prev = curr;
      element.child = null;
      curr = curr.next;
    }
    return dummy.next;
  }

  public static void main(String[] args){

  }
}
