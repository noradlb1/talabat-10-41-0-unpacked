package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzq implements Callable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ IObjectWrapper zzc;

    public /* synthetic */ zzq(zzv zzv, List list, IObjectWrapper iObjectWrapper) {
        this.zza = zzv;
        this.zzb = list;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzv(this.zzb, this.zzc);
    }
}
