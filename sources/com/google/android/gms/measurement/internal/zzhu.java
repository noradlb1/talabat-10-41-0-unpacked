package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

final class zzhu implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzik zzb;

    public zzhu(zzik zzik, Bundle bundle) {
        this.zzb = zzik;
        this.zza = bundle;
    }

    public final void run() {
        zzik zzik = this.zzb;
        Bundle bundle = this.zza;
        zzik.zzg();
        zzik.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzik.zzt.zzJ()) {
            zzik.zzt.zzaA().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzik.zzt.zzt().zzE(new zzac(bundle.getString("app_id"), "", new zzlk(checkNotEmpty, 0, (Object) null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzau) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzau) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzik.zzt.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
