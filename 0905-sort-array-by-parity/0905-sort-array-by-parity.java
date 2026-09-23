class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // left should find an odd number
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // right should find an even number
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}