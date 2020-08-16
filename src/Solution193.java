public class Solution193 {
    public static String testIn = "(()";
    public static int testOut = 2;
    public static String testIn2 = ")()())";
    public static int testOut2 = 4;
    public static String testIn3 = "()(())";
    public static int testOut3 = 6;
    public static String testIn4 = "((()))())";
    public static int testOut4 = 8;
    public static String testIn5 = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
    public static int testOut5 = 132;

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
