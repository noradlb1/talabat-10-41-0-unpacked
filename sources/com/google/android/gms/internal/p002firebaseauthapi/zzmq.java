package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmq  reason: invalid package */
public final class zzmq {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzmr zzc;

    private zzmq() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }

    public /* synthetic */ zzmq(zzmp zzmp) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzmr.zzd;
    }

    public final zzmq zza(int i11) throws GeneralSecurityException {
        if (i11 == 16 || i11 == 32) {
            this.zza = Integer.valueOf(i11);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i11 * 8)}));
    }

    public final zzmq zzb(int i11) throws GeneralSecurityException {
        if (i11 < 10 || i11 > 16) {
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i11);
        }
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zzmq zzc(zzmr zzmr) {
        this.zzc = zzmr;
        return this;
    }

    public final zzmt zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzmt(num.intValue(), this.zzb.intValue(), this.zzc, (zzms) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }
}
