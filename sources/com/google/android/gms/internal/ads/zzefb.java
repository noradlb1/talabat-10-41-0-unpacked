package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzefb implements Callable {
    public final /* synthetic */ zzfxa zza;
    public final /* synthetic */ zzfxa zzb;
    public final /* synthetic */ zzfxa zzc;

    public /* synthetic */ zzefb(zzfxa zzfxa, zzfxa zzfxa2, zzfxa zzfxa3) {
        this.zza = zzfxa;
        this.zzb = zzfxa2;
        this.zzc = zzfxa3;
    }

    public final Object call() {
        return new zzefg((zzefk) this.zza.get(), (JSONObject) this.zzb.get(), (zzcdt) this.zzc.get());
    }
}
