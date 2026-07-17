class Solution {
    public String addStrings(String num1, String num2) {

        int maxLength = Math.max(num1.length(), num2.length());

        char[] answer = new char[maxLength + 1];

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = maxLength;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int pehlaDigit = 0;
            int dusraDigit = 0;

            if (i >= 0) {
                pehlaDigit = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                dusraDigit = num2.charAt(j) - '0';
                j--;
            }

            int sum = pehlaDigit + dusraDigit + carry;

            answer[k] = (char) ((sum % 10) + '0');
            carry = sum / 10;
            k--;
        }

        while (k >= 0) {
            answer[k] = '0';
            k--;
        }

        if (answer[0] == '0') {
            return new String(answer, 1, answer.length - 1);
        }

        return new String(answer);
    }
}