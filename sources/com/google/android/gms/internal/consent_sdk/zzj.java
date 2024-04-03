package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

public final class zzj implements ConsentInformation {
    private final zzal zza;
    private final zzp zzb;
    private final zzaz zzc;

    public zzj(zzal zzal, zzp zzp, zzaz zzaz) {
        this.zza = zzal;
        this.zzb = zzp;
        this.zzc = zzaz;
    }

    public final int getConsentStatus() {
        return this.zza.zza();
    }

    public final int getConsentType() {
        return this.zza.zzb();
    }

    public final boolean isConsentFormAvailable() {
        return this.zzc.zza();
    }

    public final void requestConsentInfoUpdate(@Nullable Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzb.zza(activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
    }

    public final void reset() {
        this.zzc.zza((zzbb) null);
        this.zza.zzf();
    }
}
