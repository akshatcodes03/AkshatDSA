class Solution {
    public int countGoodSubstrings(String s) {
        char[] str = s.toCharArray();
        int count = 0;

        for(int i = 0 ; i<=str.length-3 ; i++){
            if(str[i] != str[i+1] && str[i] != str[i+2] && str[i+1] != str[i+2]){
                count++;
            }
        }
        return count;
    }
}