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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }

        ListNode outputNode;
        ListNode iteratorNode = null;

        if (list1.val < list2.val) {
            outputNode = new ListNode(list1.val);
            list1 = list1.next;
        } else if (list1.val > list2.val) {
            outputNode = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            outputNode = new ListNode(list1.val);
            iteratorNode = new ListNode(list2.val);
            outputNode.next = iteratorNode;
            list1 = list1.next;
            list2 = list2.next;
        }
       

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                if (iteratorNode == null) {
                    iteratorNode = new ListNode(list2.val);
                    outputNode.next = iteratorNode;
                } else {
                    iteratorNode.next = new ListNode(list2.val);
                    iteratorNode = iteratorNode.next;
                }
                list2 = list2.next;
            } else if (list2 == null) {
                if (iteratorNode == null) {
                    iteratorNode = new ListNode(list1.val);
                    outputNode.next = iteratorNode;
                } else {
                    iteratorNode.next = new ListNode(list1.val);
                    iteratorNode = iteratorNode.next;
                }
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                if (iteratorNode == null) {
                    iteratorNode = new ListNode(list1.val);
                    outputNode.next = iteratorNode;
                } else {
                    iteratorNode.next = new ListNode(list1.val);
                    iteratorNode = iteratorNode.next;
                }
                list1 = list1.next;

            } else if (list1.val > list2.val) {
                if (iteratorNode == null) {
                    iteratorNode = new ListNode(list2.val);
                    outputNode.next = iteratorNode;
                } else {
                    iteratorNode.next = new ListNode(list2.val);
                    iteratorNode = iteratorNode.next;
                }
                list2 = list2.next;
            } else {
                if (iteratorNode == null) {
                    iteratorNode = new ListNode(list1.val);
                    outputNode.next = iteratorNode;

                    iteratorNode.next = new ListNode(list2.val);
                    iteratorNode = iteratorNode.next;
                } else {
                    iteratorNode.next = new ListNode(list1.val);
                    iteratorNode = iteratorNode.next;

                    iteratorNode.next = new ListNode(list2.val);
                    iteratorNode = iteratorNode.next;
                }
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return outputNode;
    }
}