package com.example.shekhar.locationalert.util;

import android.location.Location;

import com.example.shekhar.locationalert.entity.StoredReminder;

import java.util.Comparator;

/**
 * Created by Shekhar Timsina on 9/04/2016.
 */
public class DistanceComparator implements Comparator<StoredReminder> {

    private static DistanceComparator sInstance;

    public static DistanceComparator getInstance() {
        if (sInstance == null) {
            sInstance = new DistanceComparator();
        }
        return sInstance;
    }

    private Location mLastLocation;


    @Override
    public int compare(StoredReminder lhs, StoredReminder rhs) {
        Location lloc = lhs.makeLocation();
        Location rloc = rhs.makeLocation();
        return (int) (lloc.distanceTo(mLastLocation) -
                rloc.distanceTo(mLastLocation));
    }


    public void setLastKnownLocation(Location lastKnownLocation) {
        this.mLastLocation = lastKnownLocation;
    }
}
