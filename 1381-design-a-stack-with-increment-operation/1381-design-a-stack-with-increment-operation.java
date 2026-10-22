
class CustomStack {

    int[] stack;
    int[] inc;
    int idx;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        inc = new int[maxSize];
        idx = -1;
    }

    public void push(int x) {
        if (idx == maxSize - 1) {
            return;
        }
        else{
        idx++;
        stack[idx] = x;}
    }

    public int pop() {
        if (idx == -1) {
            return -1;
        }

        else{

        int val = stack[idx] + inc[idx];

        if (idx > 0) {
            inc[idx - 1] += inc[idx];
        }

        inc[idx] = 0;
        idx--;

        return val;
        }
    }

    public void increment(int k, int val) {
        int lim = Math.min(k, idx + 1);

        if (lim > 0) {
            inc[lim - 1] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */