package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

final /* synthetic */ class zzu implements Runnable {
    private final ConsentInformation.OnConsentInfoUpdateSuccessListener zza;

    private zzu(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = onConsentInfoUpdateSuccessListener;
    }

    public static Runnable zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        return new zzu(onConsentInfoUpdateSuccessListener);
    }

    public final void run() {
        this.zza.onConsentInfoUpdateSuccess();
    }
}
