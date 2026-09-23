class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] % 2 == 0) {
                // left is already correct
                left++;
            }
            else if (nums[right] % 2 != 0) {
                // right is already correct
                right--;
            }
            else {
                // left is odd and right is even
                // so swap them

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }
}