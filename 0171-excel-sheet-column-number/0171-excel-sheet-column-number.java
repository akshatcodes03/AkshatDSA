class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result + (columnTitle.charAt(i) - 'A' + 1) * (int) Math.pow(26, columnTitle.length() - 1 - i);
        }
        return result;
    }
}