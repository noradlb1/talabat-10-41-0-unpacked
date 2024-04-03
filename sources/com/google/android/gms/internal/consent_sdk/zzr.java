package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

final /* synthetic */ class zzr implements Runnable {
    private final zzp zza;
    private final ConsentInformation.OnConsentInfoUpdateSuccessListener zzb;

    public zzr(zzp zzp, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = zzp;
        this.zzb = onConsentInfoUpdateSuccessListener;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
