package com.google.android.recaptcha.internal;

final class zzgt {
    private static final zzgr zza = new zzgs();
    private static final zzgr zzb;

    static {
        zzgr zzgr;
        try {
            zzgr = (zzgr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgr = null;
        }
        zzb = zzgr;
    }

    public static zzgr zza() {
        zzgr zzgr = zzb;
        if (zzgr != null) {
            return zzgr;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzgr zzb() {
        return zza;
    }
}
