package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
부가가치세는요, 과세의 대상이 되는 과세금액에서 10%만큼 산정해주시면 됩니다. 참고로 소수점(이하) 첫째자리에서 올림 처리합니다.

과세 금액은 어떻게 산정하면 될까요?
회계팀 : 공급가액에서 비과세 금액을 빼주시면 됩니다. 비과세 금액은 말 그대로 부가가치세가 부과되지 않는 금액을 의미해요.

그리고 비과세금액과 봉사료의 합은 주문금액을 넘지 않습니다(taxFreeAmount + serviceFee <= orderAmount).
* */
public class Problem1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(0, 0, 0);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {

        public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
            long supplyAmount = getSupplyAmount(orderAmount, serviceFee);

            long supplyValue = 0; // 공급가액
            long tax = supplyValue - taxFreeAmount;

            long answer = (long) Math.ceil(tax*10)/10;

            supplyValue = supplyAmount - answer;

            answer = supplyAmount - taxFreeAmount == 1 ? 0 : answer;
            return answer;
        }

        // 공급대가
        private long getSupplyAmount(long orderAmount, long serviceFee) {
            if (serviceFee != 0) {
                return orderAmount;
            }
            return orderAmount - serviceFee;
        }
    }
}
