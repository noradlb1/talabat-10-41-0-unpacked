package com.google.android.gms.internal.ads;

final class zzgka {
    private static final zzgjy<?> zza = new zzgjz();
    private static final zzgjy<?> zzb;

    static {
        zzgjy<?> zzgjy;
        try {
            zzgjy = (zzgjy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgjy = null;
        }
        zzb = zzgjy;
    }

    public static zzgjy<?> zza() {
        zzgjy<?> zzgjy = zzb;
        if (zzgjy != null) {
            return zzgjy;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzgjy<?> zzb() {
        return zza;
    }
}
