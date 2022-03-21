//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
//Approach 1:
// brute force approach but fastest

 class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int t=tops.length;
        int b=bottoms.length;
        
        if(t!=b){
            return -1;
        }
        
        int x=tops[0];
        int ans=Integer.MAX_VALUE;
        int top=0;
        int bottom=0;
        
        for(int i=0;i<t;i++){
            if(tops[i]==x&&bottoms[i]!=x){
                bottom++;
            }else if(bottoms[i]==x&&tops[i]!=x){
                top++;
            }
            else if(tops[i]!=x&&bottoms[i]!=x){
                ans=-1;
                break;
            }
        }
      
        ans=(ans!=-1?Math.min(top,bottom):Integer.MAX_VALUE);
        x=bottoms[0];
        top=0;
        bottom=0;
        
        for(int i=0;i<t;i++){
            if(tops[i]==x&&bottoms[i]!=x){
                bottom++;
            }else if(bottoms[i]==x&&tops[i]!=x){
                top++;
            }
             else if(tops[i]!=x&&bottoms[i]!=x&&ans!=Integer.MAX_VALUE){
                return ans;
                
            }
            else if(tops[i]!=x&&bottoms[i]!=x&&ans==Integer.MAX_VALUE){
                return -1;
                
            }
        }
       
        ans=Math.min(ans,Math.min(top,bottom));
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//approach 2: exrtra space:
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) { return -1; }
        
        int[] countA = new int[7]; // countA[i] records the occurrence of i in A.
        int[] countB = new int[7]; // countB[i] records the occurrence of i in B.
        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
        for (int i = 0; i < A.length; ++i) {
            ++countA[A[i]];
            ++countB[B[i]];
            if (A[i] == B[i]) { ++same[A[i]]; }
        }
        for (int i = 1; i < 7; ++i) {
            if (countA[i] + countB[i] - same[i] == A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Approach 3: looks good but slower and memory consumer
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        for(int i=0,a=0,b=0;i<n&&(tops[i]==tops[0]||bottoms[i]==tops[0]);i++){
            if(tops[i]!=tops[0]){
                a++;
            }else if(bottoms[i]!=tops[0]){
                b++;
            }
            if(i==n-1){
                return Math.min(a,b);
            }
        }
        
        for(int i=0,a=0,b=0;i<n&&(tops[i]==bottoms[0]||bottoms[i]==bottoms[0]);i++){
            if(tops[i]!=bottoms[0]){
                a++;
            }else if(bottoms[i]!=bottoms[0]){
                b++;
            }
            if(i==n-1){
                return Math.min(a,b);
            }
        }
        
        return -1;
    }
}
