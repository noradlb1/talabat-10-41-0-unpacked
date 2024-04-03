package com.google.android.gms.internal.ads;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@Instrumented
public final class zzemk implements zzeib<zzdvn, zzfev, zzejq> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdvs zzc;

    public zzemk(Context context, Executor executor, zzdvs zzdvs) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdvs;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzfev, zzejq> zzehw) {
        String str;
        String str2;
        try {
            zzfev zzfev = (zzfev) zzehw.zzb;
            zzbfd zzbfd = zzfdz.zza.zza.zzd;
            JSONObject jSONObject = zzfdn.zzw;
            if (!(jSONObject instanceof JSONObject)) {
                str2 = jSONObject.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject);
            }
            zzfev.zzk(zzbfd, str2);
        } catch (Exception e11) {
            String valueOf = String.valueOf(zzehw.zza);
            if (valueOf.length() != 0) {
                str = "Fail to load ad from adapter ".concat(valueOf);
            } else {
                str = new String("Fail to load ad from adapter ");
            }
            zzciz.zzk(str, e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzdvo zze = this.zzc.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdvp(new zzemg(zzehw)));
        zze.zzd().zzj(new zzcwl((zzfev) zzehw.zzb), this.zzb);
        zzdfy zze2 = zze.zze();
        zzdep zzb2 = zze.zzb();
        ((zzejq) zzehw.zzc).zzc(new zzemj(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzk();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzfev, zzejq> zzehw) throws zzfek {
        String str;
        if (!((zzfev) zzehw.zzb).zzA()) {
            ((zzejq) zzehw.zzc).zzd(new zzemi(this, zzfdz, zzfdn, zzehw));
            zzfev zzfev = (zzfev) zzehw.zzb;
            Context context = this.zza;
            zzbfd zzbfd = zzfdz.zza.zza.zzd;
            zzcer zzcer = (zzcer) zzehw.zzc;
            JSONObject jSONObject = zzfdn.zzw;
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            zzfev.zzh(context, zzbfd, (String) null, zzcer, str);
            return;
        }
        zze(zzfdz, zzfdn, zzehw);
    }
}
