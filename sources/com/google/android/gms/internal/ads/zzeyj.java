package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class zzeyj extends zzbhj implements zzaa, zzazn, zzdgq {
    @GuardedBy("this")
    @Nullable
    protected zzcyf zza;
    private final zzcqm zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final ViewGroup zzd;
    private AtomicBoolean zze = new AtomicBoolean();
    private final String zzf;
    private final zzeyd zzg;
    /* access modifiers changed from: private */
    public final zzezj zzh;
    /* access modifiers changed from: private */
    public final zzcjf zzi;
    private long zzj = -1;
    @Nullable
    private zzcxr zzk;

    public zzeyj(zzcqm zzcqm, Context context, String str, zzeyd zzeyd, zzezj zzezj, zzcjf zzcjf) {
        this.zzd = new FrameLayout(context);
        this.zzb = zzcqm;
        this.zzc = context;
        this.zzf = str;
        this.zzg = zzeyd;
        this.zzh = zzezj;
        zzezj.zzn(this);
        this.zzi = zzcjf;
    }

    public static /* bridge */ /* synthetic */ zzr zze(zzeyj zzeyj, zzcyf zzcyf) {
        int i11;
        boolean zzh2 = zzcyf.zzh();
        int intValue = ((Integer) zzbgq.zzc().zzb(zzblj.zzdu)).intValue();
        zzq zzq = new zzq();
        zzq.zzd = 50;
        int i12 = 0;
        if (true != zzh2) {
            i11 = 0;
        } else {
            i11 = intValue;
        }
        zzq.zza = i11;
        if (true != zzh2) {
            i12 = intValue;
        }
        zzq.zzb = i12;
        zzq.zzc = intValue;
        return new zzr(zzeyj.zzc, zzq, zzeyj);
    }

    private final synchronized void zzq(int i11) {
        if (this.zze.compareAndSet(false, true)) {
            zzcyf zzcyf = this.zza;
            if (!(zzcyf == null || zzcyf.zzj() == null)) {
                this.zzh.zzt(this.zza.zzj());
            }
            this.zzh.zzj();
            this.zzd.removeAllViews();
            zzcxr zzcxr = this.zzk;
            if (zzcxr != null) {
                zzt.zzb().zze(zzcxr);
            }
            if (this.zza != null) {
                long j11 = -1;
                if (this.zzj != -1) {
                    j11 = zzt.zzA().elapsedRealtime() - this.zzj;
                }
                this.zza.zzi(j11, i11);
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
        this.zzh.zzr(zzazw);
    }

    public final void zzI(zzbfo zzbfo) {
        this.zzg.zzl(zzbfo);
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

    public final void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzg.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final void zza() {
        zzq(3);
    }

    public final synchronized boolean zzaa(zzbfd zzbfd) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzL(this.zzc)) {
            if (zzbfd.zzs == null) {
                zzciz.zzg("Failed to load the ad because app ID is missing.");
                this.zzh.zza(zzfey.zzd(4, (String) null, (zzbew) null));
                return false;
            }
        }
        if (zzY()) {
            return false;
        }
        this.zze = new AtomicBoolean();
        return this.zzg.zzb(zzbfd, this.zzf, new zzeyh(this), new zzeyi(this));
    }

    public final synchronized void zzab(zzbhv zzbhv) {
    }

    public final void zzbR() {
        zzq(4);
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final synchronized zzbfi zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcyf zzcyf = this.zza;
        if (zzcyf == null) {
            return null;
        }
        return zzfej.zza(this.zzc, Collections.singletonList(zzcyf.zzc()));
    }

    public final void zzh() {
        if (this.zza != null) {
            this.zzj = zzt.zzA().elapsedRealtime();
            int zza2 = this.zza.zza();
            if (zza2 > 0) {
                zzcxr zzcxr = new zzcxr(this.zzb.zzD(), zzt.zzA());
                this.zzk = zzcxr;
                zzcxr.zzd(zza2, new zzeyg(this));
            }
        }
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

    public final IObjectWrapper zzn() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzd);
    }

    public final /* synthetic */ void zzo() {
        zzq(5);
    }

    @VisibleForTesting
    public final void zzp() {
        zzbgo.zzb();
        if (zzcis.zzp()) {
            zzq(5);
        } else {
            this.zzb.zzC().execute(new zzeyf(this));
        }
    }

    public final synchronized String zzr() {
        return this.zzf;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcyf zzcyf = this.zza;
        if (zzcyf != null) {
            zzcyf.zzT();
        }
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
