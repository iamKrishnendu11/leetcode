class Solution {
    public int longestOnes(int[] nums, int k) {
       int left =0;
       int count =0;
       int n= nums.length;
       for(int right=0; right<n; right++){
        if(nums[right]==0){
            count++;
        }
        if(count>k){
            if(nums[left]==0){
                count--;
            }
            left++;
        }
       } 
       return n-left;
    }
}