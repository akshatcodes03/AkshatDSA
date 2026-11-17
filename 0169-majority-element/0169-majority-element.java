class Solution {

    public int majorityElement(int[] nums) {

         // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n/2];

        int count = 0;
        int maxNum = 0;

        for(int i = 0; i < nums.length; i++) {

            if(count == 0) {
                maxNum = nums[i];
            }

            if(nums[i] == maxNum) {
                count++;
            } else {
                count--;
            }
        }

        return maxNum;
    }
}


   