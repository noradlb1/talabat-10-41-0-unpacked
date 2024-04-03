package com.google.android.ump;

import android.app.Activity;
import androidx.annotation.Nullable;

public interface ConsentForm {

    public interface OnConsentFormDismissedListener {
        void onConsentFormDismissed(@Nullable FormError formError);
    }

    void show(Activity activity, OnConsentFormDismissedListener onConsentFormDismissedListener);
}
