package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
public enum zzsw implements zzahc {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);
    
    private static final zzahd zzg = null;
    private final int zzi;

    /* access modifiers changed from: public */
    static {
        zzg = new zzsv();
    }

    private zzsw(int i11) {
        this.zzi = i11;
    }

    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
