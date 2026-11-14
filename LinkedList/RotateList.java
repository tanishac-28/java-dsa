package LinkedList;

/*
 * Problem Statement:
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5], k = 2
 * Output: [4, 5, 1, 2, 3]
 * Explanation: Rotate 1 step: [5, 1, 2, 3, 4]. Rotate 2 steps:
 * [4, 5, 1, 2, 3].
 *
 * Approach: Make the list circular, then break it at the right place
 * - Find the length of the list (len) and stop at the last node (curr).
 * - Rotating by len places gives the same list, so use k = k % len. If k
 *   becomes 0, nothing changes, so return head.
 * - Join the last node with the head (curr.next = head), so the list becomes
 *   circular.
 * - After rotating right by k, the new tail is the node at position
 *   (len - k), and the node just after it is the new head.
 * - Move newCurr (len - k - 1) steps from the head to reach that new tail.
 *   Set newHead = newCurr.next and break the circle with newCurr.next = null.
 * - Return newHead.
 */

public class RotateList {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode curr = head;
        int len = 1;

        // Find the length and the last node
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        // Rotating len times gives the same list
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        curr.next = head;

        // Find the new tail (node at position len - k)
        ListNode newCurr = head;
        int steps = len - k;

        for (int i = 1; i < steps; i++) {
            newCurr = newCurr.next;
        }

        ListNode newHead = newCurr.next;

        // Break the circle
        newCurr.next = null;

        return newHead;
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

        int k = 2;

        ListNode result = rotateRight(head, k);

        printList(result);
    }
}

/*
LeetCode No => 61
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[4, 5, 1, 2, 3]


Companies that asked this question:
Microsoft, Amazon, Google, Facebook (Meta), Josh Technology
*/