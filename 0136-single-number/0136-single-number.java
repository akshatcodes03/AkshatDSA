class Solution {
    public int singleNumber(int[] nums) {

        int xor = 0;

        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i]; // left bale ans m last nums[i] store ho rha h 
        }

        return xor;

    }
}
        // for(int i=0;i<nums.length;i++){
        //     int count=1;
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //          }
        //     }
        //     if(count==1){
        //         return nums[i];
        //     }
        // } 
        // return -1;
        // }   
// }