package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

public final /* synthetic */ class zzbaq implements Runnable {
    public final /* synthetic */ zzcjr zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzbaq(zzcjr zzcjr, Future future) {
        this.zza = zzcjr;
        this.zzb = future;
    }

    public final void run() {
        zzcjr zzcjr = this.zza;
        Future future = this.zzb;
        if (zzcjr.isCancelled()) {
            future.cancel(true);
        }
    }
}
