package com.google.android.gms.internal.vision;

import java.util.List;

final class zzhn extends zzhm {
    private zzhn() {
        super();
    }

    private static <E> zzgz<E> zzc(Object obj, long j11) {
        return (zzgz) zzjp.zzp(obj, j11);
    }

    public final <L> List<L> zza(Object obj, long j11) {
        zzgz zzc = zzc(obj, j11);
        if (zzc.zzdo()) {
            return zzc;
        }
        int size = zzc.size();
        zzgz zzag = zzc.zzag(size == 0 ? 10 : size << 1);
        zzjp.zza(obj, j11, (Object) zzag);
        return zzag;
    }

    public final void zzb(Object obj, long j11) {
        zzc(obj, j11).zzdp();
    }

    public final <E> void zza(Object obj, Object obj2, long j11) {
        zzgz zzc = zzc(obj, j11);
        zzgz zzc2 = zzc(obj2, j11);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzdo()) {
                zzc = zzc.zzag(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzjp.zza(obj, j11, (Object) zzc2);
    }
}
