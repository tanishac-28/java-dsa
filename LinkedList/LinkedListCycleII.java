package LinkedList;

/*
 * Problem Statement:
 * Given the head of a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached 
 * again by continuously following the next pointer.
 *
 * Example:
 * Input: head = [3, 2, 0, -4], pos = 1 (where -4 connects back to 2)
 * Output: Node with value 2
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 
 
 * Approach: Floyd's Cycle Detection & Phase 2 Pointer Reset
 * - 1. Detect Cycle: Initialize `slow` and `fast` pointers at `head`. Move `slow` by 1 step 
 *      and `fast` by 2 steps. If they meet (`slow == fast`), a cycle is detected.
 * - 2. Find Start Node: Reset `slow` to `head` (keeping `fast` at the meeting point). 
 *      Move both pointers 1 step at a time. The point where they meet again is the exact 
 *      starting node of the cycle.
 * - 3. If `fast` or `fast.next` hits null, no cycle exists, so return null.
 */

public class LinkedListCycleII {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                slow = head; // Reset slow to head (can also reset fast instead)

                // Move both pointers one step at a time until they meet
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Return the node where the cycle begins
            }
        }
        return null;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a cycle back to node 2

        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println("Cycle begins at node with value: " + result.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}

/*
LeetCode Problem => 142. Linked List Cycle II

Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
Cycle begins at node with value: 2


Companies that asked this question:
Amazon, Microsoft, Google, Facebook, Bloomberg, Adobe
*/
