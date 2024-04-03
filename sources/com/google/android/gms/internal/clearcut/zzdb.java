package com.google.android.gms.internal.clearcut;

final class zzdb extends zzcy {
    private zzdb() {
        super();
    }

    private static <E> zzcn<E> zzc(Object obj, long j11) {
        return (zzcn) zzfd.zzo(obj, j11);
    }

    public final void zza(Object obj, long j11) {
        zzc(obj, j11).zzv();
    }

    public final <E> void zza(Object obj, Object obj2, long j11) {
        zzcn zzc = zzc(obj, j11);
        zzcn zzc2 = zzc(obj2, j11);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzu()) {
                zzc = zzc.zzi(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzfd.zza(obj, j11, (Object) zzc2);
    }
}
