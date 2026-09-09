class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int k = p.length();

        int[] pFreq = new int[26];

        // p ki frequency
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pFreq[ch - 'a']++;
        }

        // s ke har possible substring ko check karo
        for (int i = 0; i <= s.length() - k; i++) {

            int[] freq = new int[26];

            // substring ki frequency
            for (int j = i; j < i + k; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
            }

            // Dono frequency same hain ya nahi
            boolean same = true;

            for (int j = 0; j < 26; j++) {
                if (freq[j] != pFreq[j]) {
                    same = false;
                    break;
                }
            }

            if (same) {
                ans.add(i);
            }
        }

        return ans;
    }
}