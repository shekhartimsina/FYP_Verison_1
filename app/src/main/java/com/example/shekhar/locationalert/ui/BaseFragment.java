package com.example.shekhar.locationalert.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by Shekhar Timsina on 8/29/2016.
 */
public class BaseFragment extends Fragment {


    private BaseActivity mActivity;

    @Override
    public void onAttach(Activity activity) {

        try {
            mActivity = (BaseActivity) activity;
        } catch (ClassCastException ex) {
            throw new RuntimeException(this.getClass().getSimpleName() + " can only be attached to a BaseActivity");
        }
        super.onAttach(activity);
    }

    /**
     * Returns the parent {@linkplain BaseActivity} of this fragment.
     *
     */
    protected BaseActivity getBaseActivity() {
        return mActivity;
    }
}
