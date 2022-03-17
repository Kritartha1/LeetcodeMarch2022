//leetcode.com/problems/score-of-parentheses/


///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\///\\\///\\\///\\\///\

//Approach 1: O(n) space:stack solution
class Solution {
  
    public int scoreOfParentheses(String s) {
      
    
    // curr record the score at the current layer level.

    // If we meet '(',
    // we push the current score to stack,
    // enter the next inner layer level,
    // and reset curr = 0.

    // If we meet ')',
    // the cur score will be doubled and will be at least 1.
    // We exit the current layer level,
    // and set cur += stack.pop() + cur
        
        Deque<Integer> st=new ArrayDeque<>();
        int curr=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(curr);
                curr=0;
            }else{
                curr=st.pop()+Math.max(curr*2,1);
            }
        }
        return curr;
    }
}
///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\///\\\///\\\///\\\///\

//Approach 2:O(1) space.

//Intuition:
// The final sum will be a sum of powers of 2, as every core (a substring (), with score 1) will have it's
score multiplied by 2 for each exterior set of parentheses that contains that core.
 
class Solution {
    public int scoreOfParentheses(String s) {
       
        
        int curr=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                
                ++curr;
            }else{
                --curr;
                if(s.charAt(i-1)=='('){
                    ans+=1<<curr;
                }
            }
        }
        return ans;
    }
}
///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\///\\\///\\\///\\\///\

// Approach3:
//similar approach as stack.......just need to visualize..

class Solution {
    public int scoreOfParentheses(String s) {


        
        
        
        int[] ans=new int[26];
        
        int i=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                
                ans[++i]=0;
            }else{
                
                ans[i-1]+=Math.max(2*ans[i--],1);
            }
        }
        
        return ans[0];
    }
}
