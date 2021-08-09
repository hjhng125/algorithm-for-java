package programmers;

public class Weekly1 {
    public static void main(String[] args) {

        long result = new Solution().solution(3, 20, 4);
        System.out.println(result);

    }

    static class Solution {

        public long solution(int price, int money, int count) {
            long answer = price * ((long) count * (count + 1) / 2) - money;
            return answer> 0 ? answer : 0;
        }
    }
}
