package LinkedList;

/*
 * Problem Statement:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's
 * nodes (i.e., only the nodes themselves may be changed).
 *
 * Example:
 * Input: head = [1, 2, 3, 4]
 * Output: [2, 1, 4, 3]
 * Explanation: Nodes 1 and 2 are swapped, then nodes 3 and 4 are swapped.
 * (If the list has an odd number of nodes, the last node stays at its place.)
 *
 * Approach: Iterative pointer manipulation with a dummy node
 * - Create a dummy node before the head, so swapping the first pair needs no
 *   special case, and keep curr pointing to the node just before the pair.
 * - While there are two nodes ahead (curr.next and curr.next.next exist):
 *   - swap1 is the first node of the pair, swap2 is the second node.
 *   - swap1.next = swap2.next  (first node points to the rest of the list)
 *   - swap2.next = swap1       (second node points to the first node)
 *   - curr.next = swap2        (previous part points to the new first node)
 * - After the swap, swap1 is the last node of the swapped pair, so move
 *   curr to swap1 and continue with the next pair.
 * - Return dummy.next as the new head.
 */

public class SwapNodesInPairs {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode swap1 = curr.next;
            ListNode swap2 = curr.next.next;

            // Swap the pair by changing the links
            swap1.next = swap2.next;
            swap2.next = swap1;

            curr.next = swap2;

            // Move to the node just before the next pair
            curr = swap1;
        }
        return dummy.next;
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
        // List: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = swapPairs(head);

        printList(result);
    }
}

/*
LeetCode No => 24
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[2, 1, 4, 3]


Companies that asked this question:
Amazon, Microsoft, Apple, Walmart, Dell Technologies, OLX Group, Red Hat
*/