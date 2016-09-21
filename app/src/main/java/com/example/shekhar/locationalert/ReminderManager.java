package com.example.shekhar.locationalert;

import android.content.Context;

/**
 * Created by Shekhar Timsina on 8/20/2016.
 */
final public class ReminderManager {

    private static ReminderManager sInstance;

    private Context mContext;

    private ReminderManager(Context context) {
        this.mContext = context.getApplicationContext();
    }


    public static ReminderManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ReminderManager(context);
        }
        return sInstance;
    }

    public void cancelReminder(long id) {

    }
}
