package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzekt implements zzeib<zzdpx, zzbzo, zzejp> {
    private final Context zza;
    private final zzdop zzb;
    /* access modifiers changed from: private */
    public zzbxw zzc;
    private final zzcjf zzd;

    public zzekt(Context context, zzdop zzdop, zzcjf zzcjf) {
        this.zza = context;
        this.zzb = zzdop;
        this.zzd = zzcjf;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        if (zzfdz.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdqc zzs = zzdqc.zzs(this.zzc);
            if (zzfdz.zza.zza.zzg.contains(Integer.toString(zzs.zzc()))) {
                zzdqe zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdqo(zzs), new zzdsb((zzbxt) null, (zzbxs) null, this.zzc, (byte[]) null));
                ((zzejp) zzehw.zzc).zzc(zze.zzh());
                return zze.zza();
            }
            throw new zzelj(1, "No corresponding native ad listener");
        }
        throw new zzelj(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzbzo, zzejp> zzehw) throws zzfek {
        String str;
        String str2;
        try {
            ((zzbzo) zzehw.zzb).zzp(zzfdn.zzW);
            if (this.zzd.zzc < ((Integer) zzbgq.zzc().zzb(zzblj.zzbj)).intValue()) {
                zzbzo zzbzo = (zzbzo) zzehw.zzb;
                String str3 = zzfdn.zzR;
                JSONObject jSONObject = zzfdn.zzw;
                if (!(jSONObject instanceof JSONObject)) {
                    str2 = jSONObject.toString();
                } else {
                    str2 = JSONObjectInstrumentation.toString(jSONObject);
                }
                zzbzo.zzl(str3, str2, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeks(this, zzehw, (zzekr) null), (zzbxn) zzehw.zzc);
                return;
            }
            zzbzo zzbzo2 = (zzbzo) zzehw.zzb;
            String str4 = zzfdn.zzR;
            JSONObject jSONObject2 = zzfdn.zzw;
            if (!(jSONObject2 instanceof JSONObject)) {
                str = jSONObject2.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject2);
            }
            zzbzo2.zzm(str4, str, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeks(this, zzehw, (zzekr) null), (zzbxn) zzehw.zzc, zzfdz.zza.zza.zzi);
        } catch (RemoteException e11) {
            throw new zzfek(e11);
        }
    }
}
