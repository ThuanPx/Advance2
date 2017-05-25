package com.example.ths.demosearchuserrx.utils.commom;

/**
 * Created by ths on 19/05/2017.
 */

public class StringUtils {
    private StringUtils() {
        // No-op
    }

    public static boolean isBlank(String input) {
        return input.isEmpty();
    }

    public static boolean isNotBlank(String input) {
        return !isBlank(input);
    }

    public static int convertStringToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }
}
