package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzcoe implements Runnable {
    public final /* synthetic */ zzclh zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcoe(zzclh zzclh, Map map) {
        this.zza = zzclh;
        this.zzb = map;
    }

    public final void run() {
        zzclh zzclh = this.zza;
        Map map = this.zzb;
        int i11 = zzcof.zzc;
        zzclh.zzd("onGcacheInfoEvent", map);
    }
}
