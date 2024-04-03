package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

final class zzcae implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzcaf zzb;

    public zzcae(zzcaf zzcaf, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzb = zzcaf;
        this.zza = adOverlayInfoParcel;
    }

    public final void run() {
        zzt.zzj();
        zzm.zza(this.zzb.zza, this.zza, true);
    }
}
