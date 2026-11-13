package LinkedList;

/*
 * Problem Statement:
 * Given the head of a singly linked list, group all the nodes with odd
 * indices together followed by the nodes with even indices, and return the
 * reordered list.
 * The first node is considered odd, the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5]
 * Output: [1, 3, 5, 2, 4]
 * Explanation: The nodes at positions 1, 3, 5 (odd) come first, followed by
 * the nodes at positions 2, 4 (even).
 *
 * Approach: Two pointers (odd list and even list)
 * - Keep one pointer for the odd positioned nodes (odd) and one for the even
 *   positioned nodes (even), and remember the start of the even list
 *   (evenHead).
 * - In every step, link the odd node to the next odd node (even.next), and
 *   link the even node to the next even node (odd.next), then move both
 *   pointers ahead.
 * - The loop stops when even or even.next is null, which means there are no
 *   more nodes to rearrange.
 * - Finally, attach the even list after the last odd node
 *   (odd.next = evenHead).
 * - If the list has 0 or 1 node, it is already in the correct order, so
 *   return head.
 */

public class OddEvenLinkedList {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        // Remember the start of the even list
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Attach the even list after the odd list
        odd.next = evenHead;

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
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);

        printList(result);
    }
}

/*
LeetCode No => 328
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 3, 5, 2, 4]


Companies that asked this question:
Google, Amazon, Microsoft, Facebook (Meta), Adobe, and VMware
*/