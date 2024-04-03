package com.google.android.gms.ads.internal.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zzp extends AnimatorListenerAdapter {
    final /* synthetic */ zzr zza;

    public zzp(zzr zzr) {
        this.zza = zzr;
    }

    private final void zza(boolean z11) {
        this.zza.setClickable(z11);
        this.zza.zza.setClickable(z11);
    }

    public final void onAnimationCancel(Animator animator) {
        zza(true);
    }

    public final void onAnimationEnd(Animator animator) {
        zza(true);
    }

    public final void onAnimationStart(Animator animator) {
        zza(false);
    }
}
