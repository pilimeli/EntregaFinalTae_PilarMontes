package com.globant.utils;

import java.time.Duration;

/**
 * Class to convert the time to do the duration order
 */
public class DateUtils {
    private static String cleanDurationText(String duration) {
        return duration.substring(0, duration.indexOf("(")).trim();
    }

    public static Duration getDuration(String duration) {
        String[] elements = cleanDurationText(duration).split(" ");
        Duration time = Duration.ZERO;
        for (String element : elements) {
            if (element.contains("h")) {
                time = time.plusHours(Integer.parseInt(element.replace("h", "").trim()));
            } else if (element.contains("m")) {
                time = time.plusMinutes(Integer.parseInt(element.replace("m", "").trim()));
            }
        }

        return time;
    }
}

