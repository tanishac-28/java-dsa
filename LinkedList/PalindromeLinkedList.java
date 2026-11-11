package LinkedList;

/*
 * Problem Statement:
 * Given the head of a singly linked list, return true if it is a palindrome
 * or false otherwise.
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 * Example:
 * Input: head = [1, 2, 2, 1]
 * Output: true
 * Explanation: The list reads the same from the front and from the back.
 * (For head = [1, 2] the output is false.)
 *
 * Approach: Fast/Slow pointers + Reverse the second half
 * - Step 1: Find the middle of the list with two pointers. slow moves one
 *   step and fast moves two steps, so when fast reaches the end, slow is at
 *   the middle.
 * - Step 2: If the list has an odd number of nodes, fast is not null after
 *   the loop, and slow is at the exact middle node. Skip it
 *   (slow = slow.next), because the middle node does not need to be
 *   compared.
 * - Step 3: Reverse the second half of the list starting from slow.
 * - Step 4: Compare the first half (from head) with the reversed second
 *   half node by node. If any pair has different values, return false.
 * - If all the pairs match, the list is a palindrome, so return true.
 * - Note: this changes the second half of the original list. If the list
 *   must stay unchanged, reverse the second half again after comparing.
 */

public class PalindromeLinkedList {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Skip the middle node for odd length lists
        if (fast != null) {
            slow = slow.next;
        }

        // Step 3: Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 4: Compare both halves
        ListNode left = head;
        ListNode right = prev;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        // List: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        System.out.println(result);
    }
}

/*
LeetCode No => 234
Time Complexity => O(N)
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Accenture, Adobe, Amazon, Apple, Barclays, Bloomberg, Capgemini, Cognizant, Deloitte, Facebook (Meta), Google, Grab, Intel, Intuit, IXL, Microsoft, MindTree, Morgan Stanley, Oracle, Snapchat, Twitter (X), VMware
*/