package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class zzezr extends zzbhj implements zzo, zzazn {
    @GuardedBy("this")
    @Nullable
    protected zzcyp zza;
    private final zzcqm zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzezl zzf;
    /* access modifiers changed from: private */
    public final zzezj zzg;
    @GuardedBy("this")
    private long zzh = -1;
    @GuardedBy("this")
    @Nullable
    private zzcxr zzi;

    public zzezr(zzcqm zzcqm, Context context, String str, zzezl zzezl, zzezj zzezj) {
        this.zzb = zzcqm;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzezl;
        this.zzg = zzezj;
        zzezj.zzo(this);
    }

    private final synchronized void zzp(int i11) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzj();
            zzcxr zzcxr = this.zzi;
            if (zzcxr != null) {
                zzt.zzb().zze(zzcxr);
            }
            if (this.zza != null) {
                long j11 = -1;
                if (this.zzh != -1) {
                    j11 = zzt.zzA().elapsedRealtime() - this.zzh;
                }
                this.zza.zze(j11, i11);
            }
            zzx();
        }
    }

    public final synchronized void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbgu zzbgu) {
    }

    public final void zzD(zzbgx zzbgx) {
    }

    public final void zzE(zzbho zzbho) {
    }

    public final synchronized void zzF(zzbfi zzbfi) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzG(zzbhr zzbhr) {
    }

    public final void zzH(zzazw zzazw) {
        this.zzg.zzr(zzazw);
    }

    public final void zzI(zzbfo zzbfo) {
        this.zzf.zzl(zzbfo);
    }

    public final void zzJ(zzbhy zzbhy) {
    }

    public final void zzK(zzbjd zzbjd) {
    }

    public final void zzL(boolean z11) {
    }

    public final void zzM(zzccb zzccb) {
    }

    public final synchronized void zzN(boolean z11) {
    }

    public final synchronized void zzO(zzbme zzbme) {
    }

    public final void zzP(zzbit zzbit) {
    }

    public final void zzQ(zzcce zzcce, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzcem zzcem) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzbkq zzbkq) {
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final synchronized void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzf.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final void zza() {
        zzp(3);
    }

    public final synchronized boolean zzaa(zzbfd zzbfd) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzL(this.zzc)) {
            if (zzbfd.zzs == null) {
                zzciz.zzg("Failed to load the ad because app ID is missing.");
                this.zzg.zza(zzfey.zzd(4, (String) null, (zzbew) null));
                return false;
            }
        }
        if (zzY()) {
            return false;
        }
        this.zzd = new AtomicBoolean();
        return this.zzf.zzb(zzbfd, this.zze, new zzezp(this), new zzezq(this));
    }

    public final synchronized void zzab(zzbhv zzbhv) {
    }

    public final synchronized void zzb() {
        if (this.zza != null) {
            this.zzh = zzt.zzA().elapsedRealtime();
            int zza2 = this.zza.zza();
            if (zza2 > 0) {
                zzcxr zzcxr = new zzcxr(this.zzb.zzD(), zzt.zzA());
                this.zzi = zzcxr;
                zzcxr.zzd(zza2, new zzezo(this));
            }
        }
    }

    public final void zzbK() {
    }

    public final void zzbS() {
    }

    public final void zzbz() {
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final synchronized void zze() {
        zzcyp zzcyp = this.zza;
        if (zzcyp != null) {
            zzcyp.zze(zzt.zzA().elapsedRealtime() - this.zzh, 1);
        }
    }

    public final void zzf(int i11) {
        int i12 = i11 - 1;
        if (i11 == 0) {
            throw null;
        } else if (i12 == 0) {
            zzp(2);
        } else if (i12 == 1) {
            zzp(4);
        } else if (i12 == 2) {
            zzp(3);
        } else if (i12 == 3) {
            zzp(6);
        }
    }

    public final synchronized zzbfi zzg() {
        return null;
    }

    public final zzbgx zzi() {
        return null;
    }

    public final zzbhr zzj() {
        return null;
    }

    public final synchronized zzbiw zzk() {
        return null;
    }

    public final synchronized zzbiz zzl() {
        return null;
    }

    public final /* synthetic */ void zzm() {
        zzp(5);
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    @VisibleForTesting
    public final void zzo() {
        this.zzb.zzC().execute(new zzezn(this));
    }

    public final synchronized String zzr() {
        return this.zze;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcyp zzcyp = this.zza;
        if (zzcyp != null) {
            zzcyp.zzT();
        }
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
