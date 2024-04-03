package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

final class zzalv extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzalw zza;

    public zzalv(zzalw zzalw) {
        this.zza = zzalw;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzalw.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzalw.class) {
            this.zza.zza = null;
        }
    }
}
