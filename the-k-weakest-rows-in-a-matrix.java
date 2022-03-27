//leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
class Solution {
    
    class Pair{
        int first;//ones count
        int second;//index of matrix
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans=new int[Math.min(k,mat.length)];
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if(o1.first!=o2.first){
                            return o1.first-o2.first;
                        }else{
                            return o1.second-o2.second;
                        }
                    }
                });
        for(int i=0;i<mat.length;i++){
                int temp=onesCount(mat[i]);
            
            pq.add(new Pair(temp,i));
        }
        
        int i=0;
        while(!pq.isEmpty()&&k--!=0){
            ans[i++]=pq.poll().second;
        }
        
        return ans;
        
    }
    
    private int onesCount(int[] a){
        int l=0;
        int r=a.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(a[m]==1){
                l=m+1;
            }else{
                r=m;
            }
        }
        
        return l;
        
    }
}
