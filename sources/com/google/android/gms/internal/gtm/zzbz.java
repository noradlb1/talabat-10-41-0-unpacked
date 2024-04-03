package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
public final class zzbz<V> {
    private final V zzaar;
    private final GservicesValue<V> zzaas;

    private zzbz(GservicesValue<V> gservicesValue, V v11) {
        Preconditions.checkNotNull(gservicesValue);
        this.zzaas = gservicesValue;
        this.zzaar = v11;
    }

    public static zzbz<Boolean> zza(String str, boolean z11, boolean z12) {
        return new zzbz<>(GservicesValue.value(str, z12), Boolean.valueOf(z11));
    }

    public final V get() {
        return this.zzaar;
    }

    public static zzbz<String> zza(String str, String str2, String str3) {
        return new zzbz<>(GservicesValue.value(str, str3), str2);
    }

    public static zzbz<Long> zza(String str, long j11, long j12) {
        return new zzbz<>(GservicesValue.value(str, Long.valueOf(j12)), Long.valueOf(j11));
    }

    public static zzbz<Integer> zza(String str, int i11, int i12) {
        return new zzbz<>(GservicesValue.value(str, Integer.valueOf(i12)), Integer.valueOf(i11));
    }

    public static zzbz<Float> zza(String str, float f11, float f12) {
        Float valueOf = Float.valueOf(0.5f);
        return new zzbz<>(GservicesValue.value(str, valueOf), valueOf);
    }
}
