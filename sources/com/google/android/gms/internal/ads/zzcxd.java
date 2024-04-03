package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final /* synthetic */ class zzcxd implements Runnable {
    public final /* synthetic */ zzcop zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcxd(zzcop zzcop, JSONObject jSONObject) {
        this.zza = zzcop;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
