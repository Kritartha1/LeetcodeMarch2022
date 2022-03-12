//leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//Approach 1: O(n) space:
//leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> mp=new HashMap<>();
        Node copy=head;
        
        while(copy!=null){
            mp.put(copy,new Node(copy.val));
            copy=copy.next;
        }
        
        copy=head;
        while(copy!=null){
            mp.get(copy).next=mp.get(copy.next);
            mp.get(copy).random=mp.get(copy.random);
            copy=copy.next;
        }
        return mp.get(head);
        
    }
  
}
//\\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/

//Approach 2:O(1) space:
//raw.githubusercontent.com/hot13399/leetcode-graphic-answer/master/138.%20Copy%20List%20with%20Random%20Pointer.jpg

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node curr=head;
        while(curr!=null){
            Node Next=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=Next;
            curr=Next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            
            curr=curr.next.next;
        }
        curr=head;
        Node copyHead=head.next;
        Node copy=copyHead;
        while(copy.next!=null){
            curr.next=curr.next.next;
            curr=curr.next;
            
            copy.next=copy.next.next;
            copy=copy.next;
        }
        curr.next=curr.next.next;
        return copyHead;
        
    }
}
