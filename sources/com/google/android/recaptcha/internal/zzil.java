package com.google.android.recaptcha.internal;

final class zzil {
    private static final zzik zza;
    private static final zzik zzb = new zzik();

    static {
        zzik zzik;
        try {
            zzik = (zzik) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzik = null;
        }
        zza = zzik;
    }

    public static zzik zza() {
        return zza;
    }

    public static zzik zzb() {
        return zzb;
    }
}
