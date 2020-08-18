import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution510 extends Solution {

    public Solution510() {
        intputs = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(new boolean[][] {
                        {true},
                });
            }});
            add(new ArrayList<>() {{
                add(new boolean[][] {
                        {true, true, false, false, true},
                        {false, true, false, false, true},
                        {false, false, true, true, true},
                        {false, false, true, true, true},
                        {false, false, false, false, true},
                });
            }});
            add(new ArrayList<>() {{
                add(new boolean[][] {
                        {false, false},
                        {false, false},
                });
            }});
        }};
        outputs = new ArrayList<>() {{
            add(1);
            add(6);
            add(0);
        }};
    }

    private int lineMaximalRectangle(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            } else {
                while (!stack.empty() && height[stack.peek()] > height[i]) {
                    int tmp = stack.pop();
                    int area = (i - (stack.isEmpty() ? -1 : stack.peek()) - 1) * height[tmp];
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        return max;
    }

    public int maximalRectangle(boolean[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }

        int width = matrix[0].length;
        int[] height = new int[width + 1];

        int max = 0;
        int area = 0;
        height[width] = 0;
        for (boolean[] booleans : matrix) {
            // update height
            for (int i = 0; i < width; i++) {
                if (booleans[i]) {
                    height[i]++;
                } else {
                    height[i] = 0;
                }
            }
            area = this.lineMaximalRectangle(height);
            System.out.println(Arrays.toString(height) + "-> max:" + area);
            max = Math.max(max, area);
        }

        return max;
    }
}
