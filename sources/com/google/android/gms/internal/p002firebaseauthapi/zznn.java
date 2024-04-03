package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznn  reason: invalid package */
public final class zznn {
    public static final zznn zza = new zznn("SHA1");
    public static final zznn zzb = new zznn("SHA224");
    public static final zznn zzc = new zznn("SHA256");
    public static final zznn zzd = new zznn("SHA384");
    public static final zznn zze = new zznn("SHA512");
    private final String zzf;

    private zznn(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
