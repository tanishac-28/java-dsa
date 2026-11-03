
package LinkedList;

/*
 * Problem Statement:
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: l1 =, l2 = [5, 6, 4]
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Approach: Iterative (Elementary Math Simulation)
 * - Create a `dummy` node to simplify the initialization of the resulting summation list.
 * - Track pointers using `curr` and maintain a `carry` variable starting at 0.
 * - Traverse both lists simultaneously until both list pointers reach null:
 *   - Initialize the column sum with the previous `carry`.
 *   - Extract value from `l1` if it is not null, then shift its pointer forward.
 *   - Extract value from `l2` if it is not null, then shift its pointer forward.
 *   - Calculate the new carry (`sum / 10`) and update the current digit value (`sum % 10`).
 *   - Link a new node containing this digit value to `curr.next` and move `curr` ahead.
 * - After the loop terminates, check if a remaining `carry` is left over. If yes, append a new node with value 1.
 * - Return `dummy.next` which holds the absolute head of the summed digits.
 */

public class AddTwoNumbers {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }

        // Append the remaining carry if present
        if (carry == 1) {
            curr.next = new ListNode(1);
        }

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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        printList(result);
    }
}

/*
LeetCode Problem => 2. Add Two Numbers
Time Complexity => O(max(N, M)) where N and M are the number of nodes in l1 and l2
Space Complexity => O(max(N, M)) to store the newly created result list

Output:
7 -> 0 -> 8


Companies that asked this question:
Amazon, Microsoft, Google, Facebook, Apple, Bloomberg, Adobe
*/
