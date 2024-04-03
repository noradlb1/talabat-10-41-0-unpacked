package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajk  reason: invalid package */
public final class zzajk extends RuntimeException {
    public zzajk(zzaif zzaif) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzahi zza() {
        return new zzahi(getMessage());
    }
}
