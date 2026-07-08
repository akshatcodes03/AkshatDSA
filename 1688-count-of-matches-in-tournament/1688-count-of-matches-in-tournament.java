class Solution {
    public int numberOfMatches(int n) {

        int matches = 0;

        while (n > 1) {

            if (n % 2 != 0) {

                matches = matches + (n - 1) / 2;

                int adv = ((n - 1) / 2) + 1;

                n = adv;

            } else {

                matches = matches + n / 2;

                int adv = n / 2;

                n = adv;
            }
        }

        return matches;
    }
}