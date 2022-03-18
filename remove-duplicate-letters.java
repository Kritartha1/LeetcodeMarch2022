//leetcode.com/problems/remove-duplicate-letters/
class Solution {
    //Explanation: 
    //leetcode.com/problems/remove-duplicate-letters/discuss/76762/Java-O(n)-solution-using-stack-with-detail-explanation
    
    
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        int[] freq=new int[26];
        for(char c: arr){
            freq[c-'a']++;
        }
        boolean[] vis=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(char c:arr){
            --freq[c-'a'];
            if(vis[c-'a']){
                continue;
            }
            while(!st.isEmpty()&&st.peek()>c&&freq[st.peek()-'a']>0){
                vis[st.pop()-'a']=false;
                
            }
            vis[c-'a']=true;
            st.push(c);
        }
        
        StringBuilder sb=new StringBuilder();
        for(char c: st){
            sb.append(c);
            
        }
        
        return sb.toString();
    }
}
