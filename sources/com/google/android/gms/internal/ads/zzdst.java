package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

public final /* synthetic */ class zzdst implements zzfpv {
    public final /* synthetic */ zzdtb zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdst(zzdtb zzdtb, JSONObject jSONObject) {
        this.zza = zzdtb;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
