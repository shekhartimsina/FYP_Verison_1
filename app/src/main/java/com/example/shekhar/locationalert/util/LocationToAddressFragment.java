package com.example.shekhar.locationalert.util;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.shekhar.locationalert.ui.BaseFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Shekhar Timsina on 9/04/2016.
 */
public class LocationToAddressFragment extends BaseFragment {

    public interface OnLocationConverteredListener {

        /**
         * Called when
         *
         * @param address
         * @param requested
         */
        public void onLocationConverted(String address, LatLng requested);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private class LocationToAddressTask extends AsyncTask<LatLng, Void, String> {
        @Override
        protected String doInBackground(LatLng... params) {
            return null;
        }
    }

}

