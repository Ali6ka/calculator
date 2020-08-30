package com.opencbs.calculator.utils;

public class NumberUtils {
    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }

    public static double getPercentageOf(double value, double percentage){
        double result = value * (percentage/100.0f);
        return round( result, 2);
    }
}
