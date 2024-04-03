package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

final class zzbqo implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbhk zzb;
    final /* synthetic */ zzbqp zzc;

    public zzbqo(zzbqp zzbqp, AdManagerAdView adManagerAdView, zzbhk zzbhk) {
        this.zzc = zzbqp;
        this.zza = adManagerAdView;
        this.zzb = zzbhk;
    }

    public final void run() {
        if (this.zza.zza(this.zzb)) {
            this.zzc.zza.onAdManagerAdViewLoaded(this.zza);
        } else {
            zzciz.zzj("Could not bind.");
        }
    }
}
