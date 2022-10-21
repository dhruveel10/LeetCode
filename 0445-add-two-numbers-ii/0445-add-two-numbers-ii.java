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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1_stack = new Stack<>();
        Stack<Integer> l2_stack = new Stack<>();
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy_head = new ListNode(0);
        ListNode l3 = dummy_head;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;
            
            int val = l1_val + l2_val + carry;
            carry = val/10;
            int digit = val%10;
            
            ListNode new_node = new ListNode(digit);
            l3.next = new_node;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        if(carry > 0){
            ListNode carry_val = new ListNode(carry);
            l3.next = carry_val;
            l3 = l3.next;
        }
        
        dummy_head.next = reverse(dummy_head.next);
        
        return dummy_head.next;
    }
    
    public ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}