class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0, r=n-1, m=0;

        while(l<r){
            m=(l+r)/2;
            if(nums[m]>nums[r])
                l=m+1;
            else
                r=m;
        }
        
        r=(l-1+n);
        System.out.println("l:"+l+" r:"+r);
        int idx=0;
        while(l<=r){
            m=(l+r)/2;
            idx=m%n;
            if(nums[idx]==target){
                System.out.println("idx:"+idx);
                return idx;
            }
            if(nums[idx]>target)
                r=m-1;
            else
                l=m+1;
        }
        return -1;
    }
}
