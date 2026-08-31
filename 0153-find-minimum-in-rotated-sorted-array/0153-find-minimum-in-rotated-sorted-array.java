class Solution {
    public int findMin(int[] nums) {
      int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        // Case 1: mid itself is the pivot
        if (mid < end && nums[mid] > nums[mid + 1]) {
            return nums[mid+1];
        }

        // Case 2: element before mid is the pivot
        if (mid > start && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }

        // Left side is sorted -> pivot is on the right
        if (nums[mid] >= nums[start]) {
            start = mid + 1;
        }
        // Otherwise pivot is on the left
        else {
            end = mid - 1;
        }
    }

    return nums[0];   
    }
}