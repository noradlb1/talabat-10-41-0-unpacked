package com.google.android.gms.internal.places;

final class zzbv extends zzbu {
    private zzbv() {
        super();
    }

    private static <E> zzbh<E> zzc(Object obj, long j11) {
        return (zzbh) zzdy.zzp(obj, j11);
    }

    public final void zzb(Object obj, long j11) {
        zzc(obj, j11).zzab();
    }

    public final <E> void zzb(Object obj, Object obj2, long j11) {
        zzbh zzc = zzc(obj, j11);
        zzbh zzc2 = zzc(obj2, j11);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzaa()) {
                zzc = zzc.zzh(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzdy.zzb(obj, j11, (Object) zzc2);
    }
}
