package com.google.android.gms.ads.internal.util;

import android.net.ConnectivityManager;
import android.net.Network;

final class zzo extends ConnectivityManager.NetworkCallback {
    public zzo(zzt zzt) {
    }

    public final void onAvailable(Network network) {
        synchronized (zzt.class) {
            zzt.zzb = true;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzt.class) {
            zzt.zzb = false;
        }
    }
}
