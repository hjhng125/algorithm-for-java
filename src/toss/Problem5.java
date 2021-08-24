package toss;

import java.io.IOException;

public class Problem5 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        long solution1 = solution.solution(70);

        System.out.println(solution1);
    }

    static class Solution {


        long solution(int n) {
            int[] answer = new int[n + 1];

            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 4;

            answer[1] = 1;
            answer[2] = 2;
            answer[3] = 4;
            int i;
            for (i = 4; i <= n; ++i) {
                answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
            }

            return answer[i-1];
        }

    }
}
