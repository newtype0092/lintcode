import java.util.*;

public class Solution122 extends Solution{

    public Solution122() {
        intputs = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(new int[]{2,1,5,6,2,3});
            }});
            add(new ArrayList<>() {{
                add(new int[]{2, 1, 5, 6, 2, 3});
            }});
            add(new ArrayList<>() {{
                add(new int[]{5, 4, 1, 2});
            }});
            add(new ArrayList<>() {{
                add(new int[]{0, 1});
            }});
            add(new ArrayList<>() {{
                add(new int[]{2, 1, 5, 6, 2, 3});
            }});
        }};

        outputs = new ArrayList<>();
        outputs.add(10);
        outputs.add(10);
        outputs.add(8);
        outputs.add(1);
        outputs.add(10);
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for (int i = 0; i <= height.length; i ++) {
            int hi = (i == height.length) ? -1 : height[i];
            if (s.empty() || hi >= height[s.peek()]) {
                s.push(i);
            } else {
                while(!s.isEmpty() && height[s.peek()] > hi) {
                    int tmp = s.pop();
                    sum = Math.max(sum, height[tmp] * (s.empty() ? i : i - s.peek() - 1));
                }
                s.push(i);
            }
        }
        return sum;
    }
}
