package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;

public final /* synthetic */ class zzcpd implements Runnable {
    public final /* synthetic */ IObjectWrapper zza;

    public /* synthetic */ zzcpd(IObjectWrapper iObjectWrapper) {
        this.zza = iObjectWrapper;
    }

    public final void run() {
        zzt.zzh().zze(this.zza);
    }
}
