class Solution {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int left=0;
        for(int right=0; right<n; right++ ){
            if(nums[right] != 0){
                swap(nums, left,right);
                left++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
}