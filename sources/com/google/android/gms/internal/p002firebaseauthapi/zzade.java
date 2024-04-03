package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzade  reason: invalid package */
public enum zzade {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzd;

    private zzade(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
