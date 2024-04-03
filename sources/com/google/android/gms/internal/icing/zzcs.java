package com.google.android.gms.internal.icing;

final class zzcs {
    private static final zzcq<?> zza = new zzcr();
    private static final zzcq<?> zzb;

    static {
        zzcq<?> zzcq;
        try {
            zzcq = (zzcq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzcq = null;
        }
        zzb = zzcq;
    }

    public static zzcq<?> zza() {
        return zza;
    }

    public static zzcq<?> zzb() {
        zzcq<?> zzcq = zzb;
        if (zzcq != null) {
            return zzcq;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
