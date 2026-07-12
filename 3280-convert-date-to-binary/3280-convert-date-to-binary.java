class Solution {
    public String convertDateToBinary(String date) {

        String[] arr = date.split("-");

        String ans = "";

        for (int i = 0; i < arr.length; i++) {

            int n = Integer.parseInt(arr[i]);

            String binary = Integer.toBinaryString(n);

            ans = ans + binary;

            if (i != arr.length - 1) {
                ans = ans + "-";
            }
        }

        return ans;
    }
}