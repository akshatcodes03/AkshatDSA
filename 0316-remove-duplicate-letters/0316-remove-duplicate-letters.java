class Solution {
    public String removeDuplicateLetters(String s) {
        
        // BASE CASE: Agar string khaali hai, to kuch return nahi karna
        if (s.length() == 0) {
            return "";
        }
        
        // STEP 1: Pehle count karo ki har character (a-z) string me kitni baar aaya hai
        // Ye humein baad me batayega ki "agar main is character ko abhi chhod doon,
        // to kya wo aage bhi milega ya nahi"
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            count[currentChar - 'a']++;  // us character ka count badhao
        }
        
        // STEP 2: Ab hum dhoondenge ki kaha tak "safe" hai rukna,
        // aur us range me sabse CHHOTA character kaunsa hai
        
        int smallestPosition = 0; // abhi tak ka sabse chhota character kaha mila hai
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // Agar ye character, abhi tak ke smallest se bhi chhota hai,
            // to isko naya "smallest" maan lo
            if (currentChar < s.charAt(smallestPosition)) {
                smallestPosition = i;
            }
            
            // Is character ko "use" kar liya (aage badh rahe hain), 
            // isliye uska count ek kam kar do
            count[currentChar - 'a']--;
            
            // IMPORTANT CHECK: Agar is character ka count 0 ho gaya,
            // matlab ye character ab AAGE kahin nahi milega.
            // Iska matlab hum yahan se aage nahi badh sakte -
            // humein yahin tak ke andar se apna answer choose karna padega
            if (count[currentChar - 'a'] == 0) {
                break; // loop rok do
            }
        }
        
        // STEP 3: Jo bhi smallest character mila, use apne answer me le lo
        char chosenChar = s.charAt(smallestPosition);
        
        // STEP 4: Ab bache hue string (chosenChar ke baad wala part) se
        // is chosenChar ke SAARE occurrences hata do
        // (kyunki hum ye character already use kar chuke hain, dobara nahi chahiye)
        String remainingString = s.substring(smallestPosition + 1);
        remainingString = remainingString.replace(String.valueOf(chosenChar), "");
        
        // STEP 5: Ab yehi poora process bache hue string pe RECURSIVELY repeat karo
        // aur chosenChar ko answer ke aage jod do
        return chosenChar + removeDuplicateLetters(remainingString);
    }
}