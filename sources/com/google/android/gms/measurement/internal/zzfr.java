package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

final class zzfr extends LruCache {
    final /* synthetic */ zzfu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfr(zzfu zzfu, int i11) {
        super(20);
        this.zza = zzfu;
    }

    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfu.zzd(this.zza, str);
    }
}
