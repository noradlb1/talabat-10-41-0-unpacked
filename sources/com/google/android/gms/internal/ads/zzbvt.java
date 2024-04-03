package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzce;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbvt {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final zzcjf zzd;
    private final zzbf<zzbuo> zze;
    private final zzbf<zzbuo> zzf;
    /* access modifiers changed from: private */
    @Nullable
    public zzbvs zzg;
    /* access modifiers changed from: private */
    public int zzh = 1;

    public zzbvt(Context context, zzcjf zzcjf, String str, zzbf<zzbuo> zzbf, zzbf<zzbuo> zzbf2) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzcjf;
        this.zze = zzbf;
        this.zzf = zzbf2;
    }

    public final zzbvn zzb(@Nullable zzalt zzalt) {
        synchronized (this.zza) {
            synchronized (this.zza) {
                zzbvs zzbvs = this.zzg;
                if (zzbvs != null && this.zzh == 0) {
                    zzbvs.zzi(new zzbva(this), zzbuz.zza);
                }
            }
            zzbvs zzbvs2 = this.zzg;
            if (zzbvs2 != null) {
                if (zzbvs2.zze() != -1) {
                    int i11 = this.zzh;
                    if (i11 == 0) {
                        zzbvn zza2 = this.zzg.zza();
                        return zza2;
                    } else if (i11 == 1) {
                        this.zzh = 2;
                        zzd((zzalt) null);
                        zzbvn zza3 = this.zzg.zza();
                        return zza3;
                    } else {
                        zzbvn zza4 = this.zzg.zza();
                        return zza4;
                    }
                }
            }
            this.zzh = 2;
            zzbvs zzd2 = zzd((zzalt) null);
            this.zzg = zzd2;
            zzbvn zza5 = zzd2.zza();
            return zza5;
        }
    }

    public final zzbvs zzd(@Nullable zzalt zzalt) {
        zzbvs zzbvs = new zzbvs(this.zzf);
        zzcjm.zze.execute(new zzbvc(this, (zzalt) null, zzbvs));
        zzbvs.zzi(new zzbvi(this, zzbvs), new zzbvj(this, zzbvs));
        return zzbvs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzh(com.google.android.gms.internal.ads.zzbvs r4, com.google.android.gms.internal.ads.zzbuo r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            int r1 = r4.zze()     // Catch:{ all -> 0x0028 }
            r2 = -1
            if (r1 == r2) goto L_0x0026
            int r1 = r4.zze()     // Catch:{ all -> 0x0028 }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            r4.zzg()     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzfxb r4 = com.google.android.gms.internal.ads.zzcjm.zze     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzbvb r1 = new com.google.android.gms.internal.ads.zzbvb     // Catch:{ all -> 0x0028 }
            r1.<init>(r5)     // Catch:{ all -> 0x0028 }
            r4.execute(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvt.zzh(com.google.android.gms.internal.ads.zzbvs, com.google.android.gms.internal.ads.zzbuo):void");
    }

    public final /* synthetic */ void zzi(zzalt zzalt, zzbvs zzbvs) {
        try {
            zzbuw zzbuw = new zzbuw(this.zzb, this.zzd, (zzalt) null, (zza) null);
            zzbuw.zzk(new zzbuy(this, zzbvs, zzbuw));
            zzbuw.zzq("/jsLoaded", new zzbve(this, zzbvs, zzbuw));
            zzce zzce = new zzce();
            zzbvf zzbvf = new zzbvf(this, (zzalt) null, zzbuw, zzce);
            zzce.zzb(zzbvf);
            zzbuw.zzq("/requestReload", zzbvf);
            if (this.zzc.endsWith(".js")) {
                zzbuw.zzh(this.zzc);
            } else if (this.zzc.startsWith("<html>")) {
                zzbuw.zzf(this.zzc);
            } else {
                zzbuw.zzg(this.zzc);
            }
            zzt.zza.postDelayed(new zzbvh(this, zzbvs, zzbuw), 60000);
        } catch (Throwable th2) {
            zzciz.zzh("Error creating webview.", th2);
            com.google.android.gms.ads.internal.zzt.zzo().zzs(th2, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbvs.zzg();
        }
    }

    public final /* synthetic */ void zzj(zzbuo zzbuo) {
        if (zzbuo.zzi()) {
            this.zzh = 1;
        }
    }
}
