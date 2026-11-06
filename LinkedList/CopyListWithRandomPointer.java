package LinkedList;

/*
 * Problem Statement:
 * A linked list of length n is given such that each node contains an additional random pointer, 
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
 * where each new node has its value set to the value of its corresponding original node.
 * Return the head of the copied linked list.
 *
 * Example:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Explanation: The structure and layout are identical, but completely fresh memory instances are created.
 *
 * Approach: Three-Pass Interweaving Strategy (Optimized O(1) Space)
 * - 1. Interweave Nodes: Create clone nodes and insert them immediately after their original counterparts. 
 *      (e.g., A -> A' -> B -> B').
 * - 2. Assign Random Pointers: Iterate the interwoven list and direct the cloned node's random pointer 
 *      to the target clone node (`curr.next.random = curr.random.next`).
 * - 3. Separate Lists: Untangle the interleaved nodes to recover the original linked list 
 *      and establish the clean cloned deep-copy list.
 */

public class CopyListWithRandomPointer {

    // Definition for a Node with next and random pointers
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a clone node right after each original node
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        // Step 2: Update the random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Separate the original list and the cloned deep copy list
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;

        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;

            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }
        return newHead;
    }

    // Helper method to display sequential track for testing
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randVal = (temp.random != null) ? temp.random.val : -1;
            System.out.print("[" + temp.val + ", Rand:" + (randVal == -1 ? "null" : randVal) + "]" + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code: sample input values to test the solution
    public static void main(String args[]) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);

        node1.next = node2;
        node2.next = node3;

        node1.random = null;
        node2.random = node1; // 13 points back to 7
        node3.random = node1; // 11 points back to 7

        System.out.print("Original List: ");
        printList(node1);

        Node clonedHead = copyRandomList(node1);

        System.out.print("Cloned List:   ");
        printList(clonedHead);
    }
}

/*
LeetCode Problem => 138. Copy List with Random Pointer
Time Complexity => O(N) where N is the total number of nodes in the linked list
Space Complexity => O(1) auxiliary space (cloned nodes are part of the target output configuration)

Output:
Original List: [7, Rand:null] -> [13, Rand:7] -> [11, Rand:7]
Cloned List:   [7, Rand:null] -> [13, Rand:7] -> [11, Rand:7]


Companies that asked this question:
Meta (Facebook), Amazon, Microsoft, Google, Bloomberg, Uber, Adobe, Apple, Oracle, Cisco, ServiceNow, Goldman Sachs, DE Shaw, Citadel, PayPal, Walmart, LinkedIn, Spotify, Lyft
*/
