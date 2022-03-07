//leetcode.com/problems/merge-two-sorted-lists/submissions/
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

//Approach1: 1ms
//Approac2:0 ms

//Approach1:
class Solution {
    
    ListNode Next=new ListNode(-1);
    ListNode head=Next;
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        solve(list1,list2);
        head=head.next;
        return head;
        
    }
    
    public ListNode solve(ListNode list1,ListNode list2){
        if(list1==null){
            Next.next=list2;
            return Next;
        }
        if(list2==null){
            Next.next=list1;
            return Next;
        }
        
        int curr_val=Math.min(list1.val,list2.val);
        
        if(curr_val==list1.val){
            Next.next=list1;
            Next=Next.next;
            list1=list1.next;
        }else{
            Next.next=list2;
            Next=Next.next;
            list2=list2.next;
        }
        
        return solve(list1,list2);
    }
}
//**************************************************************************************************************************************************************************
//Approach2:
class Solution {
    
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null){
            return list2;
        }
        if(list2==null){
           return list1;
        }
        
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        list2.next=mergeTwoLists(list1,list2.next);
        return list2;
        
        
    }
    
   
}
