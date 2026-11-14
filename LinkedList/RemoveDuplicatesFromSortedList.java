package LinkedList;

/*
 * Problem Statement:
 * Given the head of a sorted linked list, delete all duplicates such that
 * each element appears only once. Return the linked list sorted as well.
 *
 * Example:
 * Input: head = [1, 1, 2, 3, 3]
 * Output: [1, 2, 3]
 * Explanation: The repeated values 1 and 3 are kept only once.
 *
 * Approach: Two pointers (prev and temp) in one pass
 * - The list is sorted, so all the equal values come next to each other.
 * - Keep prev at the last unique node and temp as the node being checked,
 *   starting from head.next.
 * - If temp.val is equal to prev.val, it is a duplicate, so skip it
 *   (move temp ahead).
 * - Otherwise it is a new value, so link prev.next to temp, and make temp
 *   the new prev.
 * - At the end, set prev.next = null, to remove the duplicates that may be
 *   present at the end of the list (for example 1 -> 2 -> 2).
 * - If the list has 0 or 1 node, there are no duplicates, so return head.
 */

public class RemoveDuplicatesFromSortedList {
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

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val == prev.val) {
                // Duplicate, skip this node
                temp = temp.next;
                continue;
            } else {
                // New value, link it after the last unique node
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            }
        }
        // Cut the trailing duplicates (if any)
        prev.next = null;

        return head;
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
        // List: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);

        printList(result);
    }
}

/*
LeetCode No => 83
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 2, 3]


Companies that asked this question:
Company list not verified (premium tag)
*/