package com.example.shekhar.locationalert.ui.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.support.v4.content.LocalBroadcastManager;

import com.example.shekhar.locationalert.App;
import com.example.shekhar.locationalert.db.DBHelper;
import com.example.shekhar.locationalert.entity.StoredReminder;
import com.example.shekhar.locationalert.ui.fragment.AppConfigs;
import com.example.shekhar.locationalert.util.DistanceComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Shekhar Timsina on 9/01/2016.
 */
public class ReminderListLoader extends SimpleAsyncTaskLoader<ArrayList<StoredReminder>> {

    private EventEdited mReceiver;

    public ReminderListLoader(Context context) {
        super(context);
        mReceiver = new EventEdited();
        IntentFilter filter = new IntentFilter(App.ACTION_REMINDER_EDITED);
        getContext().registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onAbandon() {
        super.onAbandon();
        getContext().unregisterReceiver(mReceiver);
    }

    @Override
    public ArrayList<StoredReminder> loadInBackground() {

        ArrayList<StoredReminder> mList = DBHelper.getInstance(getContext()).getAllReminders();
        if (AppConfigs.getListOrderedByDistance(getContext())) {
            LocationManager manager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
            DistanceComparator.getInstance().setLastKnownLocation(manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
            Collections.sort(mList, DistanceComparator.getInstance());
        } else {
            Collections.sort(mList);
        }

        return mList;
    }


    private class EventEdited extends BroadcastReceiver {


        public EventEdited() {
            IntentFilter filter = new IntentFilter();
            filter.addAction(App.ACTION_REMINDER_EDITED);
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this, filter);

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            onContentChanged();
        }
    }


}

