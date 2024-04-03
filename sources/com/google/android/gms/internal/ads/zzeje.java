package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

@Instrumented
public final class zzeje implements zzeib<zzcyw, zzbzo, zzejp> {
    private final Context zza;
    private final zzczt zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbxq zzd;

    public zzeje(Context context, zzczt zzczt) {
        this.zza = context;
        this.zzb = zzczt;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws zzfek, zzelj {
        View view;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() || !zzfdn.zzae) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfek(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzfwq.zzn(zzfwq.zzi(null), new zzejb(this, view, zzfdn), zzcjm.zze).get();
                    } catch (InterruptedException | ExecutionException e11) {
                        throw new zzfek(e11);
                    }
                }
            } catch (RemoteException e12) {
                throw new zzfek(e12);
            }
        }
        zzcyx zza2 = this.zzb.zza(new zzdbk(zzfdz, zzfdn, zzehw.zza), new zzczd(view, (zzcop) null, new zzeja(zzehw), zzfdn.zzv.get(0)));
        zza2.zzg().zza(view);
        ((zzejp) zzehw.zzc).zzc(zza2.zzh());
        return zza2.zza();
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzbzo, zzejp> zzehw) throws zzfek {
        String str;
        String str2;
        try {
            ((zzbzo) zzehw.zzb).zzp(zzfdn.zzW);
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() || !zzfdn.zzae) {
                zzbzo zzbzo = (zzbzo) zzehw.zzb;
                String str3 = zzfdn.zzR;
                JSONObject jSONObject = zzfdn.zzw;
                if (!(jSONObject instanceof JSONObject)) {
                    str = jSONObject.toString();
                } else {
                    str = JSONObjectInstrumentation.toString(jSONObject);
                }
                zzbzo.zzi(str3, str, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzehw, (zzejc) null), (zzbxn) zzehw.zzc, zzfdz.zza.zza.zze);
                return;
            }
            zzbzo zzbzo2 = (zzbzo) zzehw.zzb;
            String str4 = zzfdn.zzR;
            JSONObject jSONObject2 = zzfdn.zzw;
            if (!(jSONObject2 instanceof JSONObject)) {
                str2 = jSONObject2.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject2);
            }
            zzbzo2.zzj(str4, str2, zzfdz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzehw, (zzejc) null), (zzbxn) zzehw.zzc, zzfdz.zza.zza.zze);
        } catch (RemoteException e11) {
            throw new zzfek(e11);
        }
    }

    public final /* synthetic */ zzfxa zzc(View view, zzfdn zzfdn, Object obj) throws Exception {
        return zzfwq.zzi(zzdak.zza(this.zza, view, zzfdn));
    }
}
