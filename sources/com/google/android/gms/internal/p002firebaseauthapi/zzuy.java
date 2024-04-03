package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy  reason: invalid package */
public final class zzuy implements zzbl {
    private final zzva zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzuw zzd;

    public zzuy(ECPublicKey eCPublicKey, byte[] bArr, String str, int i11, zzuw zzuw) throws GeneralSecurityException {
        zzjy.zzb(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzva(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzuw;
    }
}
