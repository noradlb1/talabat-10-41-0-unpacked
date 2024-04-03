package com.google.android.gms.internal.ads;

import java.util.List;

final class zzglh extends zzglj {
    private zzglh() {
        super((zzgli) null);
    }

    public /* synthetic */ zzglh(zzglg zzglg) {
        super((zzgli) null);
    }

    public final <L> List<L> zza(Object obj, long j11) {
        int i11;
        zzgku zzgku = (zzgku) zzgnp.zzh(obj, j11);
        if (zzgku.zzc()) {
            return zzgku;
        }
        int size = zzgku.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        zzgku zzd = zzgku.zzd(i11);
        zzgnp.zzv(obj, j11, zzd);
        return zzd;
    }

    public final void zzb(Object obj, long j11) {
        ((zzgku) zzgnp.zzh(obj, j11)).zzb();
    }

    public final <E> void zzc(Object obj, Object obj2, long j11) {
        zzgku zzgku = (zzgku) zzgnp.zzh(obj, j11);
        zzgku zzgku2 = (zzgku) zzgnp.zzh(obj2, j11);
        int size = zzgku.size();
        int size2 = zzgku2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgku.zzc()) {
                zzgku = zzgku.zzd(size2 + size);
            }
            zzgku.addAll(zzgku2);
        }
        if (size > 0) {
            zzgku2 = zzgku;
        }
        zzgnp.zzv(obj, j11, zzgku2);
    }
}
