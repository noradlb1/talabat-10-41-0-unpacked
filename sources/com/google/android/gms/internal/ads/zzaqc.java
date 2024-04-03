package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzaqc {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzaqd zzb;

    public zzaqc(Handler handler, zzaqd zzaqd) {
        handler.getClass();
        this.zza = handler;
        this.zzb = zzaqd;
    }

    public final void zzb(int i11) {
        this.zza.post(new zzaqb(this, i11));
    }

    public final void zzc(int i11, long j11, long j12) {
        this.zza.post(new zzapz(this, i11, j11, j12));
    }

    public final void zzd(String str, long j11, long j12) {
        this.zza.post(new zzapx(this, str, j11, j12));
    }

    public final void zze(zzara zzara) {
        this.zza.post(new zzaqa(this, zzara));
    }

    public final void zzf(zzara zzara) {
        this.zza.post(new zzapw(this, zzara));
    }

    public final void zzg(zzapg zzapg) {
        this.zza.post(new zzapy(this, zzapg));
    }
}
