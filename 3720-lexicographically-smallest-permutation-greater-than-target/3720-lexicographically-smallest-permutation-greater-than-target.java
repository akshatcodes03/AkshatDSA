class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];
        char[] ans = new char[n];

        // s ke characters ka count
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int matched = 0;

        // Target ko jitna possible ho copy karo
        for (int i = 0; i < n; i++) {

            int ch = target.charAt(i) - 'a';

            // Same character available hai
            if (freq[ch] > 0) {
                ans[i] = target.charAt(i);
                freq[ch]--;
                matched++;
            } 
            else {

                // Target se bada smallest character dhundo
                for (int j = ch + 1; j < 26; j++) {

                    if (freq[j] > 0) {

                        ans[i] = (char) ('a' + j);
                        freq[j]--;

                        // Baaki characters ko smallest order mein lagao
                        int k = i + 1;

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans[k++] = (char) ('a' + x);
                                freq[x]--;
                            }
                        }

                        return new String(ans);
                    }
                }

                break;
            }
        }

        // Peeche jaake answer ko bada karne ki koshish
        for (int i = matched - 1; i >= 0; i--) {

            // Jo character pehle use kiya tha, wapas lao
            int current = ans[i] - 'a';
            freq[current]++;

            // Current se bada smallest character dhundo
            for (int j = current + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    ans[i] = (char) ('a' + j);
                    freq[j]--;

                    // Baaki characters ko smallest order mein lagao
                    int k = i + 1;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans[k++] = (char) ('a' + x);
                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}