class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = cost.length;
        int totalGas = 0, totalCost = 0, total = 0, start = 0;
        for(int i=0; i<len; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            total += (gas[i] - cost[i]);
            if(total < 0) {
                total = 0;
                start = (i+1)%len;
            }
        }

        if(totalGas < totalCost)
            return -1;
        return start;
    }
}
