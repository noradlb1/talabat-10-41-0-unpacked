package com.google.android.ump;

import android.app.Activity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ConsentInformation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsentStatus {
        public static final int NOT_REQUIRED = 1;
        public static final int OBTAINED = 3;
        public static final int REQUIRED = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsentType {
        public static final int NON_PERSONALIZED = 1;
        public static final int PERSONALIZED = 2;
        public static final int UNKNOWN = 0;
    }

    public interface OnConsentInfoUpdateFailureListener {
        void onConsentInfoUpdateFailure(FormError formError);
    }

    public interface OnConsentInfoUpdateSuccessListener {
        void onConsentInfoUpdateSuccess();
    }

    int getConsentStatus();

    int getConsentType();

    boolean isConsentFormAvailable();

    void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener);

    void reset();
}
