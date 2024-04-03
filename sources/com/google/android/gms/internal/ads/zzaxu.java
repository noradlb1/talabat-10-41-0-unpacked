package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

public final class zzaxu {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzaxv zzb;

    public zzaxu(Handler handler, zzaxv zzaxv) {
        handler.getClass();
        this.zza = handler;
        this.zzb = zzaxv;
    }

    public final void zzb(String str, long j11, long j12) {
        this.zza.post(new zzaxo(this, str, j11, j12));
    }

    public final void zzc(zzara zzara) {
        this.zza.post(new zzaxt(this, zzara));
    }

    public final void zzd(int i11, long j11) {
        this.zza.post(new zzaxq(this, i11, j11));
    }

    public final void zze(zzara zzara) {
        this.zza.post(new zzaxn(this, zzara));
    }

    public final void zzf(zzapg zzapg) {
        this.zza.post(new zzaxp(this, zzapg));
    }

    public final void zzg(Surface surface) {
        this.zza.post(new zzaxs(this, surface));
    }

    public final void zzh(int i11, int i12, int i13, float f11) {
        this.zza.post(new zzaxr(this, i11, i12, i13, f11));
    }
}
