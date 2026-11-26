class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> hs = new PriorityQueue<>((a,b) -> (b-a));
        for(int stone: stones){
            hs.add(stone);
        }

        while(hs.size()>1) {
            int s1 = hs.poll();
            int s2 = hs.poll();
            int ns = (s1 - s2);
            if(ns > 0) {
                hs.add(ns);
            }
        }

        return hs.isEmpty() ? 0 : hs.peek();
    }
}
