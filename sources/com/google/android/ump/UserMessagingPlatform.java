package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzc;

public final class UserMessagingPlatform {

    public interface OnConsentFormLoadFailureListener {
        void onConsentFormLoadFailure(FormError formError);
    }

    public interface OnConsentFormLoadSuccessListener {
        void onConsentFormLoadSuccess(ConsentForm consentForm);
    }

    private UserMessagingPlatform() {
    }

    public static ConsentInformation getConsentInformation(Context context) {
        return zzc.zza(context).zza();
    }

    public static void loadConsentForm(Context context, OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzc.zza(context).zzb().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }
}
