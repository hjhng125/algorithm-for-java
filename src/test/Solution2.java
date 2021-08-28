package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int productNum = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        List<Integer> scoreList = new ArrayList<>();
        for (String score : scores) {
            scoreList.add(Integer.parseInt(score));
        }

        Collections.sort(scoreList);

        int result = new Solution().solve(scoreList);
        System.out.println(result);
    }

    static class Solution {

        public int solve(List<Integer> scoreList) {
            int cur;
            int result = 0;
            for (int i = 0; i < scoreList.size(); ++i) {
                if (scoreList.get(i) == 0) {
                    break;
                }
                cur = scoreList.get(i);
                scoreList.set(i, 0);
                for (int j = i; j < scoreList.size(); ++j) {
                    if (scoreList.get(j) == 0) {
                        continue;
                    }
                    if (cur < scoreList.get(j)) {
                        result++;
                        cur = scoreList.get(j);
                        scoreList.set(j, 0);
                    }
                }
            }
            return result;
        }
    }
}
