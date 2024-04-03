package com.google.android.gms.internal.ads;

import android.view.View;

final class zzcot implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcgf zza;
    final /* synthetic */ zzcow zzb;

    public zzcot(zzcow zzcow, zzcgf zzcgf) {
        this.zzb = zzcow;
        this.zza = zzcgf;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzQ(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
