package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzaw;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzcuu extends zzbia {
    private final Context zza;
    private final zzcjf zzb;
    private final zzdww zzc;
    private final zzehv<zzfev, zzejq> zzd;
    private final zzenu zze;
    private final zzebb zzf;
    private final zzchh zzg;
    private final zzdxb zzh;
    private final zzebt zzi;
    private final zzbnp zzj;
    @GuardedBy("this")
    private boolean zzk = false;

    public zzcuu(Context context, zzcjf zzcjf, zzdww zzdww, zzehv<zzfev, zzejq> zzehv, zzenu zzenu, zzebb zzebb, zzchh zzchh, zzdxb zzdxb, zzebt zzebt, zzbnp zzbnp) {
        this.zza = context;
        this.zzb = zzcjf;
        this.zzc = zzdww;
        this.zzd = zzehv;
        this.zze = zzenu;
        this.zzf = zzebb;
        this.zzg = zzchh;
        this.zzh = zzdxb;
        this.zzi = zzebt;
        this.zzj = zzbnp;
    }

    @VisibleForTesting
    public final void zzb() {
        if (zzt.zzo().zzh().zzK()) {
            if (!zzt.zzs().zzj(this.zza, zzt.zzo().zzh().zzk(), this.zzb.zza)) {
                zzt.zzo().zzh().zzz(false);
                zzt.zzo().zzh().zzy("");
            }
        }
    }

    @VisibleForTesting
    public final void zzc(Runnable runnable) {
        String str;
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzbxc> zze2 = zzt.zzo().zzh().zzg().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th2) {
                    zzciz.zzk("Could not initialize rewarded ads.", th2);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbxc zzbxc : zze2.values()) {
                    for (zzbxb next : zzbxc.zza) {
                        String str2 = next.zzk;
                        for (String next2 : next.zzc) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str2 != null) {
                                ((Collection) hashMap.get(next2)).add(str2);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzehw<zzfev, zzejq> zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfev zzfev = (zzfev) zza2.zzb;
                            if (!zzfev.zzA() && zzfev.zzz()) {
                                zzfev.zzj(this.zza, (zzejq) zza2.zzc, (List) entry.getValue());
                                String valueOf = String.valueOf(str3);
                                if (valueOf.length() != 0) {
                                    str = "Initialized rewarded video mediation adapter ".concat(valueOf);
                                } else {
                                    str = new String("Initialized rewarded video mediation adapter ");
                                }
                                zzciz.zze(str);
                            }
                        }
                    } catch (zzfek e11) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 56);
                        sb2.append("Failed to initialize rewarded video mediation adapter \"");
                        sb2.append(str3);
                        sb2.append("\"");
                        zzciz.zzk(sb2.toString(), e11);
                    }
                }
            }
        }
    }

    public final /* synthetic */ void zzd() {
        this.zzj.zza(new zzccy());
    }

    public final synchronized float zze() {
        return zzt.zzr().zza();
    }

    public final String zzf() {
        return this.zzb.zza;
    }

    public final List<zzbtn> zzg() throws RemoteException {
        return this.zzf.zzf();
    }

    public final void zzh(String str) {
        this.zze.zzf(str);
    }

    public final void zzi() {
        this.zzf.zzk();
    }

    public final synchronized void zzj() {
        if (this.zzk) {
            zzciz.zzj("Mobile ads is initialized already.");
            return;
        }
        zzblj.zzc(this.zza);
        zzt.zzo().zzq(this.zza, this.zzb);
        zzt.zzc().zzi(this.zza);
        this.zzk = true;
        this.zzf.zzq();
        this.zze.zzd();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcB)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzf();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue()) {
            zzcjm.zza.execute(new zzcuq(this));
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhr)).booleanValue()) {
            zzcjm.zza.execute(new zzcur(this));
        }
    }

    public final void zzk(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzcut zzcut;
        zzblj.zzc(this.zza);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcD)).booleanValue()) {
            zzt.zzp();
            str2 = com.google.android.gms.ads.internal.util.zzt.zzv(this.zza);
        } else {
            str2 = "";
        }
        boolean z11 = true;
        if (true != TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzcA)).booleanValue();
            zzblb zzblb = zzblj.zzaE;
            boolean booleanValue2 = booleanValue | ((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue();
            if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                zzcut = new zzcut(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                z11 = booleanValue2;
                zzcut = null;
            }
            if (z11) {
                zzt.zza().zza(this.zza, this.zzb, str, zzcut);
            }
        }
    }

    public final void zzl(zzbin zzbin) throws RemoteException {
        this.zzi.zzg(zzbin, zzebs.API);
    }

    public final void zzm(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzciz.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzciz.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzaw zzaw = new zzaw(context);
        zzaw.zzn(str);
        zzaw.zzo(this.zzb.zza);
        zzaw.zzr();
    }

    public final void zzn(zzbxh zzbxh) throws RemoteException {
        this.zzc.zzc(zzbxh);
    }

    public final synchronized void zzo(boolean z11) {
        zzt.zzr().zzc(z11);
    }

    public final synchronized void zzp(float f11) {
        zzt.zzr().zzd(f11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzblj.zzc(r0)     // Catch:{ all -> 0x002e }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzcA     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            com.google.android.gms.ads.internal.zze r0 = com.google.android.gms.ads.internal.zzt.zza()     // Catch:{ all -> 0x002e }
            android.content.Context r1 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzcjf r2 = r4.zzb     // Catch:{ all -> 0x002e }
            r3 = 0
            r0.zza(r1, r2, r5, r3)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)
            return
        L_0x002c:
            monitor-exit(r4)
            return
        L_0x002e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcuu.zzq(java.lang.String):void");
    }

    public final void zzr(zzbtu zzbtu) throws RemoteException {
        this.zzf.zzr(zzbtu);
    }

    public final void zzs(zzbkk zzbkk) throws RemoteException {
        this.zzg.zzq(this.zza, zzbkk);
    }

    public final synchronized boolean zzt() {
        return zzt.zzr().zze();
    }
}
