package com.google.android.gms.internal.gtm;

import java.util.List;

final class zzrx extends zzru {
    private zzrx() {
        super();
    }

    private static <E> zzrj<E> zzd(Object obj, long j11) {
        return (zzrj) zztx.zzp(obj, j11);
    }

    public final <L> List<L> zza(Object obj, long j11) {
        zzrj zzd = zzd(obj, j11);
        if (zzd.zzmy()) {
            return zzd;
        }
        int size = zzd.size();
        zzrj zzaj = zzd.zzaj(size == 0 ? 10 : size << 1);
        zztx.zza(obj, j11, (Object) zzaj);
        return zzaj;
    }

    public final void zzb(Object obj, long j11) {
        zzd(obj, j11).zzmi();
    }

    public final <E> void zza(Object obj, Object obj2, long j11) {
        zzrj zzd = zzd(obj, j11);
        zzrj zzd2 = zzd(obj2, j11);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzmy()) {
                zzd = zzd.zzaj(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zztx.zza(obj, j11, (Object) zzd2);
    }
}
