//leetcode.com/problems/counting-bits/
class Solution {
    public int[] countBits(int n) {
        int dp[]=new int[n+1];
        //logic: we need to use result of previous calculations so that we don't have to fresh calculate every time.
        //as per observation, we can see that when we right shift an element, the number will be halved. Only the 0th bit will be lost. And we can find the 0th bit by checking it's even/odd. If even, 0th bit is 0 else 1.
        //if even, right shifted number and the original number will have same number of 1's
        //if odd, we can alwas add the lost 1 to it .
        for(int i=1;i<=n;i++){
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
        
    }
}
