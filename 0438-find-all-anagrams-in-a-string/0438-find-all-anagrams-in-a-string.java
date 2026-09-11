class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int n1 = p.length();
        int n2 = s.length();

        int k = p.length();

        List<Integer> ans = new ArrayList<>();

        if (n1 > n2) {
            return ans;
        }

        int[] fp = new int[128];
        int[] fs = new int[128];

        int l = 0;
        int r = 0;

        // First window hai ye
        while (r < k) {
            fp[p.charAt(r)]++;
            fs[s.charAt(r)]++;
            r++;
        }

        // First window ko check karega 
        if (Arrays.equals(fp, fs)) {
            ans.add(l);
        }

        // Sliding window lagaya hai 
        while (r < n2) {

            fs[s.charAt(r)]++;
            fs[s.charAt(l)]--;

            l++;
            r++;

            // fir check kiya every window
            if (Arrays.equals(fp, fs)) {
                ans.add(l);
            }
        }

        return ans;
    }
}