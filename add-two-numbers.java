//leetcode.com/problems/add-two-numbers/

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
        ListNode top=new ListNode(0);
        ListNode ans=top;
        boolean carry=false;
        
        while(l1!=null||l2!=null){
            
            int val=(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+(carry?1:0);
            carry=val>=10;
            val%=10;
            
            ans.next=new ListNode(val);
            ans=ans.next;
            
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            
            
            
        }
        if(carry){
            ans.next=new ListNode(1);
        }
        
        
        return top.next;
    }
}
