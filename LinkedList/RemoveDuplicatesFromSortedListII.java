package LinkedList;

/*
 * Problem Statement:
 * Given the head of a sorted linked list, delete all nodes that have
 * duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Example:
 * Input: head = [1, 2, 3, 3, 4, 4, 5]
 * Output: [1, 2, 5]
 * Explanation: The values 3 and 4 appear more than once, so all the nodes
 * having these values are removed (not even one copy is kept).
 *
 * Approach: Dummy node + two pointers (prev and curr)
 * - Create a dummy node before the head, because the head itself can be a
 *   duplicate and may need to be removed.
 * - prev always points to the last node that is surely kept in the answer,
 *   and curr is the node being checked.
 * - If curr has the same value as curr.next, it is a duplicate group: move
 *   curr to the last node of this group, then link prev.next = curr.next to
 *   remove the whole group. prev does not move, because the next node can
 *   also be a duplicate.
 * - Otherwise curr is unique, so move prev ahead (prev = prev.next).
 * - Move curr ahead after every check.
 * - Return dummy.next as the new head.
 */

public class RemoveDuplicatesFromSortedListII {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {

                // Skip all the nodes having the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Remove the whole duplicate group
                prev.next = curr.next;
            } else {
                // Unique node, keep it
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print the linked list
    static void printList(ListNode head) {
        ListNode temp = head;
        StringBuilder sb = new StringBuilder("[");
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        // List: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(head);

        printList(result);
    }
}

/*
LeetCode No => 82
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 2, 5]


Companies that asked this question:
Company list not verified (premium tag)
*/