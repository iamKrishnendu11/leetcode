class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
    return -1;
}
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int day : bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while(low < high){
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay,m,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] bloomday, int m,int k, int day){
        int counter =0;
        int bouquetCount =0;
        for(int i=0;i< bloomday.length;i++){
            if(bloomday[i]<= day){
                // bloom is possible
                counter++;
            } else{
                bouquetCount +=(counter/k);
                counter =0;
            }
            
        }
        // last set of flowers for which not bloomed flower never arrived.
         bouquetCount +=(counter/k);
        return bouquetCount>= m;
    }
}