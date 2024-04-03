package com.google.android.gms.internal.icing;

final class zzek {
    private static final zzej zza;
    private static final zzej zzb = new zzej();

    static {
        zzej zzej;
        try {
            zzej = (zzej) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzej = null;
        }
        zza = zzej;
    }

    public static zzej zza() {
        return zza;
    }

    public static zzej zzb() {
        return zzb;
    }
}
