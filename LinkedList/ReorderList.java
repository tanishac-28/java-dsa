package LinkedList;

/*
 * Problem Statement:
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5]
 * Output: 1 → 5 → 2 → 4 → 3
 * Explanation: The nodes from the second half are interleaved into the first half in reverse order.
 *
 * Approach: Three-Step Strategy (Find Middle, Reverse Second Half, Interleave)
 * - 1. Find the Middle: Use slow and fast pointers (`fast.next != null && fast.next.next != null`) 
 *      to stop `slow` at the end of the first half.
 * - 2. Split and Reverse: Disconnect the second half (`second = slow.next`, `slow.next = null`) 
 *      and reverse it using the standard iterative three-pointer technique.
 * - 3. Interleave/Merge: Maintain two separate heads (`first = head` and `second = prev`) and 
 *      weave them together one by one using temporary pointers (`next1` and `next2`).
 */

public class ReorderList {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }   
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves and reverse the second half
        ListNode second = slow.next;
        slow.next = null; // Break the link

        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Step 3: Interleave the two sorted/aligned halves
        ListNode first = head;
        second = prev; // Head of the reversed second half

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
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
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        printList(head);
    }
}

/*
LeetCode Problem => 143. Reorder List
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
1 -> 5 -> 2 -> 4 -> 3


Companies that asked this question:
Amazon, Facebook, Microsoft, Google, Bloomberg
*/
