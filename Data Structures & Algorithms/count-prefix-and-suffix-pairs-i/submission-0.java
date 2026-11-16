class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0, len = words.length;

        for(int i = 0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(isPrefix(words[i], words[j]) && isSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefix(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;

        int i = 0, len = s1.length();
        while(i<len && s1.charAt(i)==s2.charAt(i)) {
            i++;
        }
        if(i==len)
            return true;
        return false;
    }

    private boolean isSuffix(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;

        int len = s1.length();
        for(int i=0, j=s2.length() - len;i<len; i++, j++) {
            if(s1.charAt(i)!=s2.charAt(j))
                return false;
        }
        return true;
    }
}