//leetcode.com/problems/two-city-scheduling/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        //a[0]-a[1] means sorting on the basis of cost of sending to a-cost of sending to b...
        //the person having the least diff or negative diff means..he should be sent to a ...
        //similarly the last n persons should be sent to b
        
        int price = 0;
        for(int i = 0; i < costs.length / 2; i++){
            price += costs[i][0];
        }
        for(int i = costs.length / 2; i < costs.length; i++){
            price += costs[i][1];
        }
        return price;
    }

}
