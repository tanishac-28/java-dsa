package LinkedList;

/*
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing 
 * together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example:
 * Input: list1 =, list2 = [1, 3, 4]
 * Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
 * Explanation: Nodes from both sorted lists are merged sequentially to maintain sorted order.
 *
 * Approach: Iterative (Dummy Node Strategy)
 * - Create a `dummy` node to act as the placeholder for the head of the new merged list.
 * - Maintain a `curr` pointer initialized to the dummy node to build the list step-by-step.
 * - Traverse both lists simultaneously as long as neither list is null:
 *   - Compare the current values (`list1.val` and `list2.val`).
 *   - Link `curr.next` to the node with the smaller value and move that list's pointer forward.
 *   - Move the `curr` pointer forward.
 * - Once the loop ends, check if any nodes remain in either `list1` or `list2`. 
 *   Link the remaining portion directly to `curr.next` since it is already sorted.
 * - Return `dummy.next` which points to the actual head of the merged sorted list.
 */

public class MergeTwoSortedLists {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Traverse both lists and link the smaller node
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // Link the remaining nodes of the non-empty list
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
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
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(list1, list2);

        printList(result);
    }
}

/*
LeetCode Problem => 21. Merge Two Sorted Lists
Time Complexity => O(N + M) where N and M are the number of nodes in list1 and list2
Space Complexity => O(1) (We are only modifying the existing links, no extra storage)

Output:
1 -> 1 -> 2 -> 3 -> 4 -> 4


Companies that asked this question:
FAANG / Big Tech:
• Amazon • Google • Microsoft • Apple • Meta • Netflix • Adobe

Enterprise & SaaS:
• Salesforce • Oracle • ServiceNow • Atlassian • Splunk • VMware • Cisco

Finance & FinTech:
• Bloomberg • Goldman Sachs • JPMorgan Chase • PayPal • Stripe • Square (Block)

Ride-Sharing & Delivery:
• Uber • Lyft • DoorDash • Instacart • Grab • DiDi

E-commerce & Retail:
• Walmart Global Tech • Wayfair • eBay • Shopify • Flipkart

Other Top Tech & Startups:
• LinkedIn • Twitter (X) • Pinterest • ByteDance • Zoom • Yandex • Yahoo

*/
