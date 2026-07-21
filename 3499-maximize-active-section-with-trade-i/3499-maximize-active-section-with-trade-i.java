import java.util.*;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1') ones++;

        String t = "1" + s + "1";
        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        for (int i = 0; i < t.length();) {
            char c = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == c) j++;
            type.add(c);
            len.add(j - i);
            i = j;
        }

        int ans = ones;
        for (int i = 1; i < type.size() - 1; i++) {
            if (type.get(i) == '1' && type.get(i - 1) == '0' && type.get(i + 1) == '0') {
                ans = Math.max(ans, ones + len.get(i - 1) + len.get(i + 1));
            }
        }

        return ans;
    }
}