/**
 * Created by pshetye on 10/2/16.
 */
public class LinkedListAddition {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public static void main(String [] args) {
        ListNode l1 = writeNumberToList(342);
        ListNode l2 = writeNumberToList(465);
        printList(l1);
        printList(l2);
        printList(getSum(l1, l2));

        ListNode l3 = writeNumberToList(0);
        ListNode l4 = writeNumberToList(0);
        printList(l3);
        printList(l4);
        printList(getSum(l3, l4));

        ListNode l5 = writeNumberToList(9);
        ListNode l6 = writeNumberToList(999999991);
        printList(l5);
        printList(l6);
        printList(getSum(l5, l6));

    }

    private static ListNode getSum(ListNode a, ListNode b) {
        long numberA = extractNumber(a);
        long numberB = extractNumber(b);

        System.out.println("\n numberA = " + numberA + " | numberB = " + numberB);

        long sum = numberA + numberB;
        return writeNumberToList(sum);
    }

    private static ListNode writeNumberToList(long sum) {
        ListNode sumNode = null;
        ListNode curr = sumNode;
        while (sum >= 0) {
            if (curr == null) {
                sumNode = new ListNode((int)sum%10);
                curr = sumNode;
            } else {
                ListNode node = new ListNode((int)sum%10);
                curr.next = node;
                curr = node;
            }
            sum = sum / 10;
            if (sum == 0) {
                sum = -1;
            }
        }
        return sumNode;
    }

    private static long extractNumber(ListNode node) {
        long number = 0;
        int index = 0;
        ListNode curr = node;
        System.out.println();
        while(curr != null) {
            System.out.println("number = " + number + " | index = " + index + " | curr.val = " + curr.val + " | (int) Math.pow(10, index) = " + ((int) Math.pow(10, index)));
            number += curr.val * (int) Math.pow(10, index);
            index++;
            curr = curr.next;
        }
        return number;
    }

    private static void printList(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " - ");
            node = node.next;
        }
    }
}
