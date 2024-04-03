package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalt;
import java.util.concurrent.Callable;

final class zzo implements Callable<zzalt> {
    final /* synthetic */ zzs zza;

    public zzo(zzs zzs) {
        this.zza = zzs;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return new zzalt(zzals.zzs(this.zza.zza.zza, this.zza.zzd, false));
    }
}
