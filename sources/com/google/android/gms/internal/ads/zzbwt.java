package com.google.android.gms.internal.ads;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzbwt<I, O> implements zzfvx<I, O> {
    private final zzbvz<O> zza;
    private final zzbwa<I> zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final zzfxa<zzbvu> zzd;

    public zzbwt(zzfxa<zzbvu> zzfxa, String str, zzbwa<I> zzbwa, zzbvz<O> zzbvz) {
        this.zzd = zzfxa;
        this.zzb = zzbwa;
        this.zza = zzbvz;
    }

    public final zzfxa<O> zza(I i11) throws Exception {
        return zzb(i11);
    }

    public final zzfxa<O> zzb(I i11) {
        return zzfwq.zzn(this.zzd, new zzbwr(this, i11), zzcjm.zzf);
    }

    public final /* synthetic */ zzfxa zzc(Object obj, zzbvu zzbvu) throws Exception {
        zzcjr zzcjr = new zzcjr();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbrs.zzo.zzc(uuid, new zzbws(this, zzcjr));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) uuid);
        jSONObject.put(StepData.ARGS, (Object) (JSONObject) obj);
        zzbvu.zzl(this.zzc, jSONObject);
        return zzcjr;
    }
}
