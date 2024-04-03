package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public final class zzgqg extends CustomTabsServiceConnection {
    private final WeakReference<zzbmh> zza;

    public zzgqg(zzbmh zzbmh, byte[] bArr) {
        this.zza = new WeakReference<>(zzbmh);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbmh zzbmh = this.zza.get();
        if (zzbmh != null) {
            zzbmh.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbmh zzbmh = this.zza.get();
        if (zzbmh != null) {
            zzbmh.zzd();
        }
    }
}
