package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzn implements View.OnTouchListener {
    final /* synthetic */ zzs zza;

    public zzn(zzs zzs) {
        this.zza = zzs;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zza.zzh == null) {
            return false;
        }
        this.zza.zzh.zzd(motionEvent);
        return false;
    }
}
