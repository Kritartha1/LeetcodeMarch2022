//leetcode.com/problems/is-subsequence/
//two approaches are being discussed here
//1.Topdown
class Solution {
    int[][] dp;
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n<m){
            return false;
        }
        dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int a=LCS(s,t,m,n);
        
        if(a==m){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    public int LCS(String s,String t,int m,int n){
        if(m==0||n==0){
            return 0;
        }
        else if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n]=1+LCS(s,t,m-1,n-1);
        }
        return dp[m][n]=Math.max(LCS(s,t,m,n-1),LCS(s,t,m-1,n));
    }
}
//***************************************************************************************************************************************************************************
//2.efficient approach O(n)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i_s=0;
        int i_t=0;
        int m=s.length();
        
        if(m==0){
            return true;
        }
        int n=t.length();
       
        for(int i=0;i<n;i++){
            if(s.charAt(i_s)==t.charAt(i_t)){
                i_s++;
                if(i_s==m){
                    return true;
                }
            }
            i_t++;
        }
        
        return false;
    }
}
