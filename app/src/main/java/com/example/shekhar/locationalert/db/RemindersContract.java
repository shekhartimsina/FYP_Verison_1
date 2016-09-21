package com.example.shekhar.locationalert.db;

import android.provider.BaseColumns;

/**
 * Created by Shekhar Timsina on 8/23/2016.
 */
final public class RemindersContract implements BaseColumns {

    public static final String TABLE_NAME = "reminders";

    public static final String NOTE = "note";

    public static final String LONGTITUDE = "longtitude";
    public static final String LATITUDE = "latitude";


    /**
     * The human readable address of the reminder.
     */
    public static final String ADDRESS = "address";


    public static final String FEATURES = "features";

    /**
     * The date the reminder was set or edited
     */
    public static final String DATE_MOTIFIED = "date_modified";
}