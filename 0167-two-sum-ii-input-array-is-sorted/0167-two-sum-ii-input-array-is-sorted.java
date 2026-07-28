class Solution {
    public int[] twoSum(int[] arr, int target) {
         // two pointer technique
        
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            if(arr[start] + arr[end] == target){
                return new int[] {start+1, end+1};
            } else if(arr[start] +arr[end] > target) {
                end--;
            }
            else{
               start++;
            }
        }
        return new int[] {-1, -1};
    }
}