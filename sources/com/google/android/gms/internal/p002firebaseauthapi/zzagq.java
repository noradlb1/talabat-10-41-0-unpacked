package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagq  reason: invalid package */
final class zzagq {
    private static final zzago zza = new zzagp();
    private static final zzago zzb;

    static {
        zzago zzago;
        try {
            zzago = (zzago) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzago = null;
        }
        zzb = zzago;
    }

    public static zzago zza() {
        zzago zzago = zzb;
        if (zzago != null) {
            return zzago;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzago zzb() {
        return zza;
    }
}
