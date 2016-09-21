package com.example.shekhar.locationalert.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.shekhar.locationalert.App;
import com.example.shekhar.locationalert.R;
import com.example.shekhar.locationalert.db.DBHelper;
import com.example.shekhar.locationalert.entity.StoredReminder;
import com.example.shekhar.locationalert.ui.BaseDialog;

/**
 * Created by Shekhar Timsina on 8/31/2016.
 */
public class DeleteReminderDialog extends BaseDialog {

    private static final String EXTRA_REMINDER_ID = App.PACKAGE + ".reminder_id";

    public DeleteReminderDialog() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        long reminderID = getArguments().getLong(EXTRA_REMINDER_ID);
        StoredReminder reminder = DBHelper.getInstance(getActivity()).getReminder(reminderID);

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setMessage(R.string.delete_reminder_title)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mListener != null) {
                            mListener.onPositiveButtonClicked();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .create();
        return dialog;
    }

    public static DeleteReminderDialog newInstance(long id) {
        Bundle bundle = new Bundle(1);
        DeleteReminderDialog dialog = new DeleteReminderDialog();
        bundle.putLong(EXTRA_REMINDER_ID, id);
        dialog.setArguments(bundle);
        return dialog;
    }

    public interface OnButtonClickListener {

        void onPositiveButtonClicked();
    }

    private OnButtonClickListener mListener;

    public void setPositiveListener(OnButtonClickListener l) {
        this.mListener = l;

    }
}

