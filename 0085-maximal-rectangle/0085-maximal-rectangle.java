class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int ans = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram for current row
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Solve Largest Rectangle in Histogram
            int current = largestRectangleArea(heights);

            ans = Math.max(ans, current);
        }

        return ans;
    }


    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int[] r = new int[n];

        // Right Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            if (!stack.isEmpty()) {
                r[i] = stack.peek();
            } else {
                r[i] = n;
            }

            stack.push(i);
        }

        // Clear stack
        while (!stack.isEmpty()) {
            stack.pop();
        }

        int[] l = new int[n];

        // Left Smaller
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            if (!stack.isEmpty()) {
                l[i] = stack.peek();
            } else {
                l[i] = -1;
            }

            stack.push(i);
        }

        // Calculate answer
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int width = r[i] - l[i] - 1;

            int current = heights[i] * width;

            ans = Math.max(ans, current);
        }

        return ans;
    }
}