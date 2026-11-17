class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            char[] arr = s.toCharArray(); // string ko array mai convert kiya
            String ans = ""; // ek empty String li jisme answer store karvaynge 

            for (int i = 0; i < arr.length; i += k) {

                int sum = 0;

                for (int j = i; j < i + k && j < arr.length; j++) {
                    sum = sum + (arr[j] - '0'); // value of '0' is 48 toh fir  `arr[j] - '0' character digit ko integer mein convert karta hai taaki hum uska normal add kar sakein
                }

                ans = ans + sum;
            }

            s = ans;
        }

        return s;
    }
}