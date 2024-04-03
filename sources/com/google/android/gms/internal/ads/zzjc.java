package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

final class zzjc {
    @Nullable
    private final WifiManager zza;

    public zzjc(Context context) {
        this.zza = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }
}
