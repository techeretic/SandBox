/**
 * Created by pshetye on 6/18/17.
 */
public class DoublyLinkedList {
    class DoublyLinkedNode {
        int data;
        DoublyLinkedNode next;
        DoublyLinkedNode prev;
        public DoublyLinkedNode(int data) { this.data = data; }
    }

    public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        // Null array
        if (head == null && pos == 1)     head = newNode;
        else {
            DoublyLinkedNode currentNode = head;
            DoublyLinkedNode prevNode = head;
            int count = 1;
            // Traverse the list to the insert position
            while (currentNode != null) {
                if (count == pos)
                    break;
                else {
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                    count++;
                }
            }
            // Do nothing if position not available
            if (count < pos)    return head;
                // Insert at heading position
            else if (count == 1) {
                newNode.next = currentNode;
                currentNode.prev = newNode;
                head = newNode;
            }
            // Insert at middle position
            else if (currentNode != null) {
                newNode.next = currentNode;
                newNode.prev = prevNode;
                prevNode.next= newNode;
                currentNode.prev = newNode;
            }
            // Insert at ending position
            else {
                prevNode.next = newNode;
                newNode.prev = prevNode;
            }
        }
        return head;
    }
}
