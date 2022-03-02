//leetcode.com/problems/is-subsequence/
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
