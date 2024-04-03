package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

final class zzjb {
    @Nullable
    private final PowerManager zza;

    public zzjb(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
