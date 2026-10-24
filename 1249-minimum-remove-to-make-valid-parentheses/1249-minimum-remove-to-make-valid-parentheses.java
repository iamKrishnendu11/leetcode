
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // First pass: remove invalid closing parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                sb.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        // Second pass: remove extra opening parentheses
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
                continue;
            }
            else{
            result.append(ch);}
        }

        return result.reverse().toString();
    }
}
