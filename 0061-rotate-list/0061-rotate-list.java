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

//https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy_node = new ListNode(0);
        ListNode fast = dummy_node, slow = dummy_node;  //slow will always to the last variable ie the end of the list
        int count;
    
        dummy_node.next = head;
        for(count = 0; fast.next != null; count++)
            fast = fast.next;
        
        for(int j = count - k % count; j > 0; j--)
            slow = slow.next;
        
        fast.next = dummy_node.next;
        dummy_node.next = slow.next; 
        slow.next = null;
    
        return dummy_node.next;
    }
}