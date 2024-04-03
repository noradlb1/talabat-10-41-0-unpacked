package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrv  reason: invalid package */
public final class zzrv {
    private static final zzahd zza = new zzru();

    public static int zza(int i11) {
        if (i11 != 1) {
            return i11 - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int zzb(int i11) {
        if (i11 == 0) {
            return 2;
        }
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 4;
        }
        if (i11 == 3) {
            return 5;
        }
        if (i11 != 4) {
            return i11 != 5 ? 0 : 7;
        }
        return 6;
    }
}
