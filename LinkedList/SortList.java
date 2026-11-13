package LinkedList;

/*
 * Problem Statement:
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 *
 * Example:
 * Input: head = [4, 2, 1, 3]
 * Output: [1, 2, 3, 4]
 *
 * Approach: Merge Sort on a linked list
 * - Merge sort works well on linked lists, because merging two sorted lists
 *   needs only pointer changes and no extra array.
 * - Step 1 (split): find the middle of the list with slow and fast
 *   pointers. fast starts from head.next, so for an even length list slow
 *   stops at the end of the first half, which splits the list into two equal
 *   parts. Cut the list after slow (slow.next = null).
 * - Step 2 (sort): recursively sort the left half and the right half. A
 *   list with 0 or 1 node is already sorted (base case).
 * - Step 3 (merge): merge the two sorted halves into one sorted list using a
 *   dummy node and a curr pointer. Always attach the smaller of the two
 *   current nodes, then attach the remaining nodes of the non-empty list.
 */

public class SortList {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        return merge(left, right);
    }

    // Merges two sorted lists into one sorted list
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // Attach the remaining nodes
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
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
        // List: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode result = sortList(head);

        printList(result);
    }
}

/*
LeetCode No => 148
Time Complexity => O(N log N)
Space Complexity => O(log N)  (recursion stack)

Output:
[1, 2, 3, 4]


Companies that asked this question:
Facebook (Meta), Amazon, Microsoft, Google, Apple
*/