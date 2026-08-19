class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int current =0;
        for(int num:nums){
            current+=num;
            maxsum=Math.max(current,maxsum);
            if(current<0){
                current=0;
            }
        }
        return maxsum;
    }
}