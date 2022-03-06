//leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
class Solution {
    public int countOrders(int n) {
        long mod=(long)1e9;
        mod+=7;
        long[] dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int m=(i-1)*2;
            m+=1;
            
            long s=(m*(m+1))/2;
            
            dp[i]=(dp[i-1]*(s))%mod;
        }
        return (int)(dp[n]%mod);
      //since only previous state is required ,,so we can get rid of the dp[] and instead write as..
      
//       class Solution {
//     public int countOrders(int n) {
//         long mod=(long)1e9;
//         mod+=7;
        
//         int ans=1;
        
//         for(int i=2;i<=n;i++){
//             int m=(i-1)*2;
//             m+=1;
            
//             long s=(m*(m+1))/2;
            
//             ans=(int)((ans*(s))%mod);
//         }
//         return ans;
//     }
// }
    }
}

//Logic: if n=3,
//let somehow we know the naswer to n=2..
//   __P1__D1__P2__D2__
//if P3 is at pos left to P3, then D3 can sit anywhereto the positions or gaps.
//i.e P3__P1__D1__P2__D2__
//so D3 has 5 options possible..

//similarly ,if P3 sits between P1 and D1
//P1 P3___D1__P2__D2__
//so, D3 will have four places left..
//similarly if we proceed further, we will get 3 then 2 then 1 possible gaps..

//so total ways for P3,D3 is 5+4+3+2+1=5*(5+1)/2=15..
//here 5 is the total gaps avaliable at the beginning when P3 D3 is not filled
//so for n=2 ,we will have two pairs ..so m=(2*n)+1 gaps at the beginning..

//so ways for inserting a new pair=m*(m+1)/2=s;

//also P1 D1 P2 D2 can arrangeamong themselves whoseanswer we will get from the last iteration when n=n-1.
//previous result =6 for n=2.

//So, for n=3, we will have 15*6possible ways left...=90 ways.

//so ans=(prev_res)*(s)

//************************************************************************************************************************************************************************

