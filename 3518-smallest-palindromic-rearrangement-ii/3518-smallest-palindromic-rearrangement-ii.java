class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] halfFreq = new int[26];
        int oddCount = 0;
        char midChar = '\0';

        // Extract frequencies for the first half of the palindrome
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        // Limit strictly greater than Integer.MAX_VALUE to prevent overflow 
        // while safely bounding our calculation sizes
        long LIMIT = (long) 1e11; 
        long totalPerms = countPerms(halfFreq, LIMIT);

        if (totalPerms < k) {
            return "";
        }

        int L = s.length() / 2;
        StringBuilder half = new StringBuilder();
        long currentK = k;

        // Build the permutation character by character
        for (int step = 0; step < L; step++) {
            for (int i = 0; i < 26; i++) {
                if (halfFreq[i] == 0) continue;

                // Try placing character 'a' + i
                halfFreq[i]--;
                long ways = countPerms(halfFreq, LIMIT);

                if (currentK <= ways) {
                    // The k-th permutation exists in this branch
                    half.append((char) ('a' + i));
                    break; 
                } else {
                    // Skip this branch, subtract its possibilities, and backtrack
                    currentK -= ways;
                    halfFreq[i]++; 
                }
            }
        }

        // Construct the final palindromic string
        String halfStr = half.toString();
        String midStr = oddCount > 0 ? String.valueOf(midChar) : "";
        String reversedHalfStr = new StringBuilder(halfStr).reverse().toString();

        return halfStr + midStr + reversedHalfStr;
    }

    // Calculates permutations of a multiset: (f1 + f2 + ...)! / (f1! * f2! * ...)
    private long countPerms(int[] freq, long limit) {
        long ways = 1;
        int total = 0;
        for (int f : freq) {
            if (f == 0) continue;
            total += f;
            long combos = safe_nCr(total, f, limit);
            if (combos >= limit) return limit;
            
            // Check to prevent overflow before multiplying
            if (limit / ways < combos) return limit;
            ways *= combos;
        }
        return ways;
    }

    // Calculates combinations (n Choose r) safely bounded by a limit
    private long safe_nCr(int n, int r, long limit) {
        if (r > n - r) r = n - r; // Optimize nCr(n, r) == nCr(n, n-r)
        if (r == 0) return 1;
        
        long res = 1;
        for (int i = 1; i <= r; i++) {
            // (n - i + 1) will be at most 10^5, limit is 10^11.
            // Max value before division is ~ 10^16, safely fitting inside a 64-bit long
            res = res * (n - i + 1) / i;
            if (res >= limit) return limit;
        }
        return res;
    }
}