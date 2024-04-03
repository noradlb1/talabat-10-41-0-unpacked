package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbwl<I, O> implements zzbvx<I, O> {
    /* access modifiers changed from: private */
    public final zzbvz<O> zza;
    private final zzbwa<I> zzb;
    private final zzbvt zzc;
    private final String zzd;

    public zzbwl(zzbvt zzbvt, String str, zzbwa<I> zzbwa, zzbvz<O> zzbvz) {
        this.zzc = zzbvt;
        this.zzd = str;
        this.zzb = zzbwa;
        this.zza = zzbvz;
    }

    public static /* bridge */ /* synthetic */ void zzd(zzbwl zzbwl, zzbvn zzbvn, zzbvu zzbvu, Object obj, zzcjr zzcjr) {
        try {
            zzt.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbrs.zzo.zzc(uuid, new zzbwk(zzbwl, zzbvn, zzcjr));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", (Object) uuid);
            jSONObject.put(StepData.ARGS, (Object) zzbwl.zzb.zzb(obj));
            zzbvu.zzl(zzbwl.zzd, jSONObject);
        } catch (Exception e11) {
            zzcjr.zze(e11);
            zzciz.zzh("Unable to invokeJavascript", e11);
            zzbvn.zzb();
        } catch (Throwable th2) {
            zzbvn.zzb();
            throw th2;
        }
    }

    public final zzfxa<O> zza(@Nullable I i11) throws Exception {
        return zzb(i11);
    }

    public final zzfxa<O> zzb(I i11) {
        zzcjr zzcjr = new zzcjr();
        zzbvn zzb2 = this.zzc.zzb((zzalt) null);
        zzb2.zzi(new zzbwi(this, zzb2, i11, zzcjr), new zzbwj(this, zzcjr, zzb2));
        return zzcjr;
    }
}
