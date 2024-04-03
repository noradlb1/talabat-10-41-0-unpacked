package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.zza;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@Instrumented
public final class zzeiy implements zzeib<zzcyw, zzfev, zzejp> {
    private final Context zza;
    private final zzczt zzb;
    private final Executor zzc;

    public zzeiy(Context context, zzczt zzczt, Executor executor) {
        this.zza = context;
        this.zzb = zzczt;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzfdz r7, com.google.android.gms.internal.ads.zzfdn r8, com.google.android.gms.internal.ads.zzehw r9) throws com.google.android.gms.internal.ads.zzfek, com.google.android.gms.internal.ads.zzelj {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzfI
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzae
            if (r0 == 0) goto L_0x0077
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfev r0 = (com.google.android.gms.internal.ads.zzfev) r0
            com.google.android.gms.internal.ads.zzbxq r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzfxa r0 = com.google.android.gms.internal.ads.zzfwq.zzi(r1)
            com.google.android.gms.internal.ads.zzeix r3 = new com.google.android.gms.internal.ads.zzeix
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzfxb r2 = com.google.android.gms.internal.ads.zzcjm.zze
            com.google.android.gms.internal.ads.zzfxa r0 = com.google.android.gms.internal.ads.zzfwq.zzn(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzfek r8 = new com.google.android.gms.internal.ads.zzfek
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzfek r7 = new com.google.android.gms.internal.ads.zzfek
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzfek r8 = new com.google.android.gms.internal.ads.zzfek
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.internal.ads.zzciz.zzg(r7)
            com.google.android.gms.internal.ads.zzfek r8 = new com.google.android.gms.internal.ads.zzfek
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfev r0 = (com.google.android.gms.internal.ads.zzfev) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzczt r0 = r6.zzb
            com.google.android.gms.internal.ads.zzdbk r3 = new com.google.android.gms.internal.ads.zzdbk
            java.lang.String r4 = r9.zza
            r3.<init>(r7, r8, r4)
            com.google.android.gms.internal.ads.zzczd r7 = new com.google.android.gms.internal.ads.zzczd
            AdapterT r4 = r9.zzb
            com.google.android.gms.internal.ads.zzfev r4 = (com.google.android.gms.internal.ads.zzfev) r4
            com.google.android.gms.internal.ads.zzeiw r5 = new com.google.android.gms.internal.ads.zzeiw
            r5.<init>(r4)
            java.util.List<com.google.android.gms.internal.ads.zzfdo> r8 = r8.zzv
            r4 = 0
            java.lang.Object r8 = r8.get(r4)
            com.google.android.gms.internal.ads.zzfdo r8 = (com.google.android.gms.internal.ads.zzfdo) r8
            r7.<init>(r2, r1, r5, r8)
            com.google.android.gms.internal.ads.zzcyx r7 = r0.zza(r3, r7)
            com.google.android.gms.internal.ads.zzdly r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzdfq r8 = r7.zzd()
            com.google.android.gms.internal.ads.zzcwl r0 = new com.google.android.gms.internal.ads.zzcwl
            AdapterT r1 = r9.zzb
            com.google.android.gms.internal.ads.zzfev r1 = (com.google.android.gms.internal.ads.zzfev) r1
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r6.zzc
            r8.zzj(r0, r1)
            ListenerT r8 = r9.zzc
            com.google.android.gms.internal.ads.zzejp r8 = (com.google.android.gms.internal.ads.zzejp) r8
            com.google.android.gms.internal.ads.zzemv r9 = r7.zzi()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcyw r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiy.zza(com.google.android.gms.internal.ads.zzfdz, com.google.android.gms.internal.ads.zzfdn, com.google.android.gms.internal.ads.zzehw):java.lang.Object");
    }

    public final void zzb(zzfdz zzfdz, zzfdn zzfdn, zzehw<zzfev, zzejp> zzehw) throws zzfek {
        zzbfi zza2;
        String str;
        String str2;
        zzbfi zzbfi = zzfdz.zza.zza.zze;
        if (zzbfi.zzn) {
            zza2 = new zzbfi(this.zza, zza.zzd(zzbfi.zze, zzbfi.zzb));
        } else {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() || !zzfdn.zzae) {
                zza2 = zzfej.zza(this.zza, zzfdn.zzv);
            } else {
                zza2 = new zzbfi(this.zza, zza.zze(zzbfi.zze, zzbfi.zzb));
            }
        }
        zzbfi zzbfi2 = zza2;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() || !zzfdn.zzae) {
            zzfev zzfev = (zzfev) zzehw.zzb;
            Context context = this.zza;
            zzbfd zzbfd = zzfdz.zza.zza.zzd;
            JSONObject jSONObject = zzfdn.zzw;
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            zzfev.zzl(context, zzbfi2, zzbfd, str, zzby.zzl(zzfdn.zzt), (zzbxn) zzehw.zzc);
            return;
        }
        zzfev zzfev2 = (zzfev) zzehw.zzb;
        Context context2 = this.zza;
        zzbfd zzbfd2 = zzfdz.zza.zza.zzd;
        JSONObject jSONObject2 = zzfdn.zzw;
        if (!(jSONObject2 instanceof JSONObject)) {
            str2 = jSONObject2.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject2);
        }
        zzfev2.zzm(context2, zzbfi2, zzbfd2, str2, zzby.zzl(zzfdn.zzt), (zzbxn) zzehw.zzc);
    }

    public final /* synthetic */ zzfxa zzc(View view, zzfdn zzfdn, Object obj) throws Exception {
        return zzfwq.zzi(zzdak.zza(this.zza, view, zzfdn));
    }
}
