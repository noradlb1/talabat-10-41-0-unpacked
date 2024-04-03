package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
public class zzx extends zzw {
    public final boolean zzi(View view) {
        return view.isAttachedToWindow();
    }

    public final ViewGroup.LayoutParams zzj() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
