package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Weekly4 {

    public static void main(String[] args) {
        String[] table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
//        String[] languages = new String[]{"PYTHON", "C++", "SQL"};
        String[] languages = new String[]{"JAVA", "JAVASCRIPT"};
//        int[] preference = new int[]{7, 5, 5};
        int[] preference = new int[]{7, 5};

        String solution = new Solution().solution(table, languages, preference);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {

//            Map<String, List<String>> stringListHashMap = new HashMap<>();
//
//            for (String line : table) {
//                String[] s = line.split(" ");
//                stringListHashMap.put(s[0], Arrays.asList(s[5], s[4], s[3], s[2], s[1]));
//            }
//
//            int max = 0;
//            String maxKey = "";
//            for (Entry<String, List<String>> stringListEntry : stringListHashMap.entrySet()) {
//                List<String> value = stringListEntry.getValue();
//                int answer = 0;
//                for (int i = 0; i < value.size(); i++) {
//                    for (int j = 0; j < languages.length; j++) {
//                        if (!value.contains(languages[j])) {
//                            continue;
//                        }
//                        if (value.get(i).equals(languages[j])) {
//                            answer += (i + 1) * preference[j];
//                        }
//                    }
//                }
//                if (max < answer) {
//                    max = answer;
//                    maxKey = stringListEntry.getKey();
//                } else if (max == answer) {
//                    maxKey = maxKey.compareTo(stringListEntry.getKey()) > 0 ? stringListEntry.getKey() : maxKey;
//                }
//            }
//            return maxKey;
            String answer = "";
            int maxScore = 0;
            for (String line : table) {
                String[] s = line.split(" ");

                String cName = s[0];
                int cScore = 0;
                for (int i = 0; i < languages.length; i++) {
                    int idx = Arrays.asList(s).indexOf(languages[i]);
                    if (idx == -1) continue;
                    cScore += (6 - idx) * preference[i];
                }

                if (cScore == maxScore && cName.compareTo(answer) < 0) {
                    answer = cName;
                }
                else if (cScore > maxScore) {
                    maxScore = cScore;
                    answer = cName;
                }
            }

            return answer;
        }
    }
}
