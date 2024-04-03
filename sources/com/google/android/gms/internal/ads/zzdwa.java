package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class zzdwa implements View.OnTouchListener {
    public final /* synthetic */ zzdwi zza;

    public /* synthetic */ zzdwa(zzdwi zzdwi) {
        this.zza = zzdwi;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
