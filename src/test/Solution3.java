package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String parent = input[0];
        String child = input[1];

        String result = new Solution().solve(parent, child);
        System.out.println(result);
    }

    static class Solution {

        public String solve(String parent, String child) {
            char[] childChars = child.toCharArray();
            Character[] parentChars = parent.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

            List<Character> parentCharList = Arrays.asList(parentChars);
            for (int i = 0; i < childChars.length; ++i) {
                boolean contains = parentCharList.contains(childChars[i]);
                if (!contains) {
                    return "NO";
                }
            }

            return "YES";
        }
    }
}
