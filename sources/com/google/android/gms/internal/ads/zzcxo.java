package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final /* synthetic */ class zzcxo implements Runnable {
    public final /* synthetic */ zzcxp zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcxo(zzcxp zzcxp, JSONObject jSONObject) {
        this.zza = zzcxp;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
