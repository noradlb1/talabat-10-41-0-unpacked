package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzeez implements Callable {
    public final /* synthetic */ zzfxa zza;
    public final /* synthetic */ zzfxa zzb;

    public /* synthetic */ zzeez(zzfxa zzfxa, zzfxa zzfxa2) {
        this.zza = zzfxa;
        this.zzb = zzfxa2;
    }

    public final Object call() {
        return new zzefn((JSONObject) this.zza.get(), (zzcdt) this.zzb.get());
    }
}
