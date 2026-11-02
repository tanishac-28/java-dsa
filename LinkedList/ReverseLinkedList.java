package LinkedList;

/*
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5]
 * Output: [5, 4, 3, 2, 1]
 * Explanation: The sequential links of the linked list are completely inverted.
 *
 * Approach: Iterative (Three Pointers)
 * - Use three pointers: `prev` (initialized to null), `current` (initialized to head), and `next` (to store the next node temporarily).
 * - Traverse through the list until `current` becomes null:
 *   - Keep track of the next sequence node: `next = current.next`.
 *   - Change the current node's pointer to point backwards: `current.next = prev`.
 *   - Shift pointers forward: move `prev` to `current`, and `current` to `next`.
 * - When the loop terminates, `prev` will be standing at the new head of the inverted linked list.
 */

public class ReverseLinkedList {
    
    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next; // Store the next node
            current.next = prev;         // Reverse the link
            prev = current;              // Move prev forward
            current = next;              // Move current forward
        }
        return prev;
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

        ListNode result = reverseList(head);

        printList(result);
    }
}

/*
LeetCode Problem => 206. Reverse Linked List
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
5 -> 4 -> 3 -> 2 -> 1


Companies that asked this question:
Google • Oracle • Amazon • Qualcomm • Visa • Yandex • Apple • Goldman Sachs • TCS • Bloomberg • Cisco • Meta • Microsoft • NVIDIA • Paytm • SAP • Infosys • J.P. Morgan • Nokia • TikTok • Adobe • Uber
 */
