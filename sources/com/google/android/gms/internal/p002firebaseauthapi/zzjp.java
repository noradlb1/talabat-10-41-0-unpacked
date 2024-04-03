package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjp  reason: invalid package */
public final class zzjp {
    private final zzbd zza;
    private final zzbj zzb;

    public zzjp(zzbd zzbd) {
        this.zza = zzbd;
        this.zzb = null;
    }

    public zzjp(zzbj zzbj) {
        this.zza = null;
        this.zzb = zzbj;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbd zzbd = this.zza;
        if (zzbd != null) {
            return zzbd.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
