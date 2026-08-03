class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2==0) return n;
        int mul = 0;
        if(n%2!=0){
            mul = n*2;
        }
        return mul;
    }
}