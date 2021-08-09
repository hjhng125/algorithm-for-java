package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LottoBestWorst {

    public static void main(String[] args) {

        int[] result = new Solution().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});

        for (int item : result) {
            System.out.println("item = " + item);
        }
    }

    static class Solution {

        public int[] solution(int[] lottos, int[] win_nums) {

            return IntStream.of(
                (lottos.length + 1) - (int) Arrays.stream(lottos)
                    .filter(lotto -> Arrays.stream(win_nums).anyMatch(win_num -> win_num == lotto || lotto == 0))
                    .count(),
                (lottos.length + 1) - (int) Arrays.stream(lottos)
                    .filter(lotto -> Arrays.stream(win_nums).anyMatch(win_num -> win_num == lotto))
                    .count()
            ).map(rank -> rank > 6 ? rank - 1 : rank)
                .toArray();
        }
    }
}
