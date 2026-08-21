class Solution {
    public boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;

        while(start < end){
            char left = s.charAt(start);
            char right = s.charAt(end);

            if(!isAlphaNum(left)){
                start++;
            } else if(!isAlphaNum(right)){
                end--;
            } else{
                if(Character.toLowerCase(left) != Character.toLowerCase(right)){
                    return false;
                }
                start++;
                end--;
        }
        }
      return true;  
    }
    public boolean isAlphaNum(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
}