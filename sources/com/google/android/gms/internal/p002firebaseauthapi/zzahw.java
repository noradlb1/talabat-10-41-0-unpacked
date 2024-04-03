package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahw  reason: invalid package */
final class zzahw implements zzaid {
    private final zzaid[] zza;

    public zzahw(zzaid... zzaidArr) {
        this.zza = zzaidArr;
    }

    public final zzaic zzb(Class cls) {
        zzaid[] zzaidArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzaid zzaid = zzaidArr[i11];
            if (zzaid.zzc(cls)) {
                return zzaid.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzaid[] zzaidArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzaidArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
