package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class zzcwu implements zzder, zzdgf, zzdfl, zzbes, zzdfh {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzfdz zze;
    /* access modifiers changed from: private */
    public final zzfdn zzf;
    /* access modifiers changed from: private */
    public final zzfjp zzg;
    /* access modifiers changed from: private */
    public final zzfeo zzh;
    private final zzalt zzi;
    private final zzbmi zzj;
    private final WeakReference<View> zzk;
    @GuardedBy("this")
    private boolean zzl;
    private final AtomicBoolean zzm = new AtomicBoolean();
    private final zzbmk zzn;

    public zzcwu(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfdz zzfdz, zzfdn zzfdn, zzfjp zzfjp, zzfeo zzfeo, @Nullable View view, zzalt zzalt, zzbmi zzbmi, zzbmk zzbmk, byte[] bArr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfdz;
        this.zzf = zzfdn;
        this.zzg = zzfjp;
        this.zzh = zzfeo;
        this.zzi = zzalt;
        this.zzk = new WeakReference<>(view);
        this.zzj = zzbmi;
        this.zzn = zzbmk;
    }

    /* access modifiers changed from: private */
    public final void zzs() {
        String str;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzch)).booleanValue()) {
            str = this.zzi.zzc().zzh(this.zza, this.zzk.get(), (Activity) null);
        } else {
            str = null;
        }
        if ((!((Boolean) zzbgq.zzc().zzb(zzblj.zzai)).booleanValue() || !this.zze.zzb.zzb.zzg) && zzbmw.zzh.zze().booleanValue()) {
            zzfwq.zzr((zzfwh) zzfwq.zzo(zzfwh.zzw(zzfwq.zzi(null)), ((Long) zzbgq.zzc().zzb(zzblj.zzaJ)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcwt(this, str), this.zzb);
            return;
        }
        zzfeo zzfeo = this.zzh;
        zzfjp zzfjp = this.zzg;
        zzfdz zzfdz = this.zze;
        zzfdn zzfdn = this.zzf;
        zzfeo.zza(zzfjp.zzb(zzfdz, zzfdn, false, str, (String) null, zzfdn.zzd));
    }

    private final void zzt(int i11, int i12) {
        View view;
        if (i11 <= 0 || !((view = this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzs();
        } else {
            this.zzd.schedule(new zzcwr(this, i11, i12), (long) i12, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzbgq.zzc().zzb(zzblj.zzai)).booleanValue() || !this.zze.zzb.zzb.zzg) && zzbmw.zzd.zze().booleanValue()) {
            zzfwq.zzr(zzfwq.zzf(zzfwh.zzw(this.zzj.zza()), Throwable.class, zzcwn.zza, zzcjm.zzf), new zzcws(this), this.zzb);
            return;
        }
        zzfeo zzfeo = this.zzh;
        zzfjp zzfjp = this.zzg;
        zzfdz zzfdz = this.zze;
        zzfdn zzfdn = this.zzf;
        List<String> zza2 = zzfjp.zza(zzfdz, zzfdn, zzfdn.zzc);
        zzt.zzp();
        int i11 = 1;
        if (true == com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza)) {
            i11 = 2;
        }
        zzfeo.zzc(zza2, i11);
    }

    public final void zzbD() {
        zzfeo zzfeo = this.zzh;
        zzfjp zzfjp = this.zzg;
        zzfdz zzfdz = this.zze;
        zzfdn zzfdn = this.zzf;
        zzfeo.zza(zzfjp.zza(zzfdz, zzfdn, zzfdn.zzj));
    }

    public final /* synthetic */ void zzg() {
        this.zzb.execute(new zzcwp(this));
    }

    public final /* synthetic */ void zzh(int i11, int i12) {
        zzt(i11 - 1, i12);
    }

    public final /* synthetic */ void zzi(int i11, int i12) {
        this.zzb.execute(new zzcwq(this, i11, i12));
    }

    public final void zzj() {
    }

    public final void zzk(zzbew zzbew) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbf)).booleanValue()) {
            this.zzh.zza(this.zzg.zza(this.zze, this.zzf, zzfjp.zzd(2, zzbew.zza, this.zzf.zzp)));
        }
    }

    public final void zzl() {
        if (this.zzm.compareAndSet(false, true)) {
            int intValue = ((Integer) zzbgq.zzc().zzb(zzblj.zzck)).intValue();
            if (intValue > 0) {
                zzt(intValue, ((Integer) zzbgq.zzc().zzb(zzblj.zzcl)).intValue());
                return;
            }
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcj)).booleanValue()) {
                this.zzc.execute(new zzcwo(this));
            } else {
                zzs();
            }
        }
    }

    public final void zzm() {
    }

    public final synchronized void zzn() {
        if (this.zzl) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzb(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfeo zzfeo = this.zzh;
            zzfjp zzfjp = this.zzg;
            zzfdz zzfdz = this.zze;
            zzfdn zzfdn = this.zzf;
            zzfeo.zza(zzfjp.zza(zzfdz, zzfdn, zzfdn.zzn));
            zzfeo zzfeo2 = this.zzh;
            zzfjp zzfjp2 = this.zzg;
            zzfdz zzfdz2 = this.zze;
            zzfdn zzfdn2 = this.zzf;
            zzfeo2.zza(zzfjp2.zza(zzfdz2, zzfdn2, zzfdn2.zzg));
        }
        this.zzl = true;
    }

    public final void zzo() {
    }

    public final void zzp(zzceg zzceg, String str, String str2) {
        zzfeo zzfeo = this.zzh;
        zzfjp zzfjp = this.zzg;
        zzfdn zzfdn = this.zzf;
        zzfeo.zza(zzfjp.zzc(zzfdn, zzfdn.zzi, zzceg));
    }

    public final void zzr() {
        zzfeo zzfeo = this.zzh;
        zzfjp zzfjp = this.zzg;
        zzfdz zzfdz = this.zze;
        zzfdn zzfdn = this.zzf;
        zzfeo.zza(zzfjp.zza(zzfdz, zzfdn, zzfdn.zzh));
    }
}
