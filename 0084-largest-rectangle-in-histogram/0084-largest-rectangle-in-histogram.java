class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] r = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty()
             && 
             heights[stack.peek()] >= heights[i]
             ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                r[i]= stack.peek();
            }else{
                //r[i]=-1; boundary must be last bar
                r[i]=n;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }

        int[] l = new int[n];

        //left smaller
         for(int i=0; i<n; i++){
            while(
                !stack.isEmpty() 
                &&
                 heights[stack.peek()]>= heights[i]
                 ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                l[i]= stack.peek();
            }else{
                l[i]=-1;
            }
            stack.push(i);
        }

        //ans
        int ans =0;
        for(int i=0;i<n; i++){
            int current = heights[i] * (r[i]-l[i]-1);
            ans =Math.max(current,ans);
        }

        return ans;
    }
}