class Solution {
    public int minimumPushes(String word) {
       
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        
        
        Integer[] freqArray = new Integer[26];
        for (int i = 0; i < 26; i++) {
            freqArray[i] = freq[i];
        }
        Arrays.sort(freqArray, Collections.reverseOrder());
        
        
        int totalPushes = 0;
        int position = 0;
        
        for (int j = 0; j < freqArray.length; j++) {
            if (freqArray[j] == 0) break;
            
            int pushesNeeded = (position / 8) + 1;
            totalPushes += freqArray[j] * pushesNeeded;
            position++;
        }
        
        return totalPushes;
    }
}