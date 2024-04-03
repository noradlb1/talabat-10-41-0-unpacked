package com.google.android.gms.internal.places;

final class zzas {
    private static final zzar<?> zzff = new zzat();
    private static final zzar<?> zzfg = zzar();

    private static zzar<?> zzar() {
        try {
            return (zzar) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static zzar<?> zzas() {
        return zzff;
    }

    public static zzar<?> zzat() {
        zzar<?> zzar = zzfg;
        if (zzar != null) {
            return zzar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
