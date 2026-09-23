import java.util.HashSet;

class Solution {

    public int sumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            // If we have already seen n
            if (set.contains(n)) {
                return false;
            }

            // Remember this number
            set.add(n);

            // Generate next number
            n = sumOfSquares(n);
        }

        return true;
    }
}