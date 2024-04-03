package com.google.android.libraries.places.internal;

final class zzadf {
    private static final zzade zza;
    private static final zzade zzb = new zzade();

    static {
        zzade zzade;
        try {
            zzade = (zzade) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzade = null;
        }
        zza = zzade;
    }

    public static zzade zza() {
        return zza;
    }

    public static zzade zzb() {
        return zzb;
    }
}
