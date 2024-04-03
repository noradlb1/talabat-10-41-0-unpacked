package com.google.android.gms.ads.internal.util;

import android.content.Context;

public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc = "admob";

    public /* synthetic */ zzi(zzj zzj, Context context, String str) {
        this.zza = zzj;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzM(this.zzb, this.zzc);
    }
}
