package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

final class zzckb extends zzckc implements ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zza;

    public zzckb(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.zza = new WeakReference<>(onScrollChangedListener);
    }

    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zza.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            zze();
        }
    }

    public final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    public final void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
