class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // pehle n ko length maano (basic hai ye toh)
        int n = nums.length;

        // ek naya array banao
        int[] Left_se_max = new int[n];


        // Naye Array ke pehle element ko nums ke pehle element ke barabar karo (because left ka max uss time toh pehla element hi hoga kyuki start mai uske alava or koi element hai hi nahi)
        Left_se_max[0]=nums[0];

        // fir loop chala ke jo array banai hai (new vali) uske ander vo element dalte raho jo samne baade hai compare kar ke ki nums[] ka element bada hai ya fir jo element pehle tha new[] array mai vo bada hai 
        for(int i = 1 ; i < n ; i++){
            Left_se_max[i]=Math.max(Left_se_max[i-1],nums[i]);
        }

        // fir agar koi stable nahi nikla toh -1 return karna hai 
        int ans = -1;
        // fir right ko max maano ( because haame usse compare kar ke Minimum nikalana hai )
        int Right_se_Min = Integer.MAX_VALUE;

        // loop mai compare kiya kari right se minimum nikal pau
        for(int i = n-1 ; i>=0 ; i--){
            Right_se_Min = Math.min(Right_se_Min, nums[i]);

            // fir yaha pe  formule mai rakha jisse STABLE INDEX niklega 
            if(Left_se_max[i]-Right_se_Min <= k){
                ans = i;
            }
        }
        // or ye ANSWER 🤧
        return ans;
    }
}