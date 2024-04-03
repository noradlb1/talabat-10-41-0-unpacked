package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzp implements Callable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ IObjectWrapper zzc;

    public /* synthetic */ zzp(zzv zzv, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zza = zzv;
        this.zzb = uri;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzk(this.zzb, this.zzc);
    }
}
