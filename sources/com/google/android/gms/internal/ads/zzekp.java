package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzby;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@Instrumented
public final class zzekp implements zzeib<zzdpx, zzfev, zzejp> {
    private final Context zza;
    private final zzdop zzb;
    private final Executor zzc;

    public zzekp(Context context, zzdop zzdop, Executor executor) {
        this.zza = context;
        this.zzb = zzdop;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfdz zzfdz, int i11) {
        return zzfdz.zza.zza.zzg.contains(Integer.toString(i11));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzdqc zzdqc;
        zzbxs zzB = ((zzfev) zzehw.zzb).zzB();
        zzbxt zzC = ((zzfev) zzehw.zzb).zzC();
        zzbxw zzd = ((zzfev) zzehw.zzb).zzd();
        if (zzd != null && zzc(zzfdz, 6)) {
            zzdqc = zzdqc.zzs(zzd);
        } else if (zzB != null && zzc(zzfdz, 6)) {
            zzdqc = zzdqc.zzad(zzB);
        } else if (zzB != null && zzc(zzfdz, 2)) {
            zzdqc = zzdqc.zzab(zzB);
        } else if (zzC != null && zzc(zzfdz, 6)) {
            zzdqc = zzdqc.zzae(zzC);
        } else if (zzC == null || !zzc(zzfdz, 1)) {
            throw new zzelj(1, "No native ad mappers");
        } else {
            zzdqc = zzdqc.zzac(zzC);
        }
        if (zzfdz.zza.zza.zzg.contains(Integer.toString(zzdqc.zzc()))) {
            zzdqe zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdqo(zzdqc), new zzdsb(zzC, zzB, zzd, (byte[]) null));
            ((zzejp) zzehw.zzc).zzc(zze.zzi());
            zze.zzd().zzj(new zzcwl((zzfev) zzehw.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzelj(1, "No corresponding native ad listener");
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
        zzfef zzfef = zzfdz.zza.zza;
        zzfev.zzo(context, zzbfd, str, zzby.zzl(zzfdn.zzt), (zzbxn) zzehw.zzc, zzfef.zzi, zzfef.zzg);
    }
}
