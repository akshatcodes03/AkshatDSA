class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len++;
            } 
            else if (ch == '*') {
                if (len > 0) len--;
            } 
            else if (ch == '#') {
                len *= 2;
            } 
            else if (ch == '%') {
                
            }
        }

        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (k == len - 1) {
                    return ch;
                }
                len--;
            } 
            else if (ch == '#') {
                long oldLen = len / 2;
                k %= oldLen;
                len = oldLen;
            } 
            else if (ch == '%') {
                k = len - 1 - k;
            } 
            else if (ch == '*') {
                len++;
            }
        }

        return '.';
    }
}