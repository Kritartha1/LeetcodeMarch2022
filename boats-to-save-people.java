//leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int n=arr.length;
        int ans=0;
        int j=n-1;
        int i=0;
      
        while(i<=j){
          
            ++ans;
            if(arr[i]+arr[j]<=limit){//because atmost 2 waala condition given hai
                ++i;
            }
            --j;
        }
      
        return ans;
      
    }
}
