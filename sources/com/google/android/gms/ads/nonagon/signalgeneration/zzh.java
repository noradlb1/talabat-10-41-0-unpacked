package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzfpv;

public final /* synthetic */ class zzh implements zzfpv {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ Uri zzb;

    public /* synthetic */ zzh(zzv zzv, Uri uri) {
        this.zza = zzv;
        this.zzb = uri;
    }

    public final Object apply(Object obj) {
        return zzv.zzF(this.zzb, (String) obj);
    }
}
