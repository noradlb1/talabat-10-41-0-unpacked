package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzfde extends zzcey {
    private final zzfda zza;
    private final zzfcq zzb;
    private final String zzc;
    private final zzfea zzd;
    private final Context zze;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzdvn zzf;
    @GuardedBy("this")
    private boolean zzg = ((Boolean) zzbgq.zzc().zzb(zzblj.zzaw)).booleanValue();

    public zzfde(@Nullable String str, zzfda zzfda, Context context, zzfcq zzfcq, zzfea zzfea) {
        this.zzc = str;
        this.zza = zzfda;
        this.zzb = zzfcq;
        this.zzd = zzfea;
        this.zze = context;
    }

    private final synchronized void zzt(zzbfd zzbfd, zzcfg zzcfg, int i11) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zze(zzcfg);
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzL(this.zze)) {
            if (zzbfd.zzs == null) {
                zzciz.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zza(zzfey.zzd(4, (String) null, (zzbew) null));
                return;
            }
        }
        if (this.zzf == null) {
            zzfcs zzfcs = new zzfcs((String) null);
            this.zza.zzj(i11);
            this.zza.zzb(zzbfd, this.zzc, zzfcs, new zzfdd(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvn zzdvn = this.zzf;
        if (zzdvn != null) {
            return zzdvn.zza();
        }
        return new Bundle();
    }

    public final zzbiw zzc() {
        zzdvn zzdvn;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfi)).booleanValue() && (zzdvn = this.zzf) != null) {
            return zzdvn.zzl();
        }
        return null;
    }

    @Nullable
    public final zzcew zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvn zzdvn = this.zzf;
        if (zzdvn != null) {
            return zzdvn.zzc();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() throws android.os.RemoteException {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdvn r0 = r1.zzf     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdvn r0 = r1.zzf     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            java.lang.String r0 = r0.zze()     // Catch:{ all -> 0x001a }
            monitor-exit(r1)
            return r0
        L_0x0017:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x001a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfde.zze():java.lang.String");
    }

    public final synchronized void zzf(zzbfd zzbfd, zzcfg zzcfg) throws RemoteException {
        zzt(zzbfd, zzcfg, 2);
    }

    public final synchronized void zzg(zzbfd zzbfd, zzcfg zzcfg) throws RemoteException {
        zzt(zzbfd, zzcfg, 3);
    }

    public final synchronized void zzh(boolean z11) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzg = z11;
    }

    public final void zzi(zzbiq zzbiq) {
        if (zzbiq == null) {
            this.zzb.zzb((zzfmb) null);
        } else {
            this.zzb.zzb(new zzfdc(this, zzbiq));
        }
    }

    public final void zzj(zzbit zzbit) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzb.zzc(zzbit);
    }

    public final void zzk(zzcfc zzcfc) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzd(zzcfc);
    }

    public final synchronized void zzl(zzcfn zzcfn) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfea zzfea = this.zzd;
        zzfea.zza = zzcfn.zza;
        zzfea.zzb = zzcfn.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzg);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z11) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzf == null) {
            zzciz.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzk(zzfey.zzd(9, (String) null, (zzbew) null));
            return;
        }
        this.zzf.zzg(z11, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvn zzdvn = this.zzf;
        if (zzdvn == null || zzdvn.zze()) {
            return false;
        }
        return true;
    }

    public final void zzp(zzcfh zzcfh) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzi(zzcfh);
    }
}
