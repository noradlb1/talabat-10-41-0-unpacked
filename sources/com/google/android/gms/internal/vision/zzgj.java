package com.google.android.gms.internal.vision;

final class zzgj {
    private static final zzgf<?> zztf = new zzgh();
    private static final zzgf<?> zztg = zzfp();

    private static zzgf<?> zzfp() {
        try {
            return (zzgf) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static zzgf<?> zzfq() {
        return zztf;
    }

    public static zzgf<?> zzfr() {
        zzgf<?> zzgf = zztg;
        if (zzgf != null) {
            return zzgf;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
