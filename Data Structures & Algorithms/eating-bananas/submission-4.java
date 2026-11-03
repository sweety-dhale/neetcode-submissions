class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length, maxv=0;   

        for(int i=0; i<n;i++){
            maxv = Math.max(maxv, piles[i]);
        }

        if(n==h)
            return maxv;

        int mRate=maxv;
        int l=1, r=mRate, m=mRate;
        while(l<=r){
            m = (l+r+1)/2;
            if(m==0)
                break;
            long th = totalHours(piles, m);
            if(th>h){
                l=m+1;
            } else {
                mRate = Math.min(mRate, m);
                r=m-1;
            }
        }
        return mRate;
    }

    private long totalHours(int[] piles, int rate){
        long th=0;
        for(int p:piles){
            th += ((p+rate-1)/rate);
            // System.out.println("p:"+p+" rate:"+rate+" d:"+((int) Math.ceil(p/rate)));
        }
        return th;
    }
}
