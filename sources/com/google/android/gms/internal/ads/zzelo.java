package com.google.android.gms.internal.ads;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@Instrumented
public final class zzelo implements zzeib<zzdvn, zzfev, zzejp> {
    private final Context zza;
    private final Executor zzb;
    private final zzdvs zzc;

    public zzelo(Context context, Executor executor, zzdvs zzdvs) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdvs;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzdvo zze = this.zzc.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdvp(new zzeln(zzehw)));
        zze.zzd().zzj(new zzcwl((zzfev) zzehw.zzb), this.zzb);
        ((zzejp) zzehw.zzc).zzc(zze.zzm());
        return zze.zzk();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzfev, zzejp> zzehw) throws zzfek {
        String str;
        String str2;
        String str3;
        try {
            zzfef zzfef = zzfdz.zza.zza;
            if (zzfef.zzo.zza == 3) {
                zzfev zzfev = (zzfev) zzehw.zzb;
                Context context = this.zza;
                zzbfd zzbfd = zzfef.zzd;
                JSONObject jSONObject = zzfdn.zzw;
                if (!(jSONObject instanceof JSONObject)) {
                    str3 = jSONObject.toString();
                } else {
                    str3 = JSONObjectInstrumentation.toString(jSONObject);
                }
                zzfev.zzq(context, zzbfd, str3, (zzbxn) zzehw.zzc);
                return;
            }
            zzfev zzfev2 = (zzfev) zzehw.zzb;
            Context context2 = this.zza;
            zzbfd zzbfd2 = zzfef.zzd;
            JSONObject jSONObject2 = zzfdn.zzw;
            if (!(jSONObject2 instanceof JSONObject)) {
                str2 = jSONObject2.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject2);
            }
            zzfev2.zzp(context2, zzbfd2, str2, (zzbxn) zzehw.zzc);
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
}
