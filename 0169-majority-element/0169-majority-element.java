class Solution {
    public int majorityElement(int[] nums) {

        int majority = 0;
        int votes = 0;

        for(int i = 0; i < nums.length; i++) {

            if(votes == 0) {
                majority = nums[i];
            }

            if(majority == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }

        return majority;
    }
}