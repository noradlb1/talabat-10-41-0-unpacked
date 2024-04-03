package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzdhf implements Runnable {
    private final WeakReference<zzdhg> zza;

    public /* synthetic */ zzdhf(zzdhg zzdhg, zzdhe zzdhe) {
        this.zza = new WeakReference<>(zzdhg);
    }

    public final void run() {
        zzdhg zzdhg = this.zza.get();
        if (zzdhg != null) {
            zzdhg.zzo(zzdhd.zza);
        }
    }
}
