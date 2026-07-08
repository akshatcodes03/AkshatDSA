class Solution {
    public int maximum69Number (int num) {
        int n = num ; int p = -1 ; int pl = 0;
        while (n > 0){
            int digit = n%10;  if (digit == 6) {p = pl; } ; n/=10 ; pl++;
        }
        if(p == -1){ return num; }
        return num + (3 * (int)Math.pow(10, p));
    }
}