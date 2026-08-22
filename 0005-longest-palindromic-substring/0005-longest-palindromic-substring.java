class Solution {
    public String longestPalindrome(String s) {
        int start =0;
        int max = 1;

        for(int i=0; i < s.length(); i++){
            // Odd length palindrome
            int len1 = expand(s, i, i);

            // even length palindrome
            int len2= expand(s,i,i+1);
            // check which palindrome is bigger
            int len = Math.max(len1,len2);
            
            // update max
            if (len > max) {
                max = len;

                start = i - (len - 1) / 2;
            }
            
             }
             return s.substring(start, start + max);
        
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}