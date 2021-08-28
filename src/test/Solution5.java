package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int colorNum = Integer.parseInt(firstLine[0]);
        int clothNum = Integer.parseInt(firstLine[1]);;

        String[] secondLine = br.readLine().split(" ");

        Map<String, List<Integer>> timeClothMap = new HashMap<>();
        for (int i = 0; i < secondLine.length; ++i) {
            timeClothMap.put(secondLine[i], new ArrayList<>());
        }
        for (int i = 0; i < clothNum; ++i) {
            String[] timeWithCloth = br.readLine().split(" ");
            timeClothMap.get(timeWithCloth[1]).add(Integer.parseInt(timeWithCloth[0]));
        }

        int result = new Solution().solve(timeClothMap);
        System.out.println(result);
    }

    static class Solution {

        public int solve(Map<String, List<Integer>> timeClothMap) {
            int result = 0;
            for (Entry<String, List<Integer>> entry : timeClothMap.entrySet()) {
                List<Integer> timeList = entry.getValue();
                Collections.sort(timeList, Collections.reverseOrder());

                for (int i = 0; i < timeList.size(); ++i) {
                    if (i % 2 == 0) {
                        result += timeList.get(i);
                    }
                }
            }

            return result;
        }
    }
}
