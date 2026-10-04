class Solution {
    public int minLength(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int len = sb.length();

            if (len > 0) {

                char last = sb.charAt(len - 1);

                if ((last == 'A' && ch == 'B') ||
                    (last == 'C' && ch == 'D')) {

                    sb.deleteCharAt(len - 1);

                } else {
                    sb.append(ch);
                }

            } else {
                sb.append(ch);
            }
        }

        return sb.length();
    }
}