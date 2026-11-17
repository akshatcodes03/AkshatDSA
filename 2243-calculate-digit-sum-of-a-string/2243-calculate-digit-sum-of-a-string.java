class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            char[] arr = s.toCharArray();
            String ans = "";

            for (int i = 0; i < arr.length; i += k) {

                int sum = 0;

                for (int j = i; j < i + k && j < arr.length; j++) {
                    sum = sum + (arr[j] - '0');
                }

                ans = ans + sum;
            }

            s = ans;
        }

        return s;
    }
}