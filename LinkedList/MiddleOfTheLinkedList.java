package LinkedList;

/*
 * Problem Statement:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5]
 * Output: 3 -> 4 -> 5
 * Explanation: The middle node of the list is 3.
 *
 * Approach: Tortoise and Hare (Slow & Fast Pointers)
 * - Initialize two pointers, `slow` and `fast`, both pointing to the head of the list.
 * - Traverse the linked list using a loop:
 *   - Move `slow` forward by one node (`slow = slow.next`).
 *   - Move `fast` forward by two nodes (`fast = fast.next.next`).
 * - When `fast` reaches the end of the list (either `fast` becomes null or `fast.next` becomes null), 
 *   the `slow` pointer will be exactly at the middle node of the linked list.
 */

public class MiddleOfTheLinkedList {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by two steps and slow by one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to print the linked list from a given node
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

        ListNode result = middleNode(head);

        printList(result);
    }
}

/*
LeetCode Problem => 876. Middle of the Linked List
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
3 -> 4 -> 5


Companies that asked this question:
Amazon, Adobe, Google, Microsoft, Facebook
*/
