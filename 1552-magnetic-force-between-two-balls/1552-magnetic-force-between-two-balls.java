class Solution {
    public int maxDistance(int[] position, int m) {
         Arrays.sort(position);

        int start = 1;
        int end = position[position.length - 1] - position[0];

       int ans=0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (canWePlace(position, m, mid)) {
                // mid is possible
      
ans=mid;
                // Try for a bigger distance
                start = mid+1 ;

            } else {
                // mid is not possible
                // Need smaller distance
                end = mid - 1;
            }
        }

        return ans; 
    }

    private boolean canWePlace(int[] arr, int k, int distance) {

        int balls = 1;
        int lastPosition = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - lastPosition >= distance) {
                balls++;
                lastPosition = arr[i];
            }

           
        }

        return balls>=k;
    }
}