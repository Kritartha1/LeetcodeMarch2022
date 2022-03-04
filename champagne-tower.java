class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        //solution approach:
        //leetcode.com/problems/champagne-tower/discuss/1817822/Java-or-Simple-or-Explained
        //leetcode.com/problems/champagne-tower/solution/
        double cmpn[][]=new double[102][102];
        cmpn[0][0]=(double)poured;
        
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                
                double overflow=(cmpn[i][j]-1.0)/2.0;
                
                if(overflow>0){
                    cmpn[i+1][j+1]+=overflow;
                    cmpn[i+1][j]+=overflow;
                    
                }
            }
        }
        
        return Math.min(1,cmpn[query_row][query_glass]);//kyuki maximum 1 glass me 1 cup champagne hi aayega...
    }
}
