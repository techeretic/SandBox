/**
 * Created by pshetye on 7/9/17.
 */
public class MergeSortedLinkedLists {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), temp = null;
        temp = result;
        while (true) {
            if (l1 != null && ((l2 != null && l1.val <= l2.val) || l2 == null)){
                temp = addToResult(temp, l1.val);

                l1 = l1.next;
            }
            if (l2 != null && ((l1 != null && l2.val <= l1.val) || l1 == null)) {
                temp = addToResult(temp, l2.val);
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                break;
            }
        }
        return result.next;
    }

    private ListNode addToResult(ListNode temp, int val) {
        temp.next = new ListNode(val);
        temp = temp.next;
        return temp;
    }
}
