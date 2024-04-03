package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzeke implements zzeib<zzdmw, zzbzo, zzejp> {
    private final Context zza;
    private final zzdnt zzb;

    public zzeke(Context context, zzdnt zzdnt) {
        this.zza = context;
        this.zzb = zzdnt;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        zzejy zzejy = new zzejy(zzfdn, (zzbzo) zzehw.zzb, false);
        zzdmx zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzdna(zzejy, (zzcop) null));
        zzejy.zzb(zze.zzc());
        ((zzejp) zzehw.zzc).zzc(zze.zzh());
        return zze.zzg();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzbzo, zzejp> zzehw) throws zzfek {
        String str;
        try {
            ((zzbzo) zzehw.zzb).zzp(zzfdn.zzW);
            zzbzo zzbzo = (zzbzo) zzehw.zzb;
            String str2 = zzfdn.zzR;
            JSONObject jSONObject = zzfdn.zzw;
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            zzbzo.zzk(str2, str, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekd(this, zzehw, (zzekc) null), (zzbxn) zzehw.zzc);
        } catch (RemoteException e11) {
            throw new zzfek(e11);
        }
    }
}
