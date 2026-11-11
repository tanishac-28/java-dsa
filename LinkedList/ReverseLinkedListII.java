package LinkedList;

/*
 * Problem Statement:
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to
 * position right (positions are 1-indexed), and return the reversed list.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5], left = 2, right = 4
 * Output: [1, 4, 3, 2, 5]
 * Explanation: The nodes from position 2 to position 4 (2, 3, 4) are
 * reversed, and the rest of the list stays the same.
 *
 * Approach: One pass, in-place reversal with a dummy node
 * - Create a dummy node before the head, so the case left = 1 (the head
 *   itself changes) is handled without any special code.
 * - Move prevLeft to the node just before the position left.
 * - Reverse (right - left + 1) nodes starting from prevLeft.next using the
 *   usual three-pointer reversal (prev, curr, next).
 * - After the loop, prev is the head of the reversed part and curr is the
 *   node just after position right.
 * - Reconnect: the original left node (leftNode) is now the tail of the
 *   reversed part, so leftNode.next = curr, and prevLeft.next = prev.
 * - Return dummy.next as the new head.
 * - If left == right, nothing needs to be reversed, so return head.
 */

public class ReverseLinkedListII {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move to the node just before position left
        ListNode prevLeft = dummy;

        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        ListNode curr = prevLeft.next;
        ListNode prev = null;

        // Reverse the nodes from position left to position right
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Reconnect the reversed part with the rest of the list
        ListNode leftNode = prevLeft.next;
        prevLeft.next = prev;
        leftNode.next = curr;

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
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode result = reverseBetween(head, left, right);

        printList(result);
    }
}

/*
LeetCode No => 92
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 4, 3, 2, 5]


Companies that asked this question:
Amazon, Google, Meta (Facebook), Microsoft, Apple, Adobe, Bloomberg, Oracle, Atlassian, DocuSign, Arista Networks, Revolut, and Disney.
*/