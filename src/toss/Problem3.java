package toss;

import java.io.IOException;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        boolean solution1 = solution.solution("0");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public boolean solution(String amountText) {
            String replace = amountText.replace(",", "");
            if (!replace.matches("^[0-9]+$")) {
                return false;
            }
            if (amountText.charAt(0) == '0' || amountText.charAt(0) == ',' || amountText.charAt(amountText.length() - 1) == ',') {
                return false;
            }
            String[] split = amountText.split(",");
            if (split.length == 1) {
                return true;
            }
            for (int i = 0; i < split.length; ++ i) {
                if (i == 0 && split[i].length() > 3) {
                    return false;
                }
                if (split[i].length() != 3) {
                    return false;
                }
            }
            return true;
        }
    }
}
