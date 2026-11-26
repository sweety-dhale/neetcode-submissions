class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pts = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) -
                                      (b[0] * b[0] + b[1] * b[1]));
        for(int[] pt: points) {
            pts.add(pt);
        }
        int[][] res = new int[k][];
        for(int i=0; i<k; i++){
            res[i] = pts.poll();
        }
        return res;
    }
}
