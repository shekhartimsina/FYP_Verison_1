package com.example.shekhar.locationalert.util;

/**
 * Created by Shekhar Timsina on 9/04/2016.
 */

final public class LocationUtils {
    public static String createLocationString(double latitude, double longtitude) {
        return String.format("(%f, %f)", latitude, longtitude);
    }
}
