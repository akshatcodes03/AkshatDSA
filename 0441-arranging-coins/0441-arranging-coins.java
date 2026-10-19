class Solution {
    public int arrangeCoins(int n) {
        return solve(n,1);
    }
    public int solve(int n , int row){
        if(n<row){
            return 0;
        }
        return 1+solve(n-row, row+1);
    }
}

// class Solution {
//     public int arrangeCoins(int n) {
//         return (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
//     }
// }