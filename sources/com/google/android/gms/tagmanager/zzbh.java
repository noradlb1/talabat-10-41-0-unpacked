package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzbh implements AppMeasurement.EventInterceptor {
    private final /* synthetic */ zzcj zzagq;

    public zzbh(zzbg zzbg, zzcj zzcj) {
        this.zzagq = zzcj;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j11) {
        try {
            this.zzagq.interceptEvent(str, str2, bundle, j11);
        } catch (RemoteException e11) {
            throw new IllegalStateException(e11);
        }
    }
}
