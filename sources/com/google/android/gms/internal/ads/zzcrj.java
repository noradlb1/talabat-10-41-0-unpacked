package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONObject;

public final class zzcrj implements zzgpr<zzceb> {
    private final zzgqe<Context> zza;

    public zzcrj(zzgqe<Context> zzgqe) {
        this.zza = zzgqe;
    }

    /* renamed from: zza */
    public final zzceb zzb() {
        Context zza2 = ((zzcqr) this.zza).zza();
        zzbwh zzb = zzt.zzf().zzb(zza2, zzcjf.zza());
        zzbwb<JSONObject> zzbwb = zzbwe.zza;
        zzb.zza("google.afma.request.getAdDictionary", zzbwb, zzbwb);
        return new zzcea(zza2, zzt.zzf().zzb(zza2, zzcjf.zza()).zza("google.afma.sdkConstants.getSdkConstants", zzbwb, zzbwb));
    }
}
