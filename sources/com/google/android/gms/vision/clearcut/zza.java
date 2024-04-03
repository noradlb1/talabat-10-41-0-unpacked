package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzea;

final class zza implements Runnable {
    private final /* synthetic */ int zzbq;
    private final /* synthetic */ zzea.zzo zzbr;
    private final /* synthetic */ DynamiteClearcutLogger zzbs;

    public zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i11, zzea.zzo zzo) {
        this.zzbs = dynamiteClearcutLogger;
        this.zzbq = i11;
        this.zzbr = zzo;
    }

    public final void run() {
        this.zzbs.zzbp.zzb(this.zzbq, this.zzbr);
    }
}
