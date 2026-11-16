class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        int len = words.length;

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}