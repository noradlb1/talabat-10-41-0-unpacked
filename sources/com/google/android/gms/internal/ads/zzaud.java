package com.google.android.gms.internal.ads;

final class zzaud implements Runnable {
    final /* synthetic */ zzaug zza;
    final /* synthetic */ zzaui zzb;

    public zzaud(zzaui zzaui, zzaug zzaug) {
        this.zzb = zzaui;
        this.zza = zzaug;
    }

    public final void run() {
        this.zza.zza();
        int size = this.zzb.zzn.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((zzaux) this.zzb.zzn.valueAt(i11)).zzi();
        }
    }
}
