package com.google.android.gms.internal.ads;

final class zzgmb {
    private static final zzgma zza;
    private static final zzgma zzb = new zzgma();

    static {
        zzgma zzgma;
        try {
            zzgma = (zzgma) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgma = null;
        }
        zza = zzgma;
    }

    public static zzgma zza() {
        return zza;
    }

    public static zzgma zzb() {
        return zzb;
    }
}
