class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0 ;
        int start = 0;
        int[] position = new int[128];
        for(int i = 0 ; i < s.length() ; i++){
            start = Math.max(start, position[s.charAt(i)]);
            maxLength = Math.max(maxLength, i-start+1);
            position[s.charAt(i)]=i+1;
        }
        return maxLength;
    }
}