package com.example.shekhar.locationalert.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.shekhar.locationalert.ui.BaseDialog;

/**
 * Created by Shekhar Timsina on 8/31/2016.
 */
public class ProgressDialog extends BaseDialog {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new android.app.ProgressDialog(getActivity());
    }
}