class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        int k = s1.length();

        if (n1 > n2) {
            return false;
        }

        int[] fs1 = new int[128];
        int[] fs2 = new int[128];

        int l = 0;
        int r = 0;

        
        while (r < k) {
            fs1[s1.charAt(r)]++;
            fs2[s2.charAt(r)]++;
            r++;
        }

        
        if (Arrays.equals(fs1, fs2)) {
            return true;
        }

       
        while (r < n2) {

            
            fs2[s2.charAt(r)]++;

           
            fs2[s2.charAt(l)]--;

            l++;
            r++;

            
            if (Arrays.equals(fs1, fs2)) {
                return true;
            }
        }

        return false;
    }
}