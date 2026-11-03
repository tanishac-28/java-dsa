package LinkedList;

/*
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example:
 * Input: head =, n = 2
 * Output: 1 -> 2 -> 3 -> 5
 * Explanation: The 2nd node from the end is 4, which is removed from the sequence.
 *
 * Approach: Two Pointers (Fast & Slow Pointer with Dummy Node)
 * - Create a `dummy` node whose next points to `head`. This handles the edge case where the head itself needs to be removed.
 * - Initialize both `fast` and `slow` pointers to the dummy node.
 * - Advance the `fast` pointer `n` steps ahead so that the gap between `slow` and `fast` becomes exactly `n`.
 * - Move both `fast` and `slow` pointers one step at a time until `fast.next` becomes null.
 * - At this point, the `slow` pointer will stop right before the node that needs to be deleted.
 * - Delete the node by changing links: `slow.next = slow.next.next`.
 * - Return `dummy.next` as the new head of the modified list.
 */

public class RemoveNthNodeFromEnd {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n steps ahead
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Skip the Nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode result = removeNthFromEnd(head, n);

        printList(result);
    }
}

/*
LeetCode Problem => 19. Remove Nth Node From End of List
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
1 -> 2 -> 3 -> 5


Companies that asked this question:
Amazon, Microsoft, Google, Facebook, Apple, Bloomberg
*/
