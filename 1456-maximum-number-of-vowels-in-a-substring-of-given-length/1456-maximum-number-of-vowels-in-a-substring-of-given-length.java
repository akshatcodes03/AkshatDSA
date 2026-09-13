class Solution {
    public int maxVowels(String s, int k) {

        int n = s.length();
        int vowelCount = 0;

        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u')
                vowelCount++;
        }

        int maxVowelCount = vowelCount;

        for (int i = 1; i <= n - k; i++) {

            char ch = s.charAt(i - 1);
            if (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u'){
                vowelCount--;
        }
            ch = s.charAt(i + k - 1);
            if (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u'){
                vowelCount++;
        }
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }

        return maxVowelCount;
    }
}
// class Solution {

//     public boolean isVowel(char ch) {
//         return ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u';
//     }

//     public int maxVowels(String s, int k) {

//         int n = s.length();
//         int vowelCount = 0;

//         for (int i = 0; i < k; i++) {
//             if (isVowel(s.charAt(i))) {
//                 vowelCount++;
//             }
//         }

//         int maxVowelCount = vowelCount;

//         for (int i = 1; i <= n - k; i++) {

//             if (isVowel(s.charAt(i - 1))) {
//                 vowelCount--;
//             }

//             if (isVowel(s.charAt(i + k - 1))) {
//                 vowelCount++;
//             }

//             maxVowelCount = Math.max(maxVowelCount, vowelCount);
//         }

//         return maxVowelCount;
//     }
// }