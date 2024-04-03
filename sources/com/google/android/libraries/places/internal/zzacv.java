package com.google.android.libraries.places.internal;

final class zzacv {
    private static final zzacu zza;
    private static final zzacu zzb = new zzacu();

    static {
        zzacu zzacu;
        try {
            zzacu = (zzacu) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzacu = null;
        }
        zza = zzacu;
    }

    public static zzacu zza() {
        return zza;
    }

    public static zzacu zzb() {
        return zzb;
    }
}
