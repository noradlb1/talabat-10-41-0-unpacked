package com.google.android.recaptcha.internal;

final class zziw {
    private static final zziv zza;
    private static final zziv zzb = new zziv();

    static {
        zziv zziv;
        try {
            zziv = (zziv) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zziv = null;
        }
        zza = zziv;
    }

    public static zziv zza() {
        return zza;
    }

    public static zziv zzb() {
        return zzb;
    }
}
