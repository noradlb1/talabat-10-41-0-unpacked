package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzcpk implements Runnable {
    public final /* synthetic */ zzcpl zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcpk(zzcpl zzcpl, Map map) {
        this.zza = zzcpl;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
