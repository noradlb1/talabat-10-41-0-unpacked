package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzfse extends zzfsh {
    public zzfse() {
        super((zzfsg) null);
    }

    public static final zzfsh zzf(int i11) {
        return i11 < 0 ? zzfsh.zzb : i11 > 0 ? zzfsh.zzc : zzfsh.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfsh zzb(int i11, int i12) {
        return zzf(i11 < i12 ? -1 : i11 > i12 ? 1 : 0);
    }

    public final <T> zzfsh zzc(T t11, T t12, Comparator<T> comparator) {
        return zzf(comparator.compare(t11, t12));
    }

    public final zzfsh zzd(boolean z11, boolean z12) {
        return zzf(zzfuz.zza(z11, z12));
    }

    public final zzfsh zze(boolean z11, boolean z12) {
        return zzf(zzfuz.zza(false, false));
    }
}
