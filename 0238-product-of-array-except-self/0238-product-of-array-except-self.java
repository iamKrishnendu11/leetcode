// we have to solve this in o(1) space complexity

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        ans[0]=1;

        // calculate prefix
        for(int i=1; i<n;i++){
            ans[i]= ans[i-1]* nums[i-1];
        }
        // calculate suffix
        int suffix=1;
        for(int r=n-1; r>=0; r--){
            ans[r]= ans[r] * suffix;
            suffix *= nums[r];
        }
       return ans; 
    }
}