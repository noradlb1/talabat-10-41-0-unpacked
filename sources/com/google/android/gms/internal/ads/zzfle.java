package com.google.android.gms.internal.ads;

import android.webkit.WebView;

final class zzfle implements Runnable {
    final /* synthetic */ zzflf zza;
    private final WebView zzb;

    public zzfle(zzflf zzflf) {
        this.zza = zzflf;
        this.zzb = zzflf.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
