package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzejg implements zzdob {
    public final /* synthetic */ zzcjr zza;

    public /* synthetic */ zzejg(zzcjr zzcjr) {
        this.zza = zzcjr;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) {
        zzcjr zzcjr = this.zza;
        try {
            zzt.zzj();
            zzm.zza(context, (AdOverlayInfoParcel) zzcjr.get(), true);
        } catch (Exception unused) {
        }
    }
}
