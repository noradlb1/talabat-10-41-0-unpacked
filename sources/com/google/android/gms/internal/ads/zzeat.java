package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzeat implements Runnable {
    public final /* synthetic */ zzebb zza;
    public final /* synthetic */ zzcjr zzb;

    public /* synthetic */ zzeat(zzebb zzebb, zzcjr zzcjr) {
        this.zza = zzebb;
        this.zzb = zzcjr;
    }

    public final void run() {
        zzcjr zzcjr = this.zzb;
        String zzc = zzt.zzo().zzh().zzg().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            zzcjr.zzd(zzc);
        } else {
            zzcjr.zze(new Exception());
        }
    }
}
