class Solution {
    public int calPoints(String[] ops) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < ops.length; i++) {

            if (ops[i].equals("C")) {

                st.pop();

            }
            else if (ops[i].equals("D")) {

                int last = st.peek();
                st.push(last * 2);

            }
            else if (ops[i].equals("+")) {

                int last = st.pop();
                int secondLast = st.peek();

                int sum = last + secondLast;

                st.push(last);
                st.push(sum);

            }
            else {

                st.push(Integer.parseInt(ops[i]));

            }
        }

        int total = 0;

        while (!st.isEmpty()) {
            total += st.pop();
        }

        return total;
    }
}
