class Solution {
    public int[] resultArray(int[] nums) {

        int[] a = new int[nums.length];
        int[] b = new int[nums.length];

        int n1 = 0;
        int n2 = 0;

        for (int x : nums) {

            if (n1 == 0) {
                a[n1++] = x;
            }
            else if (n2 == 0) {
                b[n2++] = x;
            }
            else if (a[n1 - 1] > b[n2 - 1]) {
                a[n1++] = x;
            }
            else {
                b[n2++] = x;
            }
        }

        int[] temp = Arrays.copyOf(b, n2);

        for (int x : temp) {
            a[n1++] = x;
        }

        return a;
    }
}