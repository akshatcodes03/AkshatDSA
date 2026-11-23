class Solution 
{
    public String makeGood(String s) 
    {
        Stack<Character> ss = new Stack();
        
        for (Character c : s.toCharArray())
        {
            if (!ss.isEmpty() && (ss.peek() ^ c) == 32)
                ss.pop();
            else
                ss.push(c);
        }
        
        return ss.stream()
               .map(e->e.toString())
               .collect(Collectors.joining());
    }
}