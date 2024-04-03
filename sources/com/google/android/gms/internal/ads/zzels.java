package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzels implements zzeib<zzdvn, zzbzo, zzejp> {
    private final Context zza;
    private final zzdvs zzb;

    public zzels(Context context, zzdvs zzdvs) {
        this.zza = context;
        this.zzb = zzdvs;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzejy zzejy = new zzejy(zzfdn, (zzbzo) zzehw.zzb, true);
        zzdvo zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdvp(zzejy));
        zzejy.zzb(zze.zzc());
        ((zzejp) zzehw.zzc).zzc(zze.zzn());
        return zze.zzk();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzbzo, zzejp> zzehw) throws zzfek {
        String str;
        String str2;
        try {
            ((zzbzo) zzehw.zzb).zzp(zzfdn.zzW);
            if (zzfdz.zza.zza.zzo.zza == 3) {
                zzbzo zzbzo = (zzbzo) zzehw.zzb;
                String str3 = zzfdn.zzR;
                JSONObject jSONObject = zzfdn.zzw;
                if (!(jSONObject instanceof JSONObject)) {
                    str2 = jSONObject.toString();
                } else {
                    str2 = JSONObjectInstrumentation.toString(jSONObject);
                }
                zzbzo.zzn(str3, str2, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelr(this, zzehw, (zzelq) null), (zzbxn) zzehw.zzc);
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
            zzbzo2.zzo(str4, str, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelr(this, zzehw, (zzelq) null), (zzbxn) zzehw.zzc);
        } catch (RemoteException e11) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e11);
        }
    }
}
