package com.google.android.libraries.places.internal;

final class zzacl extends zzacn {
    private zzacl() {
        super((zzacm) null);
    }

    public /* synthetic */ zzacl(zzack zzack) {
        super((zzacm) null);
    }

    public final void zza(Object obj, long j11) {
        ((zzabz) zzael.zzf(obj, j11)).zzb();
    }

    public final <E> void zzb(Object obj, Object obj2, long j11) {
        zzabz zzabz = (zzabz) zzael.zzf(obj, j11);
        zzabz zzabz2 = (zzabz) zzael.zzf(obj2, j11);
        int size = zzabz.size();
        int size2 = zzabz2.size();
        if (size > 0 && size2 > 0) {
            if (!zzabz.zzc()) {
                zzabz = zzabz.zzf(size2 + size);
            }
            zzabz.addAll(zzabz2);
        }
        if (size > 0) {
            zzabz2 = zzabz;
        }
        zzael.zzs(obj, j11, zzabz2);
    }
}
