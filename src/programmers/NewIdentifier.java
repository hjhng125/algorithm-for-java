package programmers;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * replace()는 특정 CharSequence를 원하는 CharSequence로 바꾸어 주는 메서드
 * replaceAll()는 regular expression을 인자로 받아 탐색된 문자를 원하는 String으로 바꾸어 주는 메서드
 */
public class NewIdentifier {

    public static void main(String[] args) {

        String[] test = new String[]{"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p", "123", "__"};

        Arrays.stream(test).forEach(t -> {
            String solution = new Solution().solution(t);
            System.out.println("solution = " + solution);
        });
    }

    static class Solution {

        public String solution(String new_id) {
            String answer = new_id.toLowerCase();

            answer = answer.replaceAll("[^0-9a-z._-]", "");
            answer = answer.replaceAll("[.]{2,}", ".");
            answer = answer.replaceAll("^[.]|[.]$", "");
            answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
            answer = answer.replaceAll("[.]$", "");
            answer = answer.isBlank() ? "a" : answer;

            while (answer.length() <= 2) {
                answer += answer.charAt(answer.length() - 1);
            }

            return answer;
        }
    }
}

// ...bat..y.abcdefghijklm