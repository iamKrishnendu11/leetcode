class Solution {
    public int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        // if no pivot means array not rotated
        // do normal binary search
        if(pivot == -1){
            return binary(arr,target,0,arr.length-1);
        }
        // if pivot found there will be two acending array
        if(arr[pivot] == target){
            return  pivot;
        }
        if(target >= arr[0]){
            return binary(arr,target, 0,pivot-1);
        }
        
            return binary(arr, target,pivot+1,arr.length-1);

    }

    int findPivot(int[] arr) {

    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {

        int mid = start + (end - start) / 2;

        // Case 1: mid is pivot
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        // Case 2: element before mid is pivot
        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        // Search right
        if (arr[mid] >= arr[start]) {
            start = mid + 1;
        }
        // Search left
        else {
            end = mid - 1;
        }
    }

    return -1;
}
    int binary(int[] arr, int key, int start, int end){

        while (start <= end){
            // find the middle element
            int mid = (start +end)/2;
            if (arr[mid]> key) end = mid - 1;
            else if (arr[mid] < key) start = mid + 1;
            else{
                // return answer
                return mid;
            }
        }
        return -1;
    }
}