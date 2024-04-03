package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzcib implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcjr zzb;

    public zzcib(zzcic zzcic, Context context, zzcjr zzcjr) {
        this.zza = context;
        this.zzb = zzcjr;
    }

    public final void run() {
        try {
            this.zzb.zzd(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e11) {
            this.zzb.zze(e11);
            zzciz.zzh("Exception while getting advertising Id info", e11);
        }
    }
}
