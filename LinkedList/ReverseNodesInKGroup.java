package LinkedList;

/*
 * Problem Statement:
 * Given the head of a linked list, reverse the nodes of the list k at a time, 
 * and return the modified list. k is a positive integer and is less than or 
 * equal to the length of the linked list. If the number of nodes is not a 
 * multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example:
 * Input: head =, k = 2
 * Output: 2 -> 1 -> 4 -> 3 -> 5
 * Explanation: The first two nodes (1, 2) are reversed to (2, 1) and the next two 
 * nodes (3, 4) are reversed to (4, 3). The last node (5) remains unchanged as it's less than k.
 *
 * Approach: Recursive (Block-by-Block Reversal)
 * - 1. Check Availability: First, traverse `k` steps using a temporary pointer to check if 
 *      at least `k` nodes are present. If not, return `head` as it is (handles the remaining left-out part).
 * - 2. Recursive Call: Recursively call `reverseKGroup` for the next block starting at `temp`. 
 *      The head returned by this call (`prevNode`) will serve as the connection point for our current reversed block.
 * - 3. Reverse Current Block: Perform a standard iterative link inversion for the current `k` nodes, 
 *      weaving them so the tail of this segment connects to `prevNode`.
 * - 4. Return the new head of this reversed block (`prevNode` at the end of the loop).
 */

public class ReverseNodesInKGroup {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;

        // Check if there are at least k nodes left in the linked list
        while (count < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            count++;
        }

        // Recursively reverse the remaining groups
        ListNode prevNode = reverseKGroup(temp, k);

        // Reset pointers to reverse the current group of k nodes
        temp = head;
        count = 0;

        while (count < k) {
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            count++;
        }
        
        return prevNode;
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

        int k = 2;
        ListNode result = reverseKGroup(head, k);

        printList(result);
    }
}

/*
LeetCode Problem => 25. Reverse Nodes in k-Group
Time Complexity => O(N) where N is the number of nodes in the linked list
Space Complexity => O(N/k) dynamic stack space consumed by recursion calls

Output:
2 -> 1 -> 4 -> 3 -> 5


Companies that asked this question:
Microsoft | Amazon | Google | Meta (Facebook) | Uber | Apple | Adobe
*/
