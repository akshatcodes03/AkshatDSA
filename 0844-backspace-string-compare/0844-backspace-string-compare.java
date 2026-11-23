class Solution {
    private Stack<Character> build(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
}