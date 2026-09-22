class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Find search range
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                // mid is possible
                // Try to find a smaller answer
                high = mid;
            } else {
                // mid is not possible
                // Need a larger maximum sum
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {

        int students = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                students++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return students <= k;
    }
}