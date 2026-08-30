/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode prev = new ListNode(head.val);
        ListNode iterationNode = head.next;
        prev.next = null;
        while(iterationNode != null)
        {
            ListNode current = new ListNode(iterationNode.val);
            current.next = prev;
            prev = current;
            iterationNode = iterationNode.next;
        }
        return prev;
    }
}
