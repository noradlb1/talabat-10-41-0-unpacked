package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.Nullable;

public final class zzls {
    @Nullable
    private final Handler zza;
    @Nullable
    private final zzlt zzb;

    public zzls(@Nullable Handler handler, @Nullable zzlt zzlt) {
        this.zza = zzlt == null ? null : handler;
        this.zzb = zzlt;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzln(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlo(this, exc));
        }
    }

    public final void zzc(String str, long j11, long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlq(this, str, j11, j12));
        }
    }

    public final void zzd(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlp(this, str));
        }
    }

    public final void zze(zzfy zzfy) {
        zzfy.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzll(this, zzfy));
        }
    }

    public final void zzf(zzfy zzfy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlm(this, zzfy));
        }
    }

    public final void zzg(zzab zzab, @Nullable zzfz zzfz) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlk(this, zzab, zzfz));
        }
    }

    public final /* synthetic */ void zzh(Exception exc) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzs(exc);
    }

    public final /* synthetic */ void zzi(Exception exc) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzB(exc);
    }

    public final /* synthetic */ void zzj(String str, long j11, long j12) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzu(str, j11, j12);
    }

    public final /* synthetic */ void zzk(String str) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzw(str);
    }

    public final /* synthetic */ void zzl(zzfy zzfy) {
        zzfy.zza();
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzx(zzfy);
    }

    public final /* synthetic */ void zzm(zzfy zzfy) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzy(zzfy);
    }

    public final /* synthetic */ void zzn(zzab zzab, zzfz zzfz) {
        int i11 = zzfn.zza;
        this.zzb.zzz(zzab, zzfz);
    }

    public final /* synthetic */ void zzo(long j11) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzA(j11);
    }

    public final /* synthetic */ void zzp(boolean z11) {
        zzlt zzlt = this.zzb;
        int i11 = zzfn.zza;
        zzlt.zzt(z11);
    }

    public final /* synthetic */ void zzq(int i11, long j11, long j12) {
        zzlt zzlt = this.zzb;
        int i12 = zzfn.zza;
        zzlt.zzC(i11, j11, j12);
    }

    public final void zzr(long j11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlj(this, j11));
        }
    }

    public final void zzs(boolean z11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzlr(this, z11));
        }
    }

    public final void zzt(int i11, long j11, long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzli(this, i11, j11, j12));
        }
    }
}
