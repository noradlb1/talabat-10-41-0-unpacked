package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzbi implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzcg zzagr;

    public zzbi(zzbg zzbg, zzcg zzcg) {
        this.zzagr = zzcg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        try {
            this.zzagr.onEvent(str, str2, bundle, j11);
        } catch (RemoteException e11) {
            throw new IllegalStateException(e11);
        }
    }
}
