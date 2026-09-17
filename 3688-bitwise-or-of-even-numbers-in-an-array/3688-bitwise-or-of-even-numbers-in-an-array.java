class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int bitw = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2==0){
                bitw= bitw|nums[i];
            }
        }
        return bitw;
    }
}