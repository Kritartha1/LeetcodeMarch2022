
//leetcode.com/problems/rotate-list/

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
 
 //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
//Three similar approaches:

//Approach 1:

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode tail=new ListNode();
        
        int length=0;
        while(true){
            length++;
            
            if(curr.next==null){
                tail=curr;
                tail.next=head;
                break;
            }
            curr=curr.next;
        }
        
        for(int i=0;i<length-(k%length);i++){
            tail=head;
            head=head.next;
            
        }
        tail.next=null;
        return head;
        
    }
}

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

//Approach 2:

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode tail=head;
        
        int length=1;
        
        while(tail.next!=null){
            length++;
            tail=tail.next;
        }
        tail.next=head;
        
        for(int i=0;i<length-(k%length);i++){
            tail=head;
            head=head.next;
            
        }
        
        tail.next=null;
        return head;
        
    }
}

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

//Approach 3:

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode tail=head;
        
        int length=1;
        
        while(tail.next!=null){
            length++;
            tail=tail.next;
        }
        
        tail.next=head;
        
        for(int i=0;i<length-(k%length);i++){
            tail=tail.next;
        }
        
        head=tail.next;
        tail.next=null;
        
        return head;
        
    }
}
