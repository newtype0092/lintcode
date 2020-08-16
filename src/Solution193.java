import java.util.ArrayList;

public class Solution193 extends Solution {

    public Solution193() {
        intputs = new ArrayList<Object>() {{
            add(new ArrayList<Object>() {{
                add("(()");
            }});
            add(new ArrayList<Object>() {{
                add(")()())");
            }});
            add(new ArrayList<Object>() {{
                add("()(())");
            }});
            add(new ArrayList<Object>() {{
                add("((()))())");
            }});
            add(new ArrayList<Object>() {{
                add(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())");
            }});
        }};
        outputs = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(6);
            add(8);
            add(132);
        }};
    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];

        dp[0] = 0;
        int start = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
                continue;
            }

            start = i - (dp[i - 1]) - 1;
            if (start < 0) {
                dp[i] = 0;
                continue;
            }
            if (s.charAt(start) == '(') {
                dp[i] = 2 + dp[i-1];
                if (start > 1) {
                    dp[i] += dp[start-1];
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
