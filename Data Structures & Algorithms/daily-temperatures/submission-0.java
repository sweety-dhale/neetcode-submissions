class Solution {
    private class Temperature {
        int t, d;
        Temperature(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Temperature> dt = new Stack<>();

        int[] res = new int[len];
        for(int i=len-1; i>=0; i--) {
            while(!dt.isEmpty()) {
                Temperature ct = dt.peek();
                if(ct.t > temperatures[i]) {
                    res[i] = (ct.d - i);
                    break;
                }
                dt.pop();
            }
            dt.push(new Temperature(temperatures[i], i));
        }
        return res;
    }
}
