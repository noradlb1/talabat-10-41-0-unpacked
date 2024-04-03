package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public final /* synthetic */ class zzbwz implements Runnable {
    public final /* synthetic */ zzbxa zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbwz(zzbxa zzbxa, Context context, String str) {
        this.zza = zzbxa;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        String str = this.zzc;
        zzblj.zzc(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzbgq.zzc().zzb(zzblj.zzac)).booleanValue());
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaj)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzcqj) zzcjd.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzbwy.zza)).zze(ObjectWrapper.wrap(context), new zzbwx(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
