https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=s.length();
        int size=0;
        
        while(i<n){
            char curr=s.charAt(i);
            if(size==0&&curr==')'){
              // 
            }
            else if(curr==')'){
                sb.append(curr);
                --size;
            }
            else if(curr=='('){
                ++size;
                sb.append(curr);
            }else{
                sb.append(curr);
            }
            
            ++i;
        }
        
        if(size==0){
            return sb.toString();
        }
        
        s=sb.toString();
        n=s.length();
        i=n-1;
        sb.setLength(0);
        
        //to make sure that after deleting extra opening brackets and that makes a valis parenthesis , we need to make sure to delete the parenthesis from right to left..
        //bcoz..cases like this may arise..."(((()("
        //if we delete from starting..end result will be ")(".
        //so we need to delete from the right to left.
        
        while(i>=0){
            
            char curr=s.charAt(i);
            if(curr=='('&&size!=0){
                --size;
            }
            else{
                sb.append(curr);
            }
            --i;
        }
        
        s=sb.reverse().toString();
        
        return s;
        
        
    }
}
