package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjo  reason: invalid package */
final class zzjo implements zzjd {
    private final zzwf zza;
    private final zzwf zzb;

    private zzjo(byte[] bArr, byte[] bArr2) {
        this.zza = zzwf.zzb(bArr);
        this.zzb = zzwf.zzb(bArr2);
    }

    public static zzjo zzc(byte[] bArr) throws GeneralSecurityException {
        return new zzjo(bArr, zzwd.zzb(bArr));
    }

    public final zzwf zza() {
        return this.zza;
    }

    public final zzwf zzb() {
        return this.zzb;
    }
}
