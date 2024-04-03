package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmf  reason: invalid package */
public final class zzmf extends RuntimeException {
    public zzmf(String str) {
        super(str);
    }

    public static Object zza(zzme zzme) {
        try {
            return zzme.zza();
        } catch (Exception e11) {
            throw new zzmf((Throwable) e11);
        }
    }

    public zzmf(String str, Throwable th2) {
        super("Creating a protokey serialization failed", th2);
    }

    public zzmf(Throwable th2) {
        super(th2);
    }
}
