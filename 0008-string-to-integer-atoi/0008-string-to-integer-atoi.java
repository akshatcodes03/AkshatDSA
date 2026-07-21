class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        int sign = 1;
        if(i<s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(i<s.length() && s.charAt(i) == '+'){
            i++;
        }
        
        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign == 1 && num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
            }
            if (sign == -1 && -num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(num * sign);
    }
}