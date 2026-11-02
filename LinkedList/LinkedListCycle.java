package LinkedList;

/*
 * Problem Statement:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again 
 * by continuously following the next pointer.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example:
 * Input: head = [3, 2, 0, -4], pos = 1 (where -4 connects back to 2)
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Approach: Floyd's Cycle Finding Algorithm (Tortoise and Hare)
 * - Initialize two pointers, `slow` and `fast`, both pointing to the head of the linked list.
 * - Traverse the list with `slow` moving one step at a time (`slow = slow.next`) and `fast` moving two steps at a time (`fast = fast.next.next`).
 * - If there is no cycle, `fast` or `fast.next` will eventually hit null, and we can return false.
 * - If a cycle exists, the `fast` pointer will eventually catch up to the `slow` pointer inside the loop, meaning `slow == fast`. If they meet, return true.
 */

public class LinkedListCycle {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                return true;
            }
        } 
        return false;
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

        boolean result = hasCycle(head);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 141. Linked List Cycle
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Amazon, Apple, Baidu, Bloomberg, Cisco, eBay, Facebook (Meta), Goldman Sachs, Google, Intel, LinkedIn, Microsoft, Nvidia, Oracle, Qualcomm, Samsung, Salesforce, Spotify, Splunk, Tencent, Tesla, Uber, Visa, VMWare, Walmart Labs, Yahoo, Yandex, and JPMorgan.
*/
