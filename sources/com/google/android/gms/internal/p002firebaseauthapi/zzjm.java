package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
final class zzjm implements zzjd {
    private final zzwf zza;
    private final zzwf zzb;

    private zzjm(byte[] bArr, byte[] bArr2) {
        this.zza = zzwf.zzb(bArr);
        this.zzb = zzwf.zzb(bArr2);
    }

    public static zzjm zzc(byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        zzvb.zzd(zzvb.zzh(zzvb.zzi(i11), 1, bArr2), zzvb.zzg(i11, bArr));
        return new zzjm(bArr, bArr2);
    }

    public final zzwf zza() {
        return this.zza;
    }

    public final zzwf zzb() {
        return this.zzb;
    }
}
