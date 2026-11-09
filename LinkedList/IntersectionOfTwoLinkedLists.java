package LinkedList;

/*
 * Problem Statement:
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns.
 *
 * Example:
 * Input: listA = [4, 1, 8, 4, 5], listB = [5, 6, 1, 8, 4, 5]
 * Output: Intersected at the node with value 8
 * Explanation: List A is 4 -> 1 -> (8 -> 4 -> 5) and list B is
 * 5 -> 6 -> 1 -> (8 -> 4 -> 5). Both lists share the last three nodes,
 * starting from the node with value 8. (Note that 1 appears in both lists
 * but those are different nodes, so the intersection is at 8.)
 *
 * Approach: Two Pointers (switch heads)
 * - Use two pointers, temp1 on list A and temp2 on list B.
 * - Move both one step at a time. When a pointer reaches the end (null) of
 *   its list, move it to the head of the other list.
 * - After switching, both pointers travel the same total distance
 *   (lengthA + lengthB), so the difference in the list lengths is cancelled
 *   and they reach the intersection node at the same time.
 * - If the lists do not intersect, both pointers become null together at
 *   the end, so the loop stops and null is returned.
 * - If any of the heads is null, there can be no intersection, so return
 *   null.
 */

public class IntersectionOfTwoLinkedLists {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        if (headA == null || headB == null) {
            return null;
        }

        while (temp1 != temp2) {

            // Move to the head of the other list after reaching the end
            if (temp1 != null) {
                temp1 = temp1.next;
            } else {
                temp1 = headB;
            }

            if (temp2 != null) {
                temp2 = temp2.next;
            } else {
                temp2 = headA;
            }
        }
        return temp1; // temp2 is also valid to return
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        // Common part: 8 -> 4 -> 5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode result = getIntersectionNode(headA, headB);

        System.out.println(result == null ? "No intersection" : result.val);
    }
}

/*
LeetCode No => 160
Time Complexity => O(N + M)
Space Complexity => O(1)

Output:
8


Companies that asked this question:
Amazon, Google, Facebook (Meta), Microsoft, Adobe, Visa, Flipkart
*/