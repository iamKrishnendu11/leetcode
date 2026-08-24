class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        // count crequency of characters in p
        for(char c : p.toCharArray()){
            pCount[c-'a']++;
        }
        
        // sliding window to count frequency of characters in p
        for(int i=0;i < s.length(); i++){
            sCount[s.charAt(i)- 'a']++;
            // remove character from front that is out of window
            if(i>= p.length()){
                sCount[s.charAt(i-p.length()) -'a']--;
            }
            // compare count
            if(Arrays.equals(pCount,sCount)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}