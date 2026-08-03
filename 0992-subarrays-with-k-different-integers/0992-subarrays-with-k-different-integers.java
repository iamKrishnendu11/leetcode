class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return totalCount(nums,k) - totalCount(nums, k-1);
        
    }
     private int totalCount(int[] fruits, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > k) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            count+=right-left+1;
        }

        return count;
    }
}