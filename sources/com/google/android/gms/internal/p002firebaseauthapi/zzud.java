package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud  reason: invalid package */
public enum zzud implements zzahc {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzahd zzg = null;
    private final int zzi;

    /* access modifiers changed from: public */
    static {
        zzg = new zzuc();
    }

    private zzud(int i11) {
        this.zzi = i11;
    }

    public static zzud zzb(int i11) {
        if (i11 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i11 == 1) {
            return TINK;
        }
        if (i11 == 2) {
            return LEGACY;
        }
        if (i11 == 3) {
            return RAW;
        }
        if (i11 != 4) {
            return null;
        }
        return CRUNCHY;
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
