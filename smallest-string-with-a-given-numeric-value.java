//leetcode.com/problems/smallest-string-with-a-given-numeric-value/
class Solution {
    public String getSmallestString(int n, int k) {
        int x=26;
        // Stack<Character> st=new Stack<>();
        char[] s=new char[n];
        while(n>0&&x>0){
            if(k>=(n+x-1)){//i.e if k-x>=n-1..then that nth posn can have value x and the other n-1 prev charcaters can havve values 1 atleast
                k-=x;
                n-=1;
                s[n]=(char)('a'+(char)(x-1));
               
                // st.push((char)('a'+(char)(x-1)));
            }else{
                x--;
            }
        }
      
        // StringBuilder sb=new StringBuilder();
        // for(char c:st){
        //     sb.append(c);
        // }
        // return sb.reverse().toString();
      
        return String.valueOf(s);
      
    }
}
