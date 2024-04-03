package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import javax.annotation.concurrent.GuardedBy;

public final class zzdal implements zzdgf, zzdfl {
    private final Context zza;
    @Nullable
    private final zzcop zzb;
    private final zzfdn zzc;
    private final zzcjf zzd;
    @GuardedBy("this")
    @Nullable
    private IObjectWrapper zze;
    @GuardedBy("this")
    private boolean zzf;

    public zzdal(Context context, @Nullable zzcop zzcop, zzfdn zzfdn, zzcjf zzcjf) {
        this.zza = context;
        this.zzb = zzcop;
        this.zzc = zzfdn;
        this.zzd = zzcjf;
    }

    private final synchronized void zza() {
        zzcbn zzcbn;
        zzcbo zzcbo;
        if (this.zzc.zzQ) {
            if (this.zzb != null) {
                if (zzt.zzh().zzi(this.zza)) {
                    zzcjf zzcjf = this.zzd;
                    int i11 = zzcjf.zzb;
                    int i12 = zzcjf.zzc;
                    StringBuilder sb2 = new StringBuilder(23);
                    sb2.append(i11);
                    sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                    sb2.append(i12);
                    String sb3 = sb2.toString();
                    String zza2 = this.zzc.zzS.zza();
                    if (this.zzc.zzS.zzb() == 1) {
                        zzcbn = zzcbn.zzc;
                        zzcbo = zzcbo.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzcbn = zzcbn.HTML_DISPLAY;
                        if (this.zzc.zzf == 1) {
                            zzcbo = zzcbo.ONE_PIXEL;
                        } else {
                            zzcbo = zzcbo.BEGIN_TO_RENDER;
                        }
                    }
                    IObjectWrapper zza3 = zzt.zzh().zza(sb3, this.zzb.zzI(), "", "javascript", zza2, zzcbo, zzcbn, this.zzc.zzaj);
                    this.zze = zza3;
                    zzcop zzcop = this.zzb;
                    if (zza3 != null) {
                        zzt.zzh().zzg(this.zze, (View) zzcop);
                        this.zzb.zzar(this.zze);
                        zzt.zzh().zzh(this.zze);
                        this.zzf = true;
                        this.zzb.zzd("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0008
            r3.zza()     // Catch:{ all -> 0x0024 }
        L_0x0008:
            com.google.android.gms.internal.ads.zzfdn r0 = r3.zzc     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.zzQ     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zze     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzcop r0 = r3.zzb     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)
            return
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdal.zzl():void");
    }

    public final synchronized void zzn() {
        if (!this.zzf) {
            zza();
        }
    }
}
