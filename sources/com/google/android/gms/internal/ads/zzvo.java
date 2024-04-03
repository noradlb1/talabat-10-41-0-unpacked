package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

public final class zzvo {
    @Nullable
    private final Handler zza;
    @Nullable
    private final zzvp zzb;

    public zzvo(@Nullable Handler handler, @Nullable zzvp zzvp) {
        this.zza = zzvp == null ? null : handler;
        this.zzb = zzvp;
    }

    public final void zza(String str, long j11, long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvn(this, str, j11, j12));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvm(this, str));
        }
    }

    public final void zzc(zzfy zzfy) {
        zzfy.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvi(this, zzfy));
        }
    }

    public final void zzd(int i11, long j11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzve(this, i11, j11));
        }
    }

    public final void zze(zzfy zzfy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvj(this, zzfy));
        }
    }

    public final void zzf(zzab zzab, @Nullable zzfz zzfz) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvg(this, zzab, zzfz));
        }
    }

    public final /* synthetic */ void zzg(String str, long j11, long j12) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzG(str, j11, j12);
    }

    public final /* synthetic */ void zzh(String str) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzH(str);
    }

    public final /* synthetic */ void zzi(zzfy zzfy) {
        zzfy.zza();
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzI(zzfy);
    }

    public final /* synthetic */ void zzj(int i11, long j11) {
        zzvp zzvp = this.zzb;
        int i12 = zzfn.zza;
        zzvp.zzD(i11, j11);
    }

    public final /* synthetic */ void zzk(zzfy zzfy) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzJ(zzfy);
    }

    public final /* synthetic */ void zzl(zzab zzab, zzfz zzfz) {
        int i11 = zzfn.zza;
        this.zzb.zzL(zzab, zzfz);
    }

    public final /* synthetic */ void zzm(Object obj, long j11) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzE(obj, j11);
    }

    public final /* synthetic */ void zzn(long j11, int i11) {
        zzvp zzvp = this.zzb;
        int i12 = zzfn.zza;
        zzvp.zzK(j11, i11);
    }

    public final /* synthetic */ void zzo(Exception exc) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzF(exc);
    }

    public final /* synthetic */ void zzp(zzct zzct) {
        zzvp zzvp = this.zzb;
        int i11 = zzfn.zza;
        zzvp.zzv(zzct);
    }

    public final void zzq(Object obj) {
        if (this.zza != null) {
            this.zza.post(new zzvl(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j11, int i11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvf(this, j11, i11));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvk(this, exc));
        }
    }

    public final void zzt(zzct zzct) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzvh(this, zzct));
        }
    }
}
