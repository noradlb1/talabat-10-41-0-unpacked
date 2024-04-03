package com.google.android.gms.internal.ads;

final class zzglr {
    private static final zzglq zza;
    private static final zzglq zzb = new zzglq();

    static {
        zzglq zzglq;
        try {
            zzglq = (zzglq) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzglq = null;
        }
        zza = zzglq;
    }

    public static zzglq zza() {
        return zza;
    }

    public static zzglq zzb() {
        return zzb;
    }
}
