package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
final class zzagv implements zzaid {
    private static final zzagv zza = new zzagv();

    private zzagv() {
    }

    public static zzagv zza() {
        return zza;
    }

    public final zzaic zzb(Class cls) {
        Class<zzaha> cls2 = zzaha.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzaic) zzaha.zzv(cls.asSubclass(cls2)).zzj(3, (Object) null, (Object) null);
            } catch (Exception e11) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e11);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzaha.class.isAssignableFrom(cls);
    }
}
