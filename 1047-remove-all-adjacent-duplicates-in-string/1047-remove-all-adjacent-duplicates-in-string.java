
class Solution {
    public String removeDuplicates(String s) {

        StringBuilder stack = new StringBuilder();

         for ( int i=0; i<s.length(); i++) {
             char ch = s.charAt(i);

            // If top is same as current character
            if (stack.length() > 0 &&
                stack.charAt(stack.length() - 1) == ch) {

                // Pop
                stack.deleteCharAt(stack.length() - 1);

            } else {

                // Push
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}