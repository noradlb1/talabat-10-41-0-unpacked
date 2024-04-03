package com.google.android.recaptcha.internal;

import java.util.List;

final class zzib extends zzid {
    private zzib() {
        super((zzic) null);
    }

    public /* synthetic */ zzib(zzia zzia) {
        super((zzic) null);
    }

    public final List zza(Object obj, long j11) {
        int i11;
        zzhm zzhm = (zzhm) zzkg.zzf(obj, j11);
        if (zzhm.zzc()) {
            return zzhm;
        }
        int size = zzhm.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        zzhm zzd = zzhm.zzd(i11);
        zzkg.zzs(obj, j11, zzd);
        return zzd;
    }

    public final void zzb(Object obj, long j11) {
        ((zzhm) zzkg.zzf(obj, j11)).zzb();
    }

    public final void zzc(Object obj, Object obj2, long j11) {
        zzhm zzhm = (zzhm) zzkg.zzf(obj, j11);
        zzhm zzhm2 = (zzhm) zzkg.zzf(obj2, j11);
        int size = zzhm.size();
        int size2 = zzhm2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhm.zzc()) {
                zzhm = zzhm.zzd(size2 + size);
            }
            zzhm.addAll(zzhm2);
        }
        if (size > 0) {
            zzhm2 = zzhm;
        }
        zzkg.zzs(obj, j11, zzhm2);
    }
}
