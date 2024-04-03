package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzby;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@Instrumented
public final class zzeka implements zzeib<zzdmw, zzfev, zzejp> {
    private final Context zza;
    private final zzdnt zzb;
    private final zzcjf zzc;
    private final Executor zzd;

    public zzeka(Context context, zzcjf zzcjf, zzdnt zzdnt, Executor executor) {
        this.zza = context;
        this.zzc = zzcjf;
        this.zzb = zzdnt;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzdmx zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdna(new zzejz(this, zzehw), (zzcop) null));
        zze.zzd().zzj(new zzcwl((zzfev) zzehw.zzb), this.zzd);
        ((zzejp) zzehw.zzc).zzc(zze.zzi());
        return zze.zzg();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzfev, zzejp> zzehw) throws zzfek {
        String str;
        zzfev zzfev = (zzfev) zzehw.zzb;
        Context context = this.zza;
        zzbfd zzbfd = zzfdz.zza.zza.zzd;
        JSONObject jSONObject = zzfdn.zzw;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        zzfev.zzn(context, zzbfd, str, zzby.zzl(zzfdn.zzt), (zzbxn) zzehw.zzc);
    }

    public final /* synthetic */ void zzc(zzehw zzehw, boolean z11, Context context, zzdfe zzdfe) throws zzdoa {
        try {
            ((zzfev) zzehw.zzb).zzu(z11);
            if (this.zzc.zzc < ((Integer) zzbgq.zzc().zzb(zzblj.zzax)).intValue()) {
                ((zzfev) zzehw.zzb).zzv();
            } else {
                ((zzfev) zzehw.zzb).zzw(context);
            }
        } catch (zzfek e11) {
            zzciz.zzi("Cannot show interstitial.");
            throw new zzdoa(e11.getCause());
        }
    }
}
