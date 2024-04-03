package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

public final class zzgks<F, T> extends AbstractList<T> {
    private final List<F> zza;
    private final zzgkr<F, T> zzb;

    public zzgks(List<F> list, zzgkr<F, T> zzgkr) {
        this.zza = list;
        this.zzb = zzgkr;
    }

    public final T get(int i11) {
        T zzb2 = zzbbu.zzb(((Integer) this.zza.get(i11)).intValue());
        if (zzb2 == null) {
            return zzbbu.AD_FORMAT_TYPE_UNSPECIFIED;
        }
        return zzb2;
    }

    public final int size() {
        return this.zza.size();
    }
}
