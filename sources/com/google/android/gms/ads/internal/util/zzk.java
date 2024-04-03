package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfpj;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzk implements Callable {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzk(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzfpj zzfpj = zzt.zza;
        zzt.zzp();
        return zzt.zzS(uri);
    }
}
