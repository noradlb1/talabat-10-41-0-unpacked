package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

final class zzcka extends zzckc implements ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zza;

    public zzcka(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zza = new WeakReference<>(onGlobalLayoutListener);
    }

    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zza.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            zze();
        }
    }

    public final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    public final void zzb(ViewTreeObserver viewTreeObserver) {
        zzt.zzq();
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }
}
