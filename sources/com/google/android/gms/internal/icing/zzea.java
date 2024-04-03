package com.google.android.gms.internal.icing;

final class zzea {
    private static final zzdz zza;
    private static final zzdz zzb = new zzdz();

    static {
        zzdz zzdz;
        try {
            zzdz = (zzdz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdz = null;
        }
        zza = zzdz;
    }

    public static zzdz zza() {
        return zza;
    }

    public static zzdz zzb() {
        return zzb;
    }
}
