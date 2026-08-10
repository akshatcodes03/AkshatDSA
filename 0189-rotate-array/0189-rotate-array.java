class Solution {
    public void rotate(int[] nums, int k) {

    // sabse pehle jitna bhi value hai k ki uske elemnet starting se rotate kaenge baki vale bache fir alag reverse karenge fir saari array ek sath reverse kar denge 
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    void reverse(int [] arr , int start , int end ){
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}