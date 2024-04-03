package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzekm implements Callable {
    public final /* synthetic */ zzekn zza;
    public final /* synthetic */ zzfxa zzb;
    public final /* synthetic */ zzfxa zzc;
    public final /* synthetic */ zzfdz zzd;
    public final /* synthetic */ zzfdn zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzekm(zzekn zzekn, zzfxa zzfxa, zzfxa zzfxa2, zzfdz zzfdz, zzfdn zzfdn, JSONObject jSONObject) {
        this.zza = zzekn;
        this.zzb = zzfxa;
        this.zzc = zzfxa2;
        this.zzd = zzfdz;
        this.zze = zzfdn;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
