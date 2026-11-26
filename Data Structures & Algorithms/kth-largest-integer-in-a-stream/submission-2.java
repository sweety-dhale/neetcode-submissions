class KthLargest {

    private Queue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k+1);
        for(int n: nums) {
            pq.add(n);
            if(pq.size()>k) {
                pq.remove();
            }
        }
        System.out.println("pq top: " + pq.peek());
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) {
            pq.remove();
        }
        return pq.peek();
    }
}
