class Solution {
    public char findTheDifference(String s, String t) {
        
        int num = 0;

        for(int x : s.toCharArray()) num -= x;

        for(int y : t.toCharArray()) num += y;

        return (char) (num);
        
         }
}