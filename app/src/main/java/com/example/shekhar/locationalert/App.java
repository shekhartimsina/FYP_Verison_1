package com.example.shekhar.locationalert;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Shekhar Timsina on 8/20/2016.
 */
public class App extends Application {

    public static final String PACKAGE = "com.alexsstyl.locationreminder";
    public static final String ACTION_REMINDER_EDITED = "ACTION_REMINDER_EDITED";

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static void broadcastOnReminderCreated(Context context) {
        Intent intent = new Intent(ACTION_REMINDER_EDITED);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
