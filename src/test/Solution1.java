package test;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private static final String TIME_FORMAT = "HH:mm";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String curTimeStr = br.readLine();
        LocalTime curTime = LocalTimeConverter.toLocalTime(curTimeStr);

        List<LocalTime> busTimeList = new ArrayList<>();
        String[] busTimeListStr = br.readLine().split(" ");

        for (String busTimeStr : busTimeListStr) {
            busTimeList.add(LocalTimeConverter.toLocalTime(busTimeStr));
        }

        long solve = new Solution().solve(curTime, busTimeList);
        System.out.println(solve);
    }

    static class Solution {

        public long solve(LocalTime curTime, List<LocalTime> busArriveList) {

            long result = Long.MAX_VALUE;
            LocalTime firstArriveTime = busArriveList.get(0);
            for (LocalTime busArriveTime : busArriveList) {
                if (curTime.isBefore(busArriveTime)) {
                    result = Long.min(result, MINUTES.between(curTime, busArriveTime));
                }
                if (firstArriveTime.isAfter(busArriveTime)) {
                    firstArriveTime = busArriveTime;
                }
            }

            if (result == 0) {
                long diffWithMidNight = MINUTES.between(LocalTime.of(23, 59), curTime) + 1;
                long diffCurTimeWithMidNight = MINUTES.between(firstArriveTime, LocalTime.of(0, 0));
                return diffWithMidNight + diffCurTimeWithMidNight;
            }

            return Math.abs(result);
        }
    }

    static class LocalTimeConverter {

        public static LocalTime toLocalTime(String timeStr) {
            return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(TIME_FORMAT));
        }
    }
}
