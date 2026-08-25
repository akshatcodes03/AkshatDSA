class Solution {
    public int numJewelsInStones(String jewels, String s) {
        return (int)s.chars().filter(c -> jewels.indexOf(c)>=0).count();
    }
}